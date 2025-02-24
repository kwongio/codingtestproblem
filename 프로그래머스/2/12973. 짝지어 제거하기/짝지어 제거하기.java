import java.util.*;

class Solution{
    public int solution(String str){
        Stack<Character> s = new Stack<>();
        for(char c:  str.toCharArray()){
            if(!s.isEmpty() && s.peek() == c){
                s.pop();
            }else{
                s.push(c);
            }
        }
        
        return s.isEmpty() ? 1: 0;
    }
}