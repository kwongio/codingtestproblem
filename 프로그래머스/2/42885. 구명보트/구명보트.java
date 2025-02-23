import java.util.*;

class Solution {
    public int solution(int[] p, int limit) {
        int answer = 0;
        Arrays.sort(p);
        int s =0 ;
        int e =p.length  - 1;
        
        int cnt =0 ;
        while(s <= e){
            if(p[e] + p[s] <= limit){
                e--;
                s++;
            }else if(p[e] <= limit){
                e--;
            }
            cnt++;
        }
        
        return cnt;
    }
}