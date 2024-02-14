import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : priorities){
            q.add(i);
        }
        
        int answer =0;
        while(!q.isEmpty()){
            for(int i = 0; i < priorities.length; i++){
                if(q.peek() == priorities[i]){
                    answer++;
                    q.poll();
                    if(location == i){
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}