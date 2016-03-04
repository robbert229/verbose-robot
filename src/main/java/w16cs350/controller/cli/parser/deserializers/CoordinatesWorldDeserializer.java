package w16cs350.controller.cli.parser.deserializers;

import w16cs350.controller.cli.parser.PrimitiveDeserializer;
import w16cs350.datatype.CoordinatesWorld;
import w16cs350.datatype.Latitude;
import w16cs350.datatype.Longitude;

import java.util.Arrays;
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

        ListIterator<String> just_coordinates;

        just_coordinates = Arrays.stream(tokens.next().split("/"))
                .collect(Collectors.toList())
                .listIterator();

        Latitude lat = PrimitiveDeserializer.parseLatitude(just_coordinates);
        Longitude lon = PrimitiveDeserializer.parseLongitude(just_coordinates);
        return new CoordinatesWorld(lat,lon);
    }
}
