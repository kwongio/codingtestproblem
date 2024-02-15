import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        
        for(int i = 0; i < operations.length; i++){
            String[]op = operations[i].split(" ");
            String command = op[0];
            int value = Integer.parseInt(op[1]);
            if(command.equals("I")){
                maxQueue.add(value);
                minQueue.add(value);
            }
            if(command.equals("D")){
                 if(maxQueue.isEmpty()) continue;
                if(value == 1){
                     int v = maxQueue.poll();
                    minQueue.remove(v);
                }else{
                     int v = minQueue.poll();
                     maxQueue.remove(v); 
                       
                }
            }
          
        }
        if(!minQueue.isEmpty() && !maxQueue.isEmpty()){
            return new int[]{maxQueue.poll(), minQueue.poll()};
        }
        return new int[]{0,0};
        
    }
}