import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        ArrayDeque<String> c1 = new ArrayDeque<>(Arrays.asList(cards1));
        ArrayDeque<String> c2 = new ArrayDeque<>(Arrays.asList(cards2));
        
        for(String g: goal){
            if(!c1.isEmpty() && c1.peek().equals(g)){
                c1.poll();
            }else if(!c2.isEmpty() && c2.peek().equals(g)){
                c2.poll();
            }else{
                return "No";
            }
        }
        
        return "Yes";
    }
}