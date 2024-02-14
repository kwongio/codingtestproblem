import java.util.*;
class Solution {
    public List solution(int[] progresses, int[] speeds) {
        List<Integer> answer=  new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i =0; i < progresses.length; i++){
            if((100 -progresses[i])% speeds[i] == 0){
                q.add((100 - progresses[i])/speeds[i]);
            }else{
                q.add((100 - progresses[i])/speeds[i]  + 1);
            }
        }
        
        while(!q.isEmpty()){
            int count = 1;
            int value = q.poll();
            while(!q.isEmpty() && q.peek() <= value){
                q.poll();
                count++;
            }
            answer.add(count);
        }
        
        return answer;
    }
}