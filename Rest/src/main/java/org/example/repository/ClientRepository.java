package org.example.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.emptity.Client;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Optional;

@Repository
public class ClientRepository {
    private static final String JDBCUrl ="jdbc:postgresql://localhost:5432/postgres?currentSchema=my_schema&user=postgres&password=lens07gada";
    private static final String insert = "INSERT clients (name_clients, username, password, email, basket_id) VALUES (?,?,?,?,?);";
    private static final String findById = "SELECT * FROM clients where id_client = ?";
    private static final String findByLogin = "SELECT * FROM clients where username = ?";

    public int singClient(Client client, int basketID){
        try (Connection connection = DriverManager.getConnection(JDBCUrl);
             PreparedStatement prepareStatement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS)) {
            prepareStatement.setString(1, client.getName());
            prepareStatement.setString(2, client.getLogin());
            prepareStatement.setString(3, client.getPassword());
            prepareStatement.setString(4, client.getEmail());
            prepareStatement.setInt(5, basketID);
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

    public Optional<Client> getClient(long id){
        try (Connection connection = DriverManager.getConnection(JDBCUrl);
             PreparedStatement prepareStatement = connection.prepareStatement(findById)) {
            prepareStatement.setInt(1, (int) id);
            ResultSet resultSet = prepareStatement.executeQuery();
            if (resultSet.next()) {
                int returnId = resultSet.getInt("id_client");
                String name = resultSet.getString("name_client");
                String login = resultSet.getString("login_client");
                String password = resultSet.getString("password_client");
                String email = resultSet.getString("email");
                int basketId = resultSet.getInt("basket_id");
                Client client = new Client(returnId, name, login, password, email, basketId);
                return Optional.of(client);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isClient(Client client) {
        try (Connection connection = DriverManager.getConnection(JDBCUrl);
             PreparedStatement prepareStatement = connection.prepareStatement(findByLogin)) {
            prepareStatement.setString(1, client.getLogin());
            ResultSet resultSet = prepareStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
