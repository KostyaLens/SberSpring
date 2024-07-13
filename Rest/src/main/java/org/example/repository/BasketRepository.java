package org.example.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class BasketRepository {
    private static final String JDBCUrl = "jdbc:h2:mem:testdb";

    private static final String insertSql = "INSERT INTO baskets (promocode) VALUES (?);";
    private static final String addSql = "INSERT INTO products_baskets (id_product, id_basket, quantity) VALUES(?, ?, ?);";
    private static final String delete = "DELETE FROM products_bins where (id_product = ? AND id_basket = ?)";
    private int createBasket(){
        try (Connection connection = DriverManager.getConnection(JDBCUrl);
             PreparedStatement prepareStatement = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {
            prepareStatement.setString(1, "");

            prepareStatement.executeUpdate();
            ResultSet rs = prepareStatement.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                throw new RuntimeException("Ошибка при получении идентификатора");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int add(long idProduct, long idBasket) {
        try (Connection connection = DriverManager.getConnection(JDBCUrl);
             PreparedStatement prepareStatement = connection.prepareStatement(addSql, Statement.RETURN_GENERATED_KEYS)) {
            prepareStatement.setInt(1, (int) idProduct);
            prepareStatement.setInt(2, (int) idBasket);
            prepareStatement.setInt(3, 1);
            prepareStatement.executeUpdate();
            ResultSet rs = prepareStatement.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                throw new RuntimeException("Ошибка при получении идентификатора");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteProductFromBasket(long binId, long productId) {
        try (Connection connection = DriverManager.getConnection(JDBCUrl);
             PreparedStatement prepareStatement = connection.prepareStatement(delete)) {
            prepareStatement.setInt(1, (int) productId);
            prepareStatement.setInt(2, (int) binId);
            int rows = prepareStatement.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
