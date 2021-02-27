package tourism.service.impl;

import tourism.dao.TouristDAO;
import tourism.dao.impl.TouristDAOImpl;
import tourism.dto.tourist.EditTouristDTO;
import tourism.model.Tourist;
import tourism.service.HotelService;
import tourism.service.TourService;
import tourism.service.TouristService;

import java.util.List;

public class TouristServiceImpl implements TouristService {

    @Override
    public long save(EditTouristDTO tourist) {
        if (tourist == null) {
            throw new NullPointerException("Tourist is null");
        }
        final TouristDAO touristDAO = new TouristDAOImpl();
        return touristDAO.save(tourist);
    }

    @Override
    public void update(EditTouristDTO editTouristDTO, long id) {
        final TouristDAO touristDAO = new TouristDAOImpl();
        touristDAO.update(editTouristDTO, id);
    }

    @Override
    public List<Tourist> findAll() {
        final TouristDAO touristDAO = new TouristDAOImpl();
        return touristDAO.findAll();
    }

    @Override
    public Tourist findById(long id) {
        final TouristDAO touristDAO = new TouristDAOImpl();
        final Tourist tourist = touristDAO.findById(id);
        if (tourist == null) {
            throw new NullPointerException("Tourist is null");
        }
        return tourist;
    }

    @Override
    public boolean exists(String name) {
        final TouristDAO touristDAO = new TouristDAOImpl();
        final boolean exists = touristDAO.exists(name);
        if (exists) {
            throw new RuntimeException("Tourist with this name already exists");
        }
        return exists;
    }

    @Override
    public void delete(long id) {
        final HotelService hotelService = new HotelServiceImpl();
        hotelService.deleteByTouristId(id);

        final TourService tourService = new TourServiceImpl();
        tourService.deleteByTouristId(id);

        final TouristDAO touristDAO = new TouristDAOImpl();
        touristDAO.delete(id);
    }
}
