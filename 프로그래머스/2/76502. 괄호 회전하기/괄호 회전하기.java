import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        ArrayDeque<Character> q = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            q.add(c);
        }
        
        for(int i = 0 ; i < s.length() - 1; i++){
            if(check(new ArrayDeque<>(q))){
                answer++;
            }
            q.add(q.poll());
        }
        return answer;
    }
    
    public boolean check(ArrayDeque<Character> q){
        Stack<Character> s = new Stack<>();
        while(!q.isEmpty()){
            char c = q.poll();
            if(c == '(' || c == '{' || c =='['){
                s.push(c);
            }else{
                if(s.isEmpty()) return false;
                if(s.peek() == '(' && c == ')'){
                    s.pop();
                }else if(s.peek() == '{' && c == '}'){
                    s.pop();
                }else if(s.peek() == '[' && c == ']'){
                    s.pop();
                }else{
                    return false;
                }
            }
        }
        return s.isEmpty();
    }
}