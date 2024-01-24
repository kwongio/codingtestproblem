import java.util.*;
class Solution {
    static List<int[]>[] list;

    static boolean[] visited;
    static int[] distance;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        
        distance = new int[N + 1];
        for(int i = 0; i < N + 1; i++){
            distance[i] = Integer.MAX_VALUE;
        } 
        for(int i = 0; i <= N; i++){
            list[i] = new ArrayList<>();
        }
        for(int i =0 ;i < road.length ; i++){   
            list[road[i][0]].add(new int[]{road[i][1], road[i][2]});
               list[road[i][1]].add(new int[]{road[i][0], road[i][2]});
        }

        BFS(1);
        int count = 0;
        for(int i = 1; i < N + 1; i++){
            if(distance[i] <= K){
                count++;
            }
        }
        return count;

  
    }
    private static void BFS(int start){
     PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
     q.add(new int[]{start, 0});
    distance[1] = 0;
        while(!q.isEmpty()){
            int now[] = q.poll();
            for(int[] n : list[now[0]]){
                if(distance[n[0]] > n[1] + distance[now[0]]){
                    distance[n[0]] =n[1] + distance[now[0]];
                    q.add(new int[]{n[0], distance[n[0]]});
                }
            }

        }
       
    }
}