import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        char[] c = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < c.length; i++){
            if(c[i] == '('){
                stack.push('a');
                
            }else{
                if(!stack.isEmpty()){
                    stack.pop();    
                }else{
                    return false;
                }
            }
        }
        if(!stack.isEmpty())
            return false;

        return answer;
    }
}