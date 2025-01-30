import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i =0 ; i < works.length; i++){
            q.add(works[i]);
        }
        for(int i = 0; i < n ; i++){
            q.add(q.poll() - 1);
        }
        
        while(!q.isEmpty()){
            int v= q.poll();
            if(v >= 1){
                answer += Math.pow(v, 2);
            }
        }
        
        
        return answer;
    }
}