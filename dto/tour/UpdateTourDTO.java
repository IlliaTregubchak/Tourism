package tourism.dto.tour;

public class UpdateTourDTO {
    private String country;
    private String date;
    private String description;
    private boolean visaRequired;

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

    @Override
    public String toString() {
        return "UpdateTourDTO{" +
                "country='" + country + '\'' +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", visaRequired=" + visaRequired +
                '}';
    }
}
