package org.example.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class BasketRepository {
    private static final String JDBCUrl = "jdbc:postgresql://localhost:5432/postgres?currentSchema=my_schema&user=postgres&password=lens07gada";
    private static final String insertSql = "INSERT INTO baskets (promocode) VALUES (?);";
    private static final String addSql = "INSERT INTO products_carts (id_cart, id_product, quantity) VALUES (?,?,?);";
    private static final String delete = "DELETE FROM products_carts where (id_product = ? AND id_cart = ?)";
    private int createBasket(){
        try (Connection connection = DriverManager.getConnection(JDBCUrl);
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, "");
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
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
