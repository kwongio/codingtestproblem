import java.util.*;
class Solution {
    int[][] arr;
    public int solution(int n, int[][] wires) {
        arr = new int[n + 1][n + 1];
        int answer = Integer.MAX_VALUE;
        for(int i = 0 ; i < wires.length; i++){
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }
        
        for(int i = 0 ; i < wires.length ; i++){
            arr[wires[i][0]][wires[i][1]] = 0;
            arr[wires[i][1]][wires[i][0]] = 0;
            answer = Math.min(answer, bfs(wires[i][0], n));
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }
        return answer;
    }
    int bfs(int start, int n){
        int cnt = 1;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i = 1; i < n + 1; i++){
                if(arr[now][i]  == 1 && !visited[i]){
                    visited[i] = true;
                    q.add(i);
                    cnt++;
                }
            }
        }
        return Math.abs(cnt-(n - cnt));
    }
}