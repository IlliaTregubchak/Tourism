package tourism.service;

import tourism.dto.tourist.EditTouristDTO;
import tourism.model.Tourist;

import java.util.List;

public interface TouristService {

    long save(EditTouristDTO tourist);

    void update(EditTouristDTO editTouristDTO, long id);

    List<Tourist> findAll();

    Tourist findById(long id);

    boolean exists(String name);

    void delete(long id);

}
