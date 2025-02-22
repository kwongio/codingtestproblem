import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        ArrayDeque<Integer> qu1 = new ArrayDeque<>();
        ArrayDeque<Integer> qu2 = new ArrayDeque<>();
        long sum1 = 0;
        long sum2 = 0;
        for(int i =0 ; i < queue1.length; i++){
            sum1+= queue1[i];
            qu1.add(queue1[i]);
            sum2+= queue2[i];
            qu2.add(queue2[i]);
        }
        int count  = 0;
        while(sum1 != sum2){
              if(count > (queue1.length + queue2.length)* 2){
                return -1;
            }
            if(sum1 > sum2 ){
                if(qu1.isEmpty()) return -1;
                int v = qu1.poll();
                sum2+=v;
                sum1-=v;
                qu2.add(v);
            }else if(sum2 > sum1){
                if(qu2.isEmpty()) return -1;
                int v = qu2.poll();
                sum2-=v;
                sum1+=v;
                qu1.add(v);
            }
            count++;
          
        }
        return count;
    }
}