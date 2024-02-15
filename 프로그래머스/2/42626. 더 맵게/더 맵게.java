import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i : scoville){
            q.add(i);
        }
        
        int answer= 0;
        while(!q.isEmpty()){
            int v1 = q.poll();
            if(q.isEmpty()){
                if(v1 >= K){
                    return answer;
                }else{
                    return -1;
                }
            }
            int v2 = q.poll();
            if(v1 >= K && v2 >= K)
                break;
            q.add(v1 + (v2 * 2));
            answer++;
                
        }

        return answer;
    }
}