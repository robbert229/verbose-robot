package w16cs350.parser;

import w16cs350.datatype.CoordinatesWorld;
import w16cs350.datatype.Latitude;
import w16cs350.datatype.Longitude;

import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by RowleyJohn on 2/23/2016.
 */
public class PrimitiveDeserializer {
    // 1 * 10 ' 20 "
    // 1*10'20"

    private static Pattern latlonPattern = Pattern.compile("([0-9]*)\\*([0-9]*)\\'([0-9]*)\"");

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

    public static CoordinatesWorld parseWorldCoordinates(ListIterator<String> tokens){
        Latitude lat = parseLatitude(tokens);
        tokens.next();
        Longitude lon = parseLongitude(tokens);
        return new CoordinatesWorld(lat,lon);
    }
}
