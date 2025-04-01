import java.util.Stack;
import java.lang.*;
class Solution {
    public int longestValidParentheses(String s) {
        
        Stack<Integer> stack = new Stack<>();

        stack.push(-1);
        int sLength = s.length();
        int max_length=0;

        for(int x = 0; x < sLength; x++){
            char bracket = s.charAt(x);
           
            if(bracket == '('){
                stack.push(x);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(x);
                    
                }else{
                    max_length= Math.max(max_length,x - stack.pop());
                }
                
            }
        } 


        return max_length;
    }
}
