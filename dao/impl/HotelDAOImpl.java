package tourism.dao.impl;

import tourism.config.DatabaseConfig;
import tourism.dao.HotelDAO;
import tourism.dto.hotel.HotelDTO;
import tourism.dto.hotel.SaveHotelDTO;
import tourism.dto.hotel.UpdateHotelDTO;
import tourism.dto.tour.TourDTO;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class HotelDAOImpl implements HotelDAO {

    private static final String INSERT_HOTEL = "insert into hotels(city, duration, price, tourist_id) VALUES(?,?,?,?)";
    private static final String UPDATE_HOTEL = "update hotels set city = ?, duration = ?, price = ? where id = ?";
    private static final String DELETE_HOTEL = "delete from hotels where id = ?";
    private static final String DELETE_BY_TOURIST_ID = "delete from hotels where tourist_id = ?";
    private static final String FIND_ALL = "select h.id, h.city, h.duration, h.price, t.name as touristName from hotels h, tourists t where h.tourist_id = t.id";
    private static final String FIND_BY_ID = "select h.id, h.city, h.duration, h.price, t.name as touristName from hotels h, tourists t where h.tourist_id = t.id and h.id = ?";
    private static final String FIND_BY_USER_ID = "select h.id, h.city, h.duration, h.price, t.name as touristName from hotels h, tourists t where h.tourist_id = t.id and h.tourist_id = ?";

    @Override
    public long save(SaveHotelDTO saveHotelDTO) {
        try {
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement(INSERT_HOTEL);
            preparedStatement.setString(1, saveHotelDTO.getCity());
            preparedStatement.setInt(2, saveHotelDTO.getDuration());
            preparedStatement.setDouble(3, saveHotelDTO.getPrice());
            preparedStatement.setLong(4, saveHotelDTO.getTourist_id());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void update(UpdateHotelDTO updateHotelDTO, long id) {
        try {
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_HOTEL);
            preparedStatement.setString(1, updateHotelDTO.getCity());
            preparedStatement.setInt(2, updateHotelDTO.getDuration());
            preparedStatement.setDouble(3, updateHotelDTO.getPrice());
            preparedStatement.setLong(4, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<HotelDTO> findAll() {
        List<HotelDTO> hotels = new LinkedList<>();

        try {
            final Connection connection = DatabaseConfig.connection;
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery(FIND_ALL);

            while (resultSet.next()) {
                final HotelDTO hotelDTO = getHotel(resultSet);
                hotels.add(hotelDTO);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hotels;
    }

    @Override
    public HotelDTO findById(long id) {
        final HotelDTO hotelDTO = new HotelDTO();
        try {
            final Connection connection = DatabaseConfig.connection;
            // створ preparedStatement для модифікації SQL-запиту
            final PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            // тип данних (setString, setInt), індекс (1) - порядковий номер знака питання, який потрібно замінити, значення, яке буде замість знака питання
            preparedStatement.setLong(1, id);
            final ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return getHotel(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotelDTO;
    }

    @Override
    public List<HotelDTO> findByUserId(long userId) {
        List<HotelDTO> hotelsByUser = new LinkedList<>();
        try {
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_USER_ID);
            preparedStatement.setLong(1, userId);
            final ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                final HotelDTO hotelDTO = getHotel(resultSet);
                hotelsByUser.add(hotelDTO);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotelsByUser;
    }

    @Override
    public void delete(long id) {
        try {
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement(DELETE_HOTEL);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteByTouristId(long touristId) {
        try {
            final Connection connection = DatabaseConfig.connection;
            final PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_TOURIST_ID);
            preparedStatement.setLong(1, touristId);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private HotelDTO getHotel(ResultSet resultSet) throws SQLException {
        final long id = resultSet.getLong("id");
        final String city = resultSet.getString("city");
        final int duration = resultSet.getInt("duration");
        final double price = resultSet.getDouble("price");
        final String touristName = resultSet.getString("touristName");

        final HotelDTO hotelDTO = new HotelDTO();
        hotelDTO.setId(id);
        hotelDTO.setCity(city);
        hotelDTO.setDuration(duration);
        hotelDTO.setPrice(price);
        hotelDTO.setTouristName(touristName);
        return hotelDTO;

    }

}
