import java.util.*;
class Solution {
    //두 개의 그룹으로 나눠야함
    List<Integer>[] list;
    int N ;
    int min = Integer.MAX_VALUE;
    int answer;
    boolean[] visit;
    public int solution(int n, int[][] wires) {
        N = n;
        answer = n - 1;
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
        visit=  new boolean[N + 1];
        DFS(1);
        return answer;
    }
    
    public int DFS(int now){
        visit[now] = true;
        int sum =0 ;
        for(int next : list[now]){
            if(!visit[next]){
                int cnt = DFS(next);
                answer = Math.min(answer, Math.abs(N - cnt * 2));
                sum +=cnt;
            }
        }
        return sum + 1;
    }
}