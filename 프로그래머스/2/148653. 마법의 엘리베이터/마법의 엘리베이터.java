import java.util.*;


class Solution {
    public int solution(int storey) {
        int answer =0 ;
       while(storey > 0){
           int one = storey % 10;
            int ten = (storey /10)%10;
           System.out.println(ten);
            if(one % 10 < 5){
               answer += storey % 10;
               storey -= one;
            }else if(one % 10 == 5){
                if(ten >= 5){
                    storey+= one;
                }else{
                    storey-= one;
                }
                answer+=one;
            }
           else{
                answer += 10 - one;
                storey += 10 - one;
            }
           storey /= 10;
       }
        
        return answer;
    }
}