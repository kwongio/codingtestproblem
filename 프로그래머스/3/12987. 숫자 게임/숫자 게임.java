import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        int a = 0;
        int b = 0;
        for(int i = 0; i < A.length;i++){
            if(A[a] == B[b]){
                b++;
            }else if(A[a] > B[b]){
                b++;
            }else{
                a++;
                b++;
                answer++;
            }
        }
        return answer;
    }
}