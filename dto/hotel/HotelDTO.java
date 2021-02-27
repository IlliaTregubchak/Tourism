package tourism.dto.hotel;

public class HotelDTO {
    private long id;
    private String city;
    private int duration;
    private double price;
    private String touristName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getTouristName() {
        return touristName;
    }

    public void setTouristName(String touristName) {
        this.touristName = touristName;
    }

    @Override
    public String toString() {
        return "HotelDTO{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", duration=" + duration +
                ", price=" + price +
                ", touristName='" + touristName + '\'' +
                '}';
    }
}
