import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> s = new Stack<>();
        for(int i =0 ; i < arr.length;i++){
            if(!s.isEmpty() && s.peek() == arr[i]){
                continue;
            }
            s.push(arr[i]);
        }
        
        int[] answer = new int[s.size()];
        for(int i =0 ;  i < s.size(); i++){
            answer[i] = s.get(i);
        }
        return answer;
    }
}