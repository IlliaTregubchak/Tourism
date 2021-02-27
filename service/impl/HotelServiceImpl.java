package tourism.service.impl;

import tourism.dao.HotelDAO;
import tourism.dao.impl.HotelDAOImpl;
import tourism.dto.hotel.HotelDTO;
import tourism.dto.hotel.SaveHotelDTO;
import tourism.dto.hotel.UpdateHotelDTO;
import tourism.service.HotelService;

import java.util.List;

public class HotelServiceImpl implements HotelService {

    @Override
    public long save(SaveHotelDTO saveHotelDTO) {
        if(saveHotelDTO == null) {
            throw new NullPointerException("Hotel is null");
        }
        final HotelDAO hotelDAO = new HotelDAOImpl();
        return hotelDAO.save(saveHotelDTO);
    }

    @Override
    public void update(UpdateHotelDTO updateHotelDTO, long id) {
        final HotelDAO hotelDAO = new HotelDAOImpl();
        hotelDAO.update(updateHotelDTO, id);
    }

    @Override
    public List<HotelDTO> findAll() {
        final HotelDAO hotelDAO = new HotelDAOImpl();
        return hotelDAO.findAll();
    }

    @Override
    public HotelDTO findById(long id) {
        final HotelDAO hotelDAO = new HotelDAOImpl();
        return hotelDAO.findById(id);
    }

    @Override
    public List<HotelDTO> findByUserId(long userId) {
        final HotelDAO hotelDAO = new HotelDAOImpl();
        return hotelDAO.findByUserId(userId);
    }

    @Override
    public void delete(long id) {
        final HotelDAO hotelDAO = new HotelDAOImpl();
        hotelDAO.delete(id);
    }

    @Override
    public void deleteByTouristId(long touristId) {
        final HotelDAOImpl hotelDAO = new HotelDAOImpl();
        hotelDAO.deleteByTouristId(touristId);
    }
}
