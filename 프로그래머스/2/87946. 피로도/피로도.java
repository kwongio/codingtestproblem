import java.util.*;

class Solution {
    boolean[] visit;
    int n;
    int max = Integer.MIN_VALUE;
    int[][] d; 
    public int solution(int k, int[][] du) {
        n =du.length;
        d = du;
        visit = new boolean[n];
        
        DFS(0, k, 0);
        return max;
    }
    void DFS(int depth, int k, int cnt){
        if(depth == n){
            max = Math.max(cnt, max);
            return;
        }
        
        for(int i =0 ; i < n; i++){
            if(visit[i]) continue;
            visit[i] = true;
            int min = d[i][0];
            int down = d[i][1];
            if(k >= min && k - down >=0){
                DFS(depth+ 1, k - down, cnt + 1);
            }
            DFS(depth + 1, k, cnt);
            visit[i] = false;
        }
        
    }
}