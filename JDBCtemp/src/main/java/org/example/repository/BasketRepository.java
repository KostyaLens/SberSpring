package org.example.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class BasketRepository {
    private final JdbcTemplate jdbcTemplate;
    private static final String insertSql = "INSERT INTO basket (promocode) VALUES (?);";
    private static final String addSql = "INSERT INTO products_carts (id_cart, id_product, quantity) VALUES (?,?,?);";
    private static final String delete = "DELETE FROM products_carts where (id_product = ? AND id_cart = ?)";

    public BasketRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int add(long productId, long basketId) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(addSql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, (int) productId);
            preparedStatement.setInt(2, (int) basketId);
            preparedStatement.setInt(3, 1);
            preparedStatement.executeUpdate();
            return preparedStatement;
        };

        jdbcTemplate.update(preparedStatementCreator, keyHolder);

        return (int) keyHolder.getKeys().get("id_products_carts");
    }

    public long create() {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, "");
            return preparedStatement;
        };

        jdbcTemplate.update(preparedStatementCreator, keyHolder);

        return (int) keyHolder.getKeys().get("id_cart");
    }


    public boolean deleteProductFromBasket(long binId, long productId) {
        PreparedStatementCreator preparedStatementCreator = connection -> {
            var prepareStatement = connection.prepareStatement(delete);
            prepareStatement.setInt(1, (int) binId);
            prepareStatement.setInt(2, (int) productId);

            int rows = prepareStatement.executeUpdate();
            return prepareStatement;
        };

        int rows = jdbcTemplate.update(preparedStatementCreator);

            return rows > 0;
    }
}