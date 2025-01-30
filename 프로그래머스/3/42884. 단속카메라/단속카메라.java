import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        
        Arrays.sort(routes, Comparator.comparingInt((int[] a) -> a[1]));
        int pre = routes[0][1];
        int ans = 1;
        for(int i = 1; i < routes.length; i++){
            int a = routes[i][0];
            int b = routes[i][1];
            if(pre < a){
                ans++;
                pre = b;
            }
            
        }
        return ans;
    }
}