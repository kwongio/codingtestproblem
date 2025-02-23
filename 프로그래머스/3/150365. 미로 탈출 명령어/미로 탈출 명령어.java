import java.util.*;

class Solution {
    int[][] map;
    int[] dx = {1, 0 ,0 ,-1};
    int[] dy = {0, -1 ,1, 0};
    char[] dir = {'d', 'l', 'r', 'u'};
    int sx, sy, ex ,ey, K;
    int N, M;
    String answer ="";
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        map= new int[n + 1][m + 1];
        N = n; M = m;
        sx = x; sy = y; ex = r; ey = c; K = k;
        DFS(sx, sy, 0, "");
        
        return answer.equals("") ? "impossible" : answer;
    }

    public void DFS(int x, int y, int cnt, String path){
        if(getDistance(x, y) + cnt > K  ||  (K - getDistance(x, y) + cnt) % 2 == 1) return;
        if(!answer.equals("")) return;
        if(cnt > K) return;
        if(cnt == K){
            if(ex == x && ey ==y){
                answer = path;
            }
            return;
        }
        
        for(int i =0 ; i < 4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if(isRange(nx ,ny)){
                DFS(nx, ny, cnt + 1, path + dir[i]);
            }
        }
    }
    public boolean isRange(int x, int y){
        return x >=1 && x <= N && y >=1 && y <= M;
    }
    

    
    public int getDistance(int x , int y){
        return Math.abs(ex - x) + Math.abs(ey - y);
    }
}
//d l r u 

//아래 왼쪽 오른쪽 위