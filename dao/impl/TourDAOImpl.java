package tourism.dao.impl;

import tourism.config.DatabaseConfig;
import tourism.dao.TourDAO;
import tourism.dto.tour.SaveTourDTO;
import tourism.dto.tour.TourDTO;
import tourism.dto.tour.UpdateTourDTO;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class TourDAOImpl implements TourDAO {

    private static final String INSERT_TOUR = "insert into tours(country, date, description, visa_required, tourist_id) VALUES(?,?,?,?,?)";
    private static final String UPDATE_TOUR = "update tours set country = ?, date = ?, description = ?, visa_required = ? where id = ?";
    private static final String DELETE_TOUR = "delete from tours where id = ?";
    private static final String DELETE_BY_TOURIST_ID = "delete from tours where tourist_id = ?";
    private static final String FIND_ALL = "select t.id, t.country, t.date, t.description, t.visa_required, q.name as touristName from tours t, tourists q where t.tourist_id = q.id";
    private static final String FIND_BY_ID = "select t.id, t.country, t.date, t.description, t.visa_required, q.name as touristName from tours t, tourists q where t.tourist_id = q.id and t.id = ?";
    private static final String FIND_BY_TOURIST_ID = "select t.id, t.country, t.date, t.description, t.visa_required, q.name as touristName from tours t, tourists q where t.tourist_id = q.id and t.tourist_id = ?";

    @Override
    public long save(SaveTourDTO saveTourDTO) {
        try{
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TOUR);
            preparedStatement.setString(1, saveTourDTO.getCountry());
            preparedStatement.setString(2, saveTourDTO.getDate());
            preparedStatement.setString(3, saveTourDTO.getDescription());
            preparedStatement.setBoolean(4, saveTourDTO.isVisaRequired());
            preparedStatement.setLong(5, saveTourDTO.getTourist_id());
            preparedStatement.execute();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void update(UpdateTourDTO updateTourDTO, long id) {
        try {
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TOUR);
            preparedStatement.setString(1, updateTourDTO.getCountry());
            preparedStatement.setString(2, updateTourDTO.getDate());
            preparedStatement.setString(3, updateTourDTO.getDescription());
            preparedStatement.setBoolean(4, updateTourDTO.isVisaRequired());
            preparedStatement.setLong(5, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TourDTO> findAll() {
        List<TourDTO> tours = new LinkedList<>();
        try {
            final Connection connection = DatabaseConfig.connection;
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery(FIND_ALL);

            while(resultSet.next()) {
                final TourDTO tourDTO = getTour(resultSet);
                tours.add(tourDTO);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tours;
    }

    @Override
    public TourDTO findById(long id) {
        final TourDTO tourDTO = new TourDTO();
        try {
            final Connection connection = DatabaseConfig.connection;
            // створ preparedStatement для модифікації SQL-запиту
            final PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            // тип данних (setString, setInt), індекс (1) - порядковий номер знака питання, який потрібно замінити, значення, яке буде замість знака питання
            preparedStatement.setLong(1, id);
            final ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return getTour(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tourDTO;
    }

    @Override
    public List<TourDTO> findByTouristId(long touristId) {
        List<TourDTO> toursByUser = new LinkedList<>();
        try{
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_TOURIST_ID);
            preparedStatement.setLong(1, touristId);
            final ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                final TourDTO tourDTO = getTour(resultSet);
                toursByUser.add(tourDTO);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }
        return toursByUser;
    }

    @Override
    public void delete(long id) {
        try{
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TOUR);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteByTouristId(long touristId) {
        try{
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_TOURIST_ID);
            preparedStatement.setLong(1, touristId);
            preparedStatement.execute();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private TourDTO getTour(ResultSet resultSet) throws SQLException {
        final long id = resultSet.getLong("id");
        final String country = resultSet.getString("country");
        final String date = resultSet.getString("date");
        final String description = resultSet.getString("description");
        final boolean isVisaRequired = resultSet.getBoolean("visa_required");
        final String touristName = resultSet.getString("touristName");

        final TourDTO tourDTO = new TourDTO();
        tourDTO.setId(id);
        tourDTO.setCountry(country);
        tourDTO.setDate(date);
        tourDTO.setDescription(description);
        tourDTO.setVisaRequired(isVisaRequired);
        tourDTO.setTouristName(touristName);
        return tourDTO;
    }

}
