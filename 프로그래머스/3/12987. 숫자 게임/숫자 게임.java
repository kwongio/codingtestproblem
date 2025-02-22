import java.util.*;


class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int s =B.length - 1;
        int ans =0;
        
        for(int i =A.length - 1 ; i >= 0; i--){
            if(s < B.length && A[i] < B[s]){ // 처리할 수
                ans++;
                s--;
            }
            
        }
        return ans;
    }
}