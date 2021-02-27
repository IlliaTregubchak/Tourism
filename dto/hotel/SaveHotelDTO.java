package tourism.dto.hotel;

public class SaveHotelDTO {

    private String city;
    private int duration;
    private double price;
    private long tourist_id;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getTourist_id() {
        return tourist_id;
    }

    public void setTourist_id(long tourist_id) {
        this.tourist_id = tourist_id;
    }

    @Override
    public String toString() {
        return "SaveHotelDTO{" +
                "city='" + city + '\'' +
                ", duration=" + duration +
                ", price=" + price +
                ", tourist_id=" + tourist_id +
                '}';
    }
}
