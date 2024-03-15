import java.util.*;
class Solution {
    int zero =0 ;
    int[] rank = {6, 6, 5, 4 ,3, 2, 1};
    public int[] solution(int[] lottos, int[] win_nums) {
        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0){
                zero++;
            }
        }
        int cnt  =0 ;
        for(int i = 0; i < lottos.length; i++){
            for(int j =0; j < win_nums.length; j++){
                if(lottos[i] == win_nums[j]){
                    cnt++;
                    break;
                }
            }
        }
        
        int[] answer = new int[2];
        
        answer[0] = rank[cnt + zero];
        answer[1] = rank[cnt];
        return answer;
    }
}