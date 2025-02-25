import java.util.*;

class Solution {
    int[] dis;
    List<int[]>[] list;
    boolean[] visit;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        dis = new int[N + 1];
        visit = new boolean[N + 1];
        list = new List[N + 1];
        for(int i =0 ; i < N + 1; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int[] r : road){
            int a = r[0];
            int b = r[1];
            int c = r[2];
            list[a].add(new int[]{b,c});
            list[b].add(new int[]{a,c});
        }
        
        Arrays.fill(dis, Integer.MAX_VALUE);
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        q.add(new int[]{1, 0});
        dis[1] = 0;
        while(!q.isEmpty()){
            int[] now = q.poll();
            int cur = now[0];
            int cnt = now[1];
            if(visit[cur]) continue;
            visit[cur] = true;
            for(int[] next : list[cur]){
                if(dis[next[0]] > next[1] + cnt ){
                    dis[next[0]] =next[1] + cnt;
                    q.add(new int[]{next[0], dis[next[0]]});
                }
            }
        }
        
        int ans=0;
        for(int i =1; i < N + 1;i++){
            if(dis[i] <= K){
                ans++;
            }
        }
        return ans;
    }
}