import java.util.*;

class Solution {
    char[][] map;
    boolean[][][] visit;
    int N;
    int M;
    int[] dx = {-1, 0 , 1, 0};
    int[] dy=  { 0, 1, 0, -1};
    List<Integer> list = new ArrayList<>();
    public List<Integer> solution(String[] grid) {
        N = grid.length;
        M = grid[0].length();
        visit = new boolean[4][N][M];
        map = new char[N][M];
        for(int i =0 ; i < N; i++){
            for(int j = 0; j < M; j++){
                map[i][j] = grid[i].charAt(j);
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0 ; j < M; j++){
                for(int k = 0; k < 4; k++){
                    if(!visit[k][i][j]){
                        visit[k][i][j] = true;
                        list.add(BFS(i, j, k));
                    }
                }
            }
        }
        Collections.sort(list);
        
        return list;
    }
    
    public int BFS(int sx, int sy, int dir){
        int max =1;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx,sy,dir, 1});
        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int d = now[2];
            int cnt = now[3];
            int nx = (dx[d] + x + N) % N;
            int ny = (dy[d] + y + M) % M;
            int ndir = getDirection(nx, ny, d);
            if(!visit[ndir][nx][ny]){
                visit[ndir][nx][ny] = true;
                max = Math.max(max , cnt + 1);
                q.add(new int[]{nx, ny, ndir, cnt + 1});
            }
        }
        return max;
    }
    public int getDirection(int x, int y, int d){
        if(map[x][y] == 'R'){
            return  (d+1)%4;
        }else if(map[x][y] == 'L'){
            return  (d-1+4)%4;
        }   
        return d;
    }
}