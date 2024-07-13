package org.example.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.emptity.Client;
import org.example.emptity.Product;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private static final String JDBCUrl = "jdbc:h2:mem:testdb";
    private static final String insert = "INSERT INTO products (name_product, value_product, quantity) VALUES(?, ?, ?);";
    private static final String findById = "SELECT * FROM products where id_product = ?";

    private static final String delete = "DELETE FROM products where id_product = ?";
    private static final  String findByName = "SELECT * FROM products where name_product = ?";

    public long addProduct(Product product) {
        try (Connection connection = DriverManager.getConnection(JDBCUrl); PreparedStatement prepareStatement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS)) {
            prepareStatement.setString(1, product.getName());
            prepareStatement.setInt(2, product.getValue());
            prepareStatement.setInt(3, product.getQuantity());

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

    public Product searchProduct(long id) {
        try (Connection connection = DriverManager.getConnection(JDBCUrl); PreparedStatement prepareStatement = connection.prepareStatement(findById)) {
            prepareStatement.setInt(1, (int) id);
            ResultSet resultSet = prepareStatement.executeQuery();
            if (resultSet.next()) {
                int returnId = resultSet.getInt("id_product");
                String name = resultSet.getString("name_product");
                int value = resultSet.getInt("value_product");
                int quantity = resultSet.getInt("quantity");
                Product product = new Product(returnId, name, value, quantity);
                return product;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteProduct(long id) {
        try (Connection connection = DriverManager.getConnection(JDBCUrl); PreparedStatement prepareStatement = connection.prepareStatement(delete)) {
            prepareStatement.setInt(1, (int) id);
            int rows = prepareStatement.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> searchByName(String name) {
        try (Connection connection = DriverManager.getConnection(JDBCUrl); PreparedStatement prepareStatement = connection.prepareStatement(findByName)) {
            prepareStatement.setString(1, name);
            ResultSet resultSet = prepareStatement.executeQuery();
            List<Product> products = new ArrayList<Product>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_product");
                String productName = resultSet.getString("name_product");
                int value = resultSet.getInt("value_product");
                int quantity = resultSet.getInt("quantity");
                Product product = new Product(id, productName, value, quantity);
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
