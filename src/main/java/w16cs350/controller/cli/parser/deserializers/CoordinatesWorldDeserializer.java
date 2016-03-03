package w16cs350.controller.cli.parser.deserializers;

import w16cs350.controller.cli.parser.PrimitiveDeserializer;
import w16cs350.datatype.CoordinatesWorld;
import w16cs350.datatype.Latitude;
import w16cs350.datatype.Longitude;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * Created by RowleyJohn on 3/2/2016.
 */
public class CoordinatesWorldDeserializer {
    public static boolean isNextCoordinatesWorld(ListIterator<String> tokens){
        int start = tokens.nextIndex();
        try {
            parseCoordinatesWorld(tokens);
            return true;
        } catch(RuntimeException e) {
            return false;
        } finally {
            while (tokens.nextIndex() > start)
                tokens.previous();
        }
    }

    public static CoordinatesWorld parseCoordinatesWorld(ListIterator<String> tokens){
        Latitude lat = PrimitiveDeserializer.parseLatitude(tokens);
        Assert.isTrue(tokens.next().equals("/"), "Token must be /");
        Longitude lon = PrimitiveDeserializer.parseLongitude(tokens);
        return new CoordinatesWorld(lat,lon);
    }
}
