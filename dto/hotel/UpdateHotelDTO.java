package tourism.dto.hotel;

public class UpdateHotelDTO {
    private String city;
    private int duration;
    private double price;

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

    @Override
    public String toString() {
        return "UpdateHotelDTO{" +
                "city='" + city + '\'' +
                ", duration=" + duration +
                ", price=" + price +
                '}';
    }
}
