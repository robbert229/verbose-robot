package w16cs350.controller.cli.parser;

import w16cs350.controller.cli.TrackLocator;
import w16cs350.controller.cli.parser.deserializers.CoordinatesDeltaDeserializer;
import w16cs350.controller.cli.parser.deserializers.CoordinatesWorldDeserializer;
import w16cs350.controller.cli.parser.deserializers.LatitudeLongitudeDeserializer;
import w16cs350.controller.command.PointLocator;
import w16cs350.datatype.*;
import w16cs350.support.Assert;

import java.util.ArrayList;
import java.util.List;
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
     * Calculates the origin from given coordinates and distance
     *
     * @param reference      - the world reference coords
     * @param deltaStart     - start coordinates
     * @param deltaEnd       - end coordinates
     * @param distanceOrigin - distance (positive or negative)
     * @return -- the origin delta coordinates
     */
    public static CoordinatesDelta getOrigin(CoordinatesWorld reference, CoordinatesDelta deltaStart, CoordinatesDelta deltaEnd, double distanceOrigin) {

        double halfdistance = deltaStart.calculateDistance(deltaEnd) / 2.0D;
        Angle bearing = deltaStart.calculateBearing(deltaEnd);
        CoordinatesDelta midPoint = deltaStart.calculateTarget(bearing, halfdistance);
        Angle angleToOrigin;
        if (distanceOrigin < 0)
            angleToOrigin = bearing.subtract(Angle.ANGLE_090);
        else
            angleToOrigin = bearing.add(Angle.ANGLE_090);
        double positiveDistance = Math.abs(distanceOrigin);
        return midPoint.calculateTarget(angleToOrigin, positiveDistance);
    }

    /**
     * Returns true if the next token is a Latitude or a Longitude, or if the next three tokens
     * can make a Latitude or Longitude.
     *
     * @param tokens The tokens to search for the lat / long in.
     * @return True if the next token is a Latitude or Longitude.
     */
    public static boolean isNextLatitudeLongitude(ListIterator<String> tokens) {
        return LatitudeLongitudeDeserializer.isNextLatitudeLongitude(tokens);
    }

    /**
     * Returns true if the next three tokens in tokens is a CoordinatesWorld.
     * @param tokens The ListIterator containing the tokens to be checked.
     * @return True if the next three tokens make a valid CoordinatesWorld
     */
    public static boolean isNextCoordinatesWorld(ListIterator<String> tokens) {
        return CoordinatesWorldDeserializer.isNextCoordinatesWorld(tokens);
    }

    /**
     * Consumes 3 tokens from the list iterator in the format of "LATITUDE", "/", "LONGITUDE" and returns a
     * CoordinatesWorld constructed from them.
     * @param tokens The tokens used to construct the CoordinatesWorld
     * @return A CoordinatesWorld constructed from the tokens.
     */
    public static CoordinatesWorld parseCoordinatesWorld(ListIterator<String> tokens) {
        return CoordinatesWorldDeserializer.parseCoordinatesWorld(tokens);
    }

    /**
     * Consumes 3 tokens from the list iterator in the format of "NUMBER", ":", "NUMBER", and returns a CoordinatesDelta
     * constructed from them.
     * @param tokens The ListIterator containing the tokens.
     * @return The parsed CoordinatesDelta
     */
    public static CoordinatesDelta parseCoordinatesDelta(ListIterator<String> tokens) {
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
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    /**
     * Consumes a single token from the list iterator in the format of "NUMBER", and returns an Angle constructed from
     * it.
     * @param tokens The ListIterator containing the tokens.
     * @return Returns the Angle from the parsed input.
     */
    public static Angle parseAngle(ListIterator<String> tokens) {
        double angle = Double.parseDouble(tokens.next());
        return new Angle(angle);
    }

    /**
     * Consumes 7 tokens from the list iterator ON TRACK id DISTANCE number FROM (START | END)
     *
     * @param tokens The tokens used to construct the TrackLocator
     * @return A TrackLocator constructed from the tokens.
     */
    public static TrackLocator parseTrackLocator(ListIterator<String> tokens) {
        String onToken = tokens.next();
        Assert.isTrue(onToken.equals("ON"), "Incorrect input, expected: ON");
        String trackToken = tokens.next();
        Assert.isTrue(trackToken.equals("TRACK"), "Incorrect input, expected: TRACK");
        String trackID = tokens.next();
        String distanceToken = tokens.next();
        Assert.isTrue(distanceToken.equals("DISTANCE"), "Incorrect input, expected: DISTANCE");
        double distance = Double.parseDouble(tokens.next());
        String fromToken = tokens.next();
        Assert.isTrue(fromToken.equals("FROM"), "Incorrect input, expected: FROM");
        boolean isFromAOrB = tokens.next().equals("START");
        return new TrackLocator(trackID, distance, isFromAOrB);
    }

    /**
     * Consumes multiple tokens from the list iterator REFERENCE ( coordinates_world | ( '$' id2 ) ) DELTA START coordinates_delta1 END coordinates_delta2
     *
     * @param tokens The tokens used to construct the PointLocator
     * @return A PointLocator constructed from the tokens.
     */
    public static PointLocator parsePointLocator(ListIterator<String> tokens, A_ParserHelper ph) {
        CoordinatesWorld reference = parseReference(tokens, ph);
        String deltaToken = tokens.next();
        Assert.isTrue(deltaToken.equals("DELTA"), "Incorrect input, expected: DELTA");
        String startToken = tokens.next();
        Assert.isTrue(startToken.equals("START"), "Incorrect input, expected: START");
        CoordinatesDelta cdStart = PrimitiveDeserializer.parseCoordinatesDelta(tokens);
        String endToken = tokens.next();
        Assert.isTrue(endToken.equals("END"), "Incorrect input, expected: END");
        CoordinatesDelta cdEnd = PrimitiveDeserializer.parseCoordinatesDelta(tokens);
        return new PointLocator(reference, cdStart, cdEnd);
    }

    /**
     * Consumes 2-4 tokens from the list iterator REFERENCE (coordinates_world | ('$' id))
     *
     * @param tokens The tokens used to construct the CoordinatesWorld
     * @return A CoordinatesWorld constructed from the tokens.
     */
    public static CoordinatesWorld parseReference(ListIterator<String> tokens, A_ParserHelper ph) {
        String referenceToken = tokens.next();
        Assert.isTrue(referenceToken.equals("REFERENCE"), "Incorrect input, expected: REFERENCE");
        String ref = tokens.next();
        CoordinatesWorld cw;
        if (ref.charAt(0) == '$')
            cw = ph.getReference(ref.substring(1));
        else {
            tokens.previous();
            cw = parseCoordinatesWorld(tokens);
        }
        return cw;
    }

    /**
     * Consumes all remaining tokens, which are supposed to be ids, from the list iterator
     *
     * @param tokens The token used to construct the List<String>
     * @return A List<String> that contains the ids constructed from the tokens.
     */
    public static List<String> parserIDList(ListIterator<String> tokens) {
        List<String> listIDs = new ArrayList<String>();
        while (tokens.hasNext())
            listIDs.add(tokens.next());
        return listIDs;
    }



}
