package tourism.service;

import tourism.dto.hotel.HotelDTO;
import tourism.dto.hotel.SaveHotelDTO;
import tourism.dto.hotel.UpdateHotelDTO;

import java.util.List;

public interface HotelService {

    long save(SaveHotelDTO saveHotelDTO);

    void update(UpdateHotelDTO updateHotelDTO, long id);

    List<HotelDTO> findAll();

    HotelDTO findById(long id);

    List<HotelDTO> findByUserId(long userId);

    void delete(long id);

    void deleteByTouristId(long touristId);

}
