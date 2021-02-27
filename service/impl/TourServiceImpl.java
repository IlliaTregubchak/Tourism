package tourism.service.impl;

import tourism.dao.TourDAO;
import tourism.dao.TouristDAO;
import tourism.dao.impl.TourDAOImpl;
import tourism.dao.impl.TouristDAOImpl;
import tourism.dto.tour.SaveTourDTO;
import tourism.dto.tour.TourDTO;
import tourism.dto.tour.UpdateTourDTO;
import tourism.dto.tourist.EditTouristDTO;
import tourism.service.TourService;

import java.util.List;

public class TourServiceImpl implements TourService {

    @Override
    public long save(SaveTourDTO saveTourDTO) {
        if(saveTourDTO == null) {
            throw new NullPointerException("Tour is null");
        }

        final TourDAO tourDAO = new TourDAOImpl();
        return tourDAO.save(saveTourDTO);
    }

    @Override
    public void update(UpdateTourDTO updateTourDTO, long id) {
        final TourDAO tourDAO = new TourDAOImpl();
        tourDAO.update(updateTourDTO, id);
    }

    @Override
    public List<TourDTO> findAll() {
        final TourDAO tourDAO = new TourDAOImpl();
        return tourDAO.findAll();
    }

    @Override
    public TourDTO findById(long id) {
        final TourDAO tourDAO = new TourDAOImpl();
        return tourDAO.findById(id);
    }

    @Override
    public List<TourDTO> findByTouristId(long touristId) {
        final TourDAO tourDAO = new TourDAOImpl();
        return tourDAO.findByTouristId(touristId);
    }

    @Override
    public void delete(long id) {
        final TourDAO tourDAO = new TourDAOImpl();
        tourDAO.delete(id);
    }

    @Override
    public void deleteByTouristId(long touristId) {
        final TourDAO tourDAO = new TourDAOImpl();
        tourDAO.deleteByTouristId(touristId);
    }
}
