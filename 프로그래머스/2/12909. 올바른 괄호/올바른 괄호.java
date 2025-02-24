import java.util.*;

class Solution {
    boolean solution(String s) {
        char[] c = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < c.length; i++){
            if(!stack.isEmpty() && stack.peek() == '(' && c[i] == ')'){
                stack.pop();
            }else{
                stack.push(c[i]);
            }
        }
        
        return stack.isEmpty();
    }
}