package tourism.dto.tour;

public class TourDTO {

    private long id;
    private String country;
    private String date;
    private String description;
    private boolean visaRequired;
    private String touristName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isVisaRequired() {
        return visaRequired;
    }

    public void setVisaRequired(boolean visaRequired) {
        this.visaRequired = visaRequired;
    }

    public String getTouristName() {
        return touristName;
    }

    public void setTouristName(String touristName) {
        this.touristName = touristName;
    }

    @Override
    public String toString() {
        return "TourDTO{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", visaRequired=" + visaRequired +
                ", touristName='" + touristName + '\'' +
                '}';
    }
}
