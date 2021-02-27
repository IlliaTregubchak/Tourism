package tourism.model;

public class Tour {
    private long id;
    private String country;
    private String date;
    private String description;
    private boolean visaRequired;
    private long tourist_id;

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

    public long getTourist_id() {
        return tourist_id;
    }

    public void setTourist_id(long tourist_id) {
        this.tourist_id = tourist_id;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", visaRequired=" + visaRequired +
                ", tourist_id=" + tourist_id +
                '}';
    }
}
