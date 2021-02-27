package tourism.service;

import tourism.dto.tour.SaveTourDTO;
import tourism.dto.tour.TourDTO;
import tourism.dto.tour.UpdateTourDTO;
import tourism.dto.tourist.EditTouristDTO;

import java.util.List;

public interface TourService {

    long save(SaveTourDTO saveTourDTO);

    void update(UpdateTourDTO updateTourDTO, long id);

    List<TourDTO> findAll();

    TourDTO findById(long id);

    List<TourDTO> findByTouristId(long touristId);

    void delete(long id);

    void deleteByTouristId(long touristId);

}
