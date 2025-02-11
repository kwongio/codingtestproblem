import java.util.*;

class Solution {
    long totalOperations = 0; // 연산 횟수 누적
    boolean[] visited;
    List<Integer>[] graph;
    long[] weights;

    public long solution(int[] a, int[][] edges) {
        long sum = 0;
        int n = a.length;
        weights = new long[n];
        graph = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            weights[i] = a[i];  
            sum += a[i];
        }

        if (sum != 0) return -1;

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        dfs(0);

        return totalOperations;
    }
    
    public long dfs(int node){
        visited[node] = true;
        long sum = weights[node];
        for(int v: graph[node]){
            if(visited[v]) continue;
            sum+=dfs(v);
        }
        
        totalOperations += Math.abs(sum);
        return sum;
    }
}
