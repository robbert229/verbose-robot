package w16cs350.parser;

import w16cs350.datatype.*;

import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by RowleyJohn on 2/23/2016.
 */
public class PrimitiveDeserializer {
    private static Pattern latlonPattern = Pattern.compile("([0-9]*)\\*([0-9]*)\\'([0-9]*)\"");

    /**
     * Consumes 1 token from the list iterator in the format of DEGREE*MINUTE'SECONDS", and returns a Latitude
     * constructed from it.
     * @param tokens The token used to construct the Latitude
     * @return A Latitude constructed from the tokens.
     */
    public static Latitude parseLatitude(ListIterator<String> tokens){
        String raw = tokens.next();

        Matcher m = latlonPattern.matcher(raw);
        if(m.find()) {

            int degree = Integer.parseInt(m.group(1));
            int minutes = Integer.parseInt(m.group(2));
            double seconds = Double.parseDouble(m.group(3));

            return new Latitude(degree, minutes, seconds);
        } else {
            throw new RuntimeException("Doesn't Match Regex: " + raw);
        }
    }

    /**
     * Consumes 1 token from the list iterator in the format of DEGREE*MINUTE'SECONDS", and returns a Longitude
     * constructed from it.
     * @param tokens The token used to construct the Longitude
     * @return A Longitude constructed from the tokens.
     */
    public static Longitude parseLongitude(ListIterator<String> tokens){
        String raw = tokens.next();

        Matcher m = latlonPattern.matcher(raw);
        if(m.find()) {

            int degree = Integer.parseInt(m.group(1));
            int minutes = Integer.parseInt(m.group(2));
            double seconds = Double.parseDouble(m.group(3));

            return new Longitude(degree, minutes, seconds);
        } else {
            throw new RuntimeException("Doesn't Match Regex: " + raw);
        }
    }

    /**
     * Consumes 3 tokens from the list iterator in the format of "LATITUDE", "/", "LONGITUDE" and returns a
     * CoordinatesWorld constructed from them.
     * @param tokens The tokens used to construct the CoordinatesWorld
     * @return A CoordinatesWorld constructed from the tokens.
     */
    public static CoordinatesWorld parseCoordinatesWorld(ListIterator<String> tokens){
        Latitude lat = parseLatitude(tokens);
        tokens.next();
        Longitude lon = parseLongitude(tokens);
        return new CoordinatesWorld(lat,lon);
    }

    /**
     * Consumes a single token from the list iterator in the format of "NUMBER", and returns an Angle constructed from
     * it.
     * @param tokens The ListIterator containing the tokens.
     * @return Returns the Angle from the parsed input.
     */
    public static Angle parseAngle(ListIterator<String> tokens){
        double angle = Double.parseDouble(tokens.next());
        return new Angle(angle);
    }

    /**
     * Consumes 3 tokens from the list iterator in the format of "NUMBER", ":", "NUMBER", and returns a CoordinatesDelta
     * constructed from them.
     * @param tokens The ListIterator containing the tokens.
     * @return The parsed CoordinatesDelta
     */
    public static CoordinatesDelta parseCoordinatesDelta(ListIterator<String> tokens){
        double xCoordinates = Double.parseDouble(tokens.next());
        tokens.next();
        double yCoordinates = Double.parseDouble(tokens.next());

        return new CoordinatesDelta(xCoordinates, yCoordinates);
    }
}
