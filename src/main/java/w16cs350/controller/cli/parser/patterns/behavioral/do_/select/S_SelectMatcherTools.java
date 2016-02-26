package w16cs350.controller.cli.parser.patterns.behavioral.do_.select;

import w16cs350.datatype.Angle;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * S_SelectMatcherTools contains a set of tools needed to
 * match SELECT commands
 */
public class S_SelectMatcherTools {

    private static S_SelectMatcherTools ourInstance = new S_SelectMatcherTools();

    private S_SelectMatcherTools() {
    }

    public static S_SelectMatcherTools getInstance() {
        return ourInstance;
    }

    /**
     * Utility that extracts the position variable from the iterator
     *
     * @param tokens - Iterator for tokens list
     * @return - The direction as a string
     */
    String getPosition(ListIterator<String> tokens, String errorString) {
        Assert.isTrue(tokens.hasNext(), errorString);
        Assert.isTrue(tokens.next().equals("POSITION"), errorString);

        Assert.isTrue(tokens.hasNext(), errorString);
        String position = tokens.next();
        Assert.isTrue(position.equals("UP") || position.equals("DOWN"), errorString);

        return position;
    }

    /**
     * Simple utility to extract an Angle from the next token
     *
     * @param tokens - The tokens iterator
     * @return - The next token's value as Angle
     */
    Angle extractAngle(ListIterator<String> tokens, String errorString) {
        Assert.isTrue(tokens.hasNext(), errorString);
        Assert.isTrue(tokens.next().equals("POSITION"), errorString);
        Assert.isTrue(tokens.hasNext(), errorString);
        String num = tokens.next();
        if (!testNum(num))
            throw new RuntimeException(errorString);
        double doubleValue = Double.parseDouble(num);
        return new Angle(doubleValue);
    }

    boolean testNum(String str) {
        try {
            Double d = Double.parseDouble(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
