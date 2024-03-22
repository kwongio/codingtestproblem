
import java.util.*;
class Solution {
    int answer = 0;
    boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        DFS(k, dungeons, 0);
        return answer;
    }
    void DFS(int k , int[][] dungeons, int count){
        if(k < 0) return;
        answer = Math.max(answer, count);

        for(int i = 0 ; i < dungeons.length;i++){
            if(!visited[i]){
                if(k >= dungeons[i][0]){
                    visited[i] = true;
                  DFS(k,dungeons,count);
                    DFS(k - dungeons[i][1],dungeons,count + 1);   
                    visited[i] = false;
                }

            }
        }
    }
}