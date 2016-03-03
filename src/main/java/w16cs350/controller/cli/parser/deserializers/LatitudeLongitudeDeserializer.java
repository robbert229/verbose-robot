package w16cs350.controller.cli.parser.deserializers;

import w16cs350.datatype.A_LatitudeLongitude;
import w16cs350.datatype.Latitude;
import w16cs350.datatype.Longitude;

import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by RowleyJohn on 3/2/2016.
 */
public class LatitudeLongitudeDeserializer {

    private static String latlonRegex = "^(-?[0-9]*)\\*\\s*(-?[0-9]*)\\'\\s*(-?[0-9]+(?:\\.[0-9][0-9]?)?)\"\\s*$";
    private static String latlonWhiteSpaceRegex = "^([0-9]*)[*\\'\"]$";

    private static Pattern latlonPattern = Pattern.compile(latlonRegex);
    private static Pattern latlonWhiteSpacePattern = Pattern.compile(latlonWhiteSpaceRegex);

    public static boolean isNextLatitudeLongitude(ListIterator<String> tokens){
        int start = tokens.nextIndex();
        try {
            parseLatitude(tokens);
            return true;
        } catch (RuntimeException exception){
            return false;
        } finally {
            while(tokens.nextIndex() > start)
                tokens.previous();
        }
    }

    private interface I_Constructor {
        A_LatitudeLongitude construct(int degrees, int minutes, double seconds);
    }

    private static A_LatitudeLongitude parseA_LatitudeLongitude(ListIterator<String> tokens, I_Constructor constructor){
        String raw = tokens.next();

        Matcher whitespace = latlonWhiteSpacePattern.matcher(raw);
        if(whitespace.find())
            raw = raw + tokens.next() + tokens.next();

        Matcher m = latlonPattern.matcher(raw);
        if(m.find()) {
            int degree = Integer.parseInt(m.group(1));
            int minutes = Integer.parseInt(m.group(2));
            double seconds = Double.parseDouble(m.group(3));
            return constructor.construct(degree, minutes, seconds);
        } else {
            throw new RuntimeException("Doesn't Match Regex: " + raw);
        }
    }

    public static Latitude parseLatitude(ListIterator<String> tokens){
        return (Latitude)parseA_LatitudeLongitude(tokens, (d,m,s) -> new Latitude(d,m,s));
    }

    public static Longitude parseLongitude(ListIterator<String> tokens){
        return (Longitude) parseA_LatitudeLongitude(tokens, (d,m,s) -> new Longitude(d,m,s));
    }


}
