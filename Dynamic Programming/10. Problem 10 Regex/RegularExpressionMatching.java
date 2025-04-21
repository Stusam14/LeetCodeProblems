class Solution {
    public boolean isMatch(String s, String p) {

        return dfs(s,p,0,0);
        
    }

    public boolean dfs(String s, String p,int i, int j){
        
        if(j == p.length()) return i == s.length();

        boolean matchChar = (i < s.length() ) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if(j+1 < p.length() && p.charAt(j+1) == '*'){
            return (matchChar&&dfs(s,p,i+1,j))||dfs(s,p,i,j+2);
        }else{
            return matchChar&&dfs(s,p,i+1,j+1);
        }
    }
}