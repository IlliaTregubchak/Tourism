package tourism.dao.impl;

import tourism.config.DatabaseConfig;
import tourism.dao.TouristDAO;
import tourism.dto.tourist.EditTouristDTO;
import tourism.model.Tourist;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class TouristDAOImpl implements TouristDAO {

    private static final String INSERT_INTO_TOURISTS = "insert into tourists(name, address, age, nationality) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_TOURIST = "update tourists set name = ?, address = ?, age = ?, nationality = ? where id = ?";
    private static final String SELECT_ALL_TOURISTS = "select * from tourists";
    private static final String SELECT_TOURIST_BY_ID = "select * from tourists where id = ?";
    private static final String IF_NAME_EXISTS = "select * from tourists where name = ?";
    private static final String DELETE_TOURIST = "delete from tourists where id = ?";

    @Override
    public long save(EditTouristDTO editTouristDTO) {
        try {
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_TOURISTS);
            preparedStatement.setString(1, editTouristDTO.getName());
            preparedStatement.setString(2, editTouristDTO.getAddress());
            preparedStatement.setInt(3, editTouristDTO.getAge());
            preparedStatement.setString(4, editTouristDTO.getNationality());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void update(EditTouristDTO editTouristDTO, long id) {
        try {
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TOURIST);
            preparedStatement.setString(1, editTouristDTO.getName());
            preparedStatement.setString(2, editTouristDTO.getAddress());
            preparedStatement.setInt(3, editTouristDTO.getAge());
            preparedStatement.setString(4, editTouristDTO.getNationality());
            preparedStatement.setLong(5, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Tourist> findAll() {
        List<Tourist> tourists = new LinkedList<>();
        try {
            final Connection connection = DatabaseConfig.connection;
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery(SELECT_ALL_TOURISTS);

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                int age = resultSet.getInt("age");
                String nationality = resultSet.getString("nationality");

                final Tourist tourist = new Tourist();
                tourist.setId(id);
                tourist.setName(name);
                tourist.setAddress(address);
                tourist.setAge(age);
                tourist.setNationality(nationality);

                tourists.add(tourist);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tourists;
    }

    @Override
    public Tourist findById(long id) {
        try {
            final Tourist tourist = new Tourist();
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TOURIST_BY_ID);
            preparedStatement.setLong(1, id);
            final ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                final long touristId = resultSet.getLong("id");
                final String name = resultSet.getString("name");
                final String address = resultSet.getString("address");
                final int age = resultSet.getInt("age");
                final String nationality = resultSet.getString("nationality");

                tourist.setId(touristId);
                tourist.setName(name);
                tourist.setAddress(address);
                tourist.setAge(age);
                tourist.setNationality(nationality);

                return tourist;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    public boolean exists(String name) {
        try {
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement(IF_NAME_EXISTS);
            preparedStatement.setString(1, name);
            final ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void delete(long id) {
        try {
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TOURIST);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
