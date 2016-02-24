package w16cs350.parser;
import java.util.List;

/**
 * Created by johnrowleyster on 2/23/16.
 */
public abstract class A_PatternMatcher {

    protected List<A_PatternMatcher> patternMatchers;


    /**
     * Takes an array of strings and
     * @param tok Returns if the
     */
    public boolean matches(String tok) {
        for(int i = 0; i < patternMatchers.size();i++){
            if(patternMatchers.get(i).matches(tok))
                return true;
        }

        return false;
    }

    public abstract void initializeMatchers();
    public abstract void operate(String[] tokens);

    public void delgate(String[] tokens){
        for(int i = 0; i < patternMatchers.size(); i++){
            A_PatternMatcher pattern = patternMatchers.get(i);
            if(pattern.matches(tokens[0])){
                pattern.operate(popHead(tokens));
                return;
            }
        }
    }

    private static String[] popHead(String[] tokens){
        assert(tokens.length >= 1);
        String[] poppedHead = new String[tokens.length - 1];
        for(int i = 1; i < tokens.length; i++){
            poppedHead[i-1] = tokens[i];
        }

        return poppedHead;
    }
}
