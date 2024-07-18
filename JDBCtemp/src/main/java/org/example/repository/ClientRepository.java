package org.example.repository;

import org.example.emptity.Client;
import org.example.services.BasketService;
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
public class ClientRepository {
    private final JdbcTemplate jdbcTemplate;
    private static final String insert = "INSERT INTO clients (name_clients, username, password, email, basket_id) VALUES (?,?,?,?,?);";
    private static final String findById = "SELECT * FROM clients where id_client = ?";

    public ClientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public long singClient(Client client) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        BasketRepository basketRepository = new BasketRepository(jdbcTemplate);
        BasketService basketService = new BasketService(basketRepository);
        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getLogin());
            preparedStatement.setString(3, client.getPassword());
            preparedStatement.setString(4, client.getEmail());
            preparedStatement.setInt(5, (int) basketService.addId());
            return preparedStatement;
        };

        jdbcTemplate.update(preparedStatementCreator, keyHolder);

        return (int) keyHolder.getKeys().get("id_clients");
    }

    private static RowMapper<Client> getProductRowMapper() {
        return (resultSet, rowNum) -> {
            int id = resultSet.getInt("id_clients");
            String name = resultSet.getString("name_clients");
            String login = resultSet.getString("username");
            String password = resultSet.getString("password");
            String emaill = resultSet.getString("email");
            Integer basket = resultSet.getInt("basket_id");
            return new Client(id, name, login, password, emaill, basket);
        };
    }


    public Optional<Client> findById(long clientId) {
        PreparedStatementCreator preparedStatementCreator = connection -> {
            var prepareStatement = connection.prepareStatement(findById);
            prepareStatement.setLong(1, clientId);

            return prepareStatement;
        };

        RowMapper<Client> productRowMapper = getProductRowMapper();

        List<Client> clients = jdbcTemplate.query(preparedStatementCreator, productRowMapper);

        return clients.stream().findFirst();
    }

}