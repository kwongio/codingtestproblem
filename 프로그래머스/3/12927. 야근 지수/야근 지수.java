import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
         long answer = 0;
        for(int w : works){
            q.add(w);
        }
        for(int i = 0; i < n; i++){
            if(!q.isEmpty()){
                int v = q.poll() - 1;
                if(v > 0) q.add(v);
            }
        }
        while(!q.isEmpty()){
            int num = q.poll() ;
            answer+=num*num;
        }
       
        return answer;
    }
}