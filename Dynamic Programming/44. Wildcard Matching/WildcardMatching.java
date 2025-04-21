class Solution {
    public boolean isMatch(String s, String p) {
        Map<String, Boolean> memo = new HashMap<>();
        return isMatch(s,p,0,0, memo);
    }

    public boolean isMatch(String s,String p,int i,int j,Map<String, Boolean> memo){

        if(i == s.length() && j == p.length()) return true;
        if(j == p.length() ) return false;

        if(memo.containsKey(i + " " + j)) return memo.get(i + " " + j);

        if( i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') ){
            memo.put( i + " " + j ,isMatch(s,p,i+1,j+1, memo));
            return  memo.get(i + " " + j);
        }else if(p.charAt(j) == '*'){
            memo.put(i + " " + j, (i < s.length() &&  isMatch(s,p,i+1,j,memo)) || isMatch(s,p,i,j+1, memo));
            return memo.get(i + " " + j);
        }

        return false;
    }
}