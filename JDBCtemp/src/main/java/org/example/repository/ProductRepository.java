package org.example.repository;

import org.example.emptity.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private final JdbcTemplate jdbcTemplate;
    private static final String insert = "INSERT INTO products (name_product, price_product, quantity) VALUES(?, ?, ?);";
    private static final String findById = "SELECT * FROM products where id_product = ?";
    private static final String delete = "DELETE FROM products where id_product = ?";
    private static final  String findByName = "SELECT * FROM products where name_product = ?";

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Product> searchByName(String name) {
        PreparedStatementCreator preparedStatementCreator = connection -> {
            var prepareStatement = connection.prepareStatement(findByName);
            prepareStatement.setCursorName(name);
            return prepareStatement;
        };
        RowMapper<Product> productRowMapper = getProductRowMapper();
        List<Product> products = jdbcTemplate.query(preparedStatementCreator, productRowMapper);

        return products;
    }

    public long addProduct(Product product) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getValue());
            preparedStatement.setInt(3, product.getQuantity());

            return preparedStatement;
        };

        jdbcTemplate.update(preparedStatementCreator, keyHolder);

        return (long) keyHolder.getKeys().get("id_product");
    }

    public Optional<Product> searchProduct(long productId) {
        PreparedStatementCreator preparedStatementCreator = connection -> {
            var prepareStatement = connection.prepareStatement(findById);
            prepareStatement.setLong(1, productId);
            return prepareStatement;
        };
        RowMapper<Product> productRowMapper = getProductRowMapper();
        List<Product> products = jdbcTemplate.query(preparedStatementCreator, productRowMapper);

        return products.stream().findFirst();
    }

    private static RowMapper<Product> getProductRowMapper() {
        return (resultSet, rowNum) -> {
            int id = resultSet.getInt("id_product");
            String name = resultSet.getString("name_product");
            int value = resultSet.getInt("price_product");
            int quantity = resultSet.getInt("quantity");
            return new Product(id, name, value, quantity);
        };
    }

    public boolean deleteProduct(long id) {
        PreparedStatementCreator preparedStatementCreator = connection -> {
            var prepareStatement = connection.prepareStatement(delete);
            prepareStatement.setLong(1, id);

            return prepareStatement;
        };

        int rows = jdbcTemplate.update(preparedStatementCreator);

        return rows > 0;
    }

}