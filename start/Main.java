package tourism.start;

import tourism.config.DatabaseConfig;
import tourism.dto.hotel.HotelDTO;
import tourism.dto.hotel.SaveHotelDTO;
import tourism.dto.hotel.UpdateHotelDTO;
import tourism.dto.tour.SaveTourDTO;
import tourism.dto.tour.TourDTO;
import tourism.dto.tour.UpdateTourDTO;
import tourism.dto.tourist.EditTouristDTO;
import tourism.model.Tourist;
import tourism.service.TourService;
import tourism.service.TouristService;
import tourism.service.impl.HotelServiceImpl;
import tourism.service.impl.TourServiceImpl;
import tourism.service.impl.TouristServiceImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        DatabaseConfig.connect();

//      touristAction();

//        tourAction();

//        hotelAction();

        DatabaseConfig.close();

    }

    private static void touristAction() {
        final TouristService touristService = new TouristServiceImpl();

        final EditTouristDTO editTouristDTO = new EditTouristDTO();

//        editTouristDTO.setName("Joshua Tree");
//        editTouristDTO.setAddress("Cork Str 11, Dublin");
//        editTouristDTO.setAge(56);
//        editTouristDTO.setNationality("Ireland");
//
//        final long id = touristService.save(editTouristDTO);
//
//        System.out.println(id);

//        editTouristDTO.setName("Joshua Oak Tree");
//        editTouristDTO.setAddress("Cork Str 99, Aberdeen");
//        editTouristDTO.setAge(57);
//        editTouristDTO.setNationality("Scotland");
//
//        touristService.update(editTouristDTO, 8);

//        final List<Tourist> tourists = touristService.findAll();
//
//        for (Tourist elem : tourists) {
//            System.out.println(elem.toString());
//        }

//        final Tourist touristById = touristService.findById(5);
//        System.out.println(touristById);

//        touristService.delete(8);

//        final boolean exists = touristService.exists("John Brown");
//        if(!exists) {
//            touristService.save(editTouristDTO);
//        }
//        System.out.println(exists);
    }

    private static void tourAction() {
        final TourService tourService = new TourServiceImpl();
//        final SaveTourDTO saveTourDTO = new SaveTourDTO();
//        saveTourDTO.setCountry("Hungary");
//        saveTourDTO.setDate("2020-12-15");
//        saveTourDTO.setDescription("7 days country tour");
//        saveTourDTO.setVisaRequired(false);
//        saveTourDTO.setTourist_id(5);
//        final long id2 = tourService.save(saveTourDTO);
//        System.out.println(id2);

//        final UpdateTourDTO updateTourDTO = new UpdateTourDTO();
//        updateTourDTO.setCountry("Honduras");
//        updateTourDTO.setDescription("14 days exotic tour");
//        updateTourDTO.setDate("2020-09-01");
//        updateTourDTO.setVisaRequired(true);
//        tourService.update(updateTourDTO, 5);

//        tourService.delete(7);

//        final List<TourDTO> tours = tourService.findAll();
//        for (TourDTO elem : tours) {
//            System.out.println(elem.toString());
//        }

//        final TourDTO tourDTO = tourService.findById(3);
//        System.out.println(tourDTO);

//        final List<TourDTO> toursByUser = tourService.findByUserId(4);
//        for (TourDTO elem : toursByUser) {
//            System.out.println(elem.toString());
//        }

    }

    private static void hotelAction() {
        final HotelServiceImpl hotelService = new HotelServiceImpl();
//        final SaveHotelDTO saveHotelDTO = new SaveHotelDTO();
//        saveHotelDTO.setCity("Nairobi");
//        saveHotelDTO.setDuration(10);
//        saveHotelDTO.setPrice(1099.99);
//        saveHotelDTO.setTourist_id(2);
//        hotelService.save(saveHotelDTO);

//        final UpdateHotelDTO updateHotelDTO = new UpdateHotelDTO();
//        updateHotelDTO.setCity("Kinshasa");
//        updateHotelDTO.setDuration(7);
//        updateHotelDTO.setPrice(789.99);
//        hotelService.update(updateHotelDTO, 7);

//        hotelService.delete(8);

//        final List<HotelDTO> hotels = hotelService.findAll();
//        for (HotelDTO elem : hotels) {
//            System.out.println(elem.toString());

//        final HotelDTO hotelDTO = hotelService.findById(4);
//        System.out.println(hotelDTO);

//        final List<HotelDTO> hotelsByUser = hotelService.findByUserId(5);
//        for (HotelDTO elem : hotelsByUser) {
//            System.out.println(elem.toString());
//        }
    }
    }


