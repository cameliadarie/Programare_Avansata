package world;

import Db.InfoTable;

/**
 * This class models a row in the city table. It has a country that it is in, whether it is a capital or not, latitude and longitude
 */
public class City extends Rows {
    String country;
    Boolean capital;
    Double latitude;
    Double longitude;

    public City(InfoTable infoTable) {
        Rows.infoTable = infoTable;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getCapital() {
        return capital;
    }

    public void setCapital(Boolean capital) {
        this.capital = capital;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "[id = " + id +
                ", name = '" + name + '\'' +
                ", country='" + country + '\'' +
                ", capital=" + capital +
                ", latitude = '" + latitude + '\'' +
                ", longitude = '" + longitude + '\'' +
                ']' + "\n";
    }
}