package w16cs350.controller.cli.parser.deserializers;

import w16cs350.datatype.CoordinatesDelta;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * Created by RowleyJohn on 3/2/2016.
 */
public class CoordinatesDeltaDeserializer {
    public static CoordinatesDelta parseCoordinatesDelta(ListIterator<String> tokens){
        String first = tokens.next();
        try {
            double xCoordinate = Double.parseDouble(first);
            Assert.isTrue(tokens.next().equals(":"), "Token wasn't /");
            double yCoordinate = Double.parseDouble(tokens.next());
            return new CoordinatesDelta(xCoordinate, yCoordinate);

        } catch (NumberFormatException nfe){
            String[] args = first.split(":");
            double xCoordinate = Double.parseDouble(args[0]);
            double yCoordinate = Double.parseDouble(args[1]);
            return new CoordinatesDelta(xCoordinate,yCoordinate);
        }
    }

}
