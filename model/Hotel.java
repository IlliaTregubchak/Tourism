package tourism.model;

public class Hotel {
    private long id;
    private String city;
    private int duration;
    private double price;
    private long tourist_id;

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

    public long getTourist_id() {
        return tourist_id;
    }

    public void setTourist_id(long tourist_id) {
        this.tourist_id = tourist_id;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", duration=" + duration +
                ", price=" + price +
                ", tourist_id=" + tourist_id +
                '}';
    }
}
