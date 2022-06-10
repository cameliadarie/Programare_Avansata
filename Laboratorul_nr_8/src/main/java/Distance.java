import world.Rows;


import java.sql.SQLException;


public class Distance {
    /**
     * I calculate the distance between 2 cities when I know their lat and lon
     *
     * @param entities
     * @param firstCity
     * @param secondCity
     * @throws SQLException
     */
    public static void get(AllClassesDAO entities, Rows firstCity, Rows secondCity) throws SQLException {

        Double firstCityLat = entities.getLatitude(firstCity);
        Double firstCityLon = entities.getLongitude(firstCity);

        Double secondCityLat = entities.getLatitude(secondCity);
        Double secondCityLon = entities.getLongitude(secondCity);

        if (firstCityLat == null || secondCityLat == null || firstCityLon == null || secondCityLon == null)
            System.out.println("Distance cannot be calculated. One of the cities has a null value in its coordinates.");
        else {
            firstCityLon = Math.toRadians(firstCityLon);
            secondCityLon = Math.toRadians(secondCityLon);
            firstCityLat = Math.toRadians(firstCityLat);
            secondCityLat = Math.toRadians(secondCityLat);

            double degreeLon = secondCityLon - firstCityLon;
            double degreeLat = secondCityLat - firstCityLat;
            double variance = Math.pow(Math.sin(degreeLat / 2), 2)
                    + Math.cos(firstCityLat)
                    * Math.cos(secondCityLat)
                    * Math.pow(Math.sin(degreeLon / 2), 2);

            double varianceCirc = 2 * Math.asin(Math.sqrt(variance));
            double radiusKm = 6371;


            System.out.printf("The distance between %s and %s: %.2f kilometers", firstCity,
                    secondCity, varianceCirc * radiusKm);
        }
    }
}