import java.util.*;
class Solution {
    public int solution(int[] array, int n) {
        Arrays.sort(array);
        int answer = 0;
        for(int i = 0 ; i < array.length; i++){
            if(array[i] > n){
                break;
            }else if(array[i] == n){
                answer++;
            }
        }
        
        return answer;
    }
}