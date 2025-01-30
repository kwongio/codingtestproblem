import java.util.*;

class Solution {
    boolean[] visit;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        for(int i = 0; i < n ; i++){
            if(!visit[i]){
                visit[i] = true;
                answer++;
                BFS(i, computers, n );
            }
        }
        return answer;
    }
    public void BFS(int start, int[][] computers, int n){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(start);
        while(!q.isEmpty()){
            int now=  q.poll();
            for(int i = 0; i < n; i++){
                if(computers[now][i] == 1){
                    if(!visit[i]){
                        visit[i] = true;
                        q.add(i);
                     }
                }
            }
        }
    }
}