
import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int sum = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int v : truck_weights){
            while(true){
                if(q.isEmpty()){
                    time++;
                    q.add(v);
                    sum += v;
                    break;
                }else if(q.size() == bridge_length){
                    sum-=q.poll();
                }else{
                    if(sum + v <= weight){
                        sum+=v;
                        q.add(v);
                        time++;
                        break;
                    }else{
                        q.add(0);
                        time++;
                    }
                }
            }
        }
        
        return time + bridge_length;
    }
}