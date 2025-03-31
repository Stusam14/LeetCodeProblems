import java.util.regex.*;

class Solution {
    public boolean isMatch(String s, String p) {
        Pattern pattern = Pattern.compile(p);
        Matcher match = pattern.matcher(s);


        if(Pattern.matches("[^*.]",p)){
            return false;
        }
        if(pattern.pattern().length()!=s.length()){
            return false;
        }

        if(match.find()){
            return true;
        }
        return false;
    }
}