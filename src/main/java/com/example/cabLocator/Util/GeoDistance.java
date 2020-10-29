package com.example.cabLocator.util;

public class GeoDistance {
    public static double distance(double latitude1,
                                  double latitude2, double longitude1,
                                  double longitude2)
    {
        longitude1 = Math.toRadians(longitude1);
        longitude2 = Math.toRadians(longitude2);
        latitude1 = Math.toRadians(latitude1);
        latitude2 = Math.toRadians(latitude2);

        double longDiff = longitude2 - longitude1;
        double latDiff = latitude2 - latitude1;
        double a = Math.pow(Math.sin(latDiff / 2), 2)
                + Math.cos(latitude1) * Math.cos(latitude2)
                * Math.pow(Math.sin(longDiff / 2),2);

        double seg = 2 * Math.asin(Math.sqrt(a));
        double rds = 6371;

        return(seg * rds);
    }


}
