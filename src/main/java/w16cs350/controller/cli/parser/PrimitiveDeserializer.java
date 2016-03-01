package w16cs350.controller.cli.parser;

import w16cs350.controller.cli.TrackLocator;
import w16cs350.controller.command.PointLocator;
import w16cs350.datatype.*;
import w16cs350.support.Assert;

import java.util.ArrayList;
import java.util.List;
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

    public static TrackLocator parseTrackLocator(ListIterator<String> tokens){
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

    public static PointLocator parsePointLocator(ListIterator<String> tokens, A_ParserHelper ph){
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

    public static CoordinatesWorld parseReference(ListIterator<String> tokens, A_ParserHelper ph){
        String referenceToken = tokens.next();
        Assert.isTrue(referenceToken.equals("REFERENCE"), "Incorrect input, expected: REFERENCE");
        String ref = tokens.next();
        CoordinatesWorld cw;
        if(ref.charAt(0) == '$')
            cw = ph.getReference(ref);
        else {
            tokens.previous();
            cw = parseCoordinatesWorld(tokens);
        }
        return cw;
    }

    public static List<String> parserIDList(ListIterator<String> tokens)
    {
        List<String> listIDs = new ArrayList<String>();
        while(tokens.hasNext())
            listIDs.add(tokens.next());
        return listIDs;
    }
}
