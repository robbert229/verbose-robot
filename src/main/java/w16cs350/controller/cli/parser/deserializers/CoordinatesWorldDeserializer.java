package w16cs350.controller.cli.parser.deserializers;

import w16cs350.controller.cli.parser.PrimitiveDeserializer;
import w16cs350.datatype.CoordinatesWorld;
import w16cs350.datatype.Latitude;
import w16cs350.datatype.Longitude;
import w16cs350.support.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

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
        if(!PrimitiveDeserializer.isNextLatitudeLongitude(tokens)) {
            int start = tokens.nextIndex();
            String first = tokens.next();
            while (tokens.nextIndex() > start)
                tokens.previous();

            String[] tokenArray = first.split("/");

            List<String> l = new ArrayList<String>();
            l.add(tokenArray[0]);
            l.add("/");
            l.add(tokenArray[1]);

            return parseCoordinatesWorldClean(l.listIterator());
        } else {
            return parseCoordinatesWorldClean(tokens);
        }
    }

    private static CoordinatesWorld parseCoordinatesWorldClean(ListIterator<String> tokens){
        Latitude lat = PrimitiveDeserializer.parseLatitude(tokens);
        Assert.isTrue(tokens.next().equals("/"), "Token must be /");
        Longitude lon = PrimitiveDeserializer.parseLongitude(tokens);
        return new CoordinatesWorld(lat, lon);
    }
}
