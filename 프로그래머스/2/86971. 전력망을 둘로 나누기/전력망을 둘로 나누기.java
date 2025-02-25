import java.util.*;
class Solution {
    //두 개의 그룹으로 나눠야함
    List<Integer>[] list;
    int N ;
    int min = Integer.MAX_VALUE;
    public int solution(int n, int[][] wires) {
        N = n;
        list = new List[n + 1];
        for(int i =0 ; i < n  + 1; i++){
            list[i] = new ArrayList<>();
        }
        for(int[] w : wires){
            int a = w[0];
            int b = w[1];
            list[a].add(b);
            list[b].add(a);
        }
        
        for(int i =0 ; i < wires.length ;i++){
            int a = wires[i][0];
            int b = wires[i][1];
            int cnt1 = BFS(a, b);
            int cnt2 = BFS(b, a);
            min = Math.min(Math.abs(cnt1-cnt2), min);
        }
        return min;
    }
    public int BFS(int a, int b){
        boolean[] visit=  new boolean[N + 1];
        ArrayDeque<Integer> q= new ArrayDeque<>();
        q.add(a);
        visit[a] = true;
        int cnt = 1;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int next : list[now]){
                if(visit[next] || next == b) continue;
                visit[next]= true;
                q.add(next);
                cnt++;
            }
        }
        return cnt;
    }
}