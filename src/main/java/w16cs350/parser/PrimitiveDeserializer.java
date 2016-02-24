package w16cs350.parser;

import w16cs350.datatype.CoordinatesWorld;
import w16cs350.datatype.Latitude;
import w16cs350.datatype.Longitude;

import java.util.ListIterator;

/**
 * Created by RowleyJohn on 2/23/2016.
 */
public class PrimitiveDeserializer {
    public static Latitude parseLatitude(ListIterator<String> tokens){
        String degree = tokens.next();
        tokens.next();
        String minutes = tokens.next();
        tokens.next();
        String seconds = tokens.next();
        return new Latitude(Integer.parseInt(degree),Integer.parseInt(minutes),Double.parseDouble(seconds));
    }

    public static Longitude parseLongitude(ListIterator<String> tokens){
        String degree = tokens.next();
        tokens.next();
        String minutes = tokens.next();
        tokens.next();
        String seconds = tokens.next();
        return new Longitude(Integer.parseInt(degree),Integer.parseInt(minutes),Double.parseDouble(seconds));
    }

    public static CoordinatesWorld parseWorldCoordinates(ListIterator<String> tokens){
        Latitude lat = parseLatitude(tokens);
        tokens.next();
        Longitude lon = parseLongitude(tokens);
        return new CoordinatesWorld(lat,lon);
    }
}
