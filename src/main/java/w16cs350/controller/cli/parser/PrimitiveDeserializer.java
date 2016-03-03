package w16cs350.controller.cli.parser;

import w16cs350.controller.cli.parser.deserializers.CoordinatesDeltaDeserializer;
import w16cs350.controller.cli.parser.deserializers.CoordinatesWorldDeserializer;
import w16cs350.controller.cli.parser.deserializers.LatitudeLongitudeDeserializer;
import w16cs350.datatype.*;

import java.util.ListIterator;
/**
 * Created by RowleyJohn on 2/23/2016.
 */
public class PrimitiveDeserializer {

    /**
     * Consumes one or three tokens from the list iterator in the format of DEGREE*MINUTE'SECONDS",
     * and returns a Latitude * constructed from it.
     * @param tokens The token used to construct the Longitude
     * @return A Longitude constructed from the tokens.
     */
    public static Latitude parseLatitude(ListIterator<String> tokens){
        return LatitudeLongitudeDeserializer.parseLatitude(tokens);
    }

    /**
     * Consumes one or three tokens from the list iterator in the format of DEGREE*MINUTE'SECONDS",
     * and returns a Longitude * constructed from it.
     * @param tokens The token used to construct the Longitude
     * @return A Longitude constructed from the tokens.
     */
    public static Longitude parseLongitude(ListIterator<String> tokens){
        return LatitudeLongitudeDeserializer.parseLongitude(tokens);
    }

    /**
     * Returns true if the next token is a Latitude or a Longitude, or if the next three tokens
     * can make a Latitude or Longitude.
     * @param tokens The tokens to search for the lat / long in.
     * @return True if the next token is a Latitude or Longitude.
     */
    public static boolean isNextLatitudeLongitude(ListIterator<String> tokens){
        return LatitudeLongitudeDeserializer.isNextLatitudeLongitude(tokens);
    }

    /**
     * Returns true if the next three tokens in tokens is a CoordinatesWorld.
     * @param tokens The ListIterator containing the tokens to be checked.
     * @return True if the next three tokens make a valid CoordinatesWorld
     */
    public static boolean isNextCoordinatesWorld(ListIterator<String> tokens){
        return CoordinatesWorldDeserializer.isNextCoordinatesWorld(tokens);
    }

    /**
     * Consumes 3 tokens from the list iterator in the format of "LATITUDE", "/", "LONGITUDE" and returns a
     * CoordinatesWorld constructed from them.
     * @param tokens The tokens used to construct the CoordinatesWorld
     * @return A CoordinatesWorld constructed from the tokens.
     */
    public static CoordinatesWorld parseCoordinatesWorld(ListIterator<String> tokens){
        return CoordinatesWorldDeserializer.parseCoordinatesWorld(tokens);
    }

    /**
     * Consumes 3 tokens from the list iterator in the format of "NUMBER", ":", "NUMBER", and returns a CoordinatesDelta
     * constructed from them.
     * @param tokens The ListIterator containing the tokens.
     * @return The parsed CoordinatesDelta
     */
    public static CoordinatesDelta parseCoordinatesDelta(ListIterator<String> tokens){
        return CoordinatesDeltaDeserializer.parseCoordinatesDelta(tokens);
    }

    /**
     * Returns true if the next token is a valid Angle.
     * @param tokens the tokens to find the angle in.
     * @return True if the next token is a valid angle.
     */
    public static boolean isNextAngle(ListIterator<String> tokens) {
        String next = tokens.next();
        tokens.previous();

        try {
            Double.parseDouble(next);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
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

}
