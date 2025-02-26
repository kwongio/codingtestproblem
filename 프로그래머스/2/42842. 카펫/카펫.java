import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int num =  brown + yellow;
        
        for(int i = 3; i <= num; i++){
            int a = num/i;
                if(num%i != 0){
                    continue;
                }
            if(brown !=a * 2 + i * 2 - 4){
                continue;
            }
            
            if(a >= i){
                return new int[]{a,i};
            }
        }
        return answer;
    }
}