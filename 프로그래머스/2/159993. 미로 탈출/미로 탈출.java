import java.util.*;

class Solution {


    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    int lx;
    int ly;
    int sx;
    int sy;
    int ex;
    int ey;
    int time = 0;
    int N;
    int M;
    char[][] miro;
    boolean[][][] visited;
    // x위치 y위치 o열린지 d거리   
    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[3] == o2[3] ? Integer.compare(o1[2], o2[2]) : Integer.compare(o1[3], o2[3]));
    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        int answer = 0;
        visited = new boolean[N][M][2];
        miro = new char[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++){
            miro[i] = maps[i].toCharArray();
        }
        
        for(int i =0 ; i < miro.length; i++){
            for(int j = 0; j < miro[i].length; j++){
                if(miro[i][j] == 'S'){
                    sx = i;
                    sy = j;
                }else if(miro[i][j] == 'L'){
                    lx = i;
                    ly = j;                    
                }else if(miro[i][j] == 'E'){
                    ex = i;
                    ey = j;                    
                }
            }
        }
       
        return bfs(sx, sy);
    }
                                                  
    public int bfs(int x, int y){
        pq.offer(new int[]{x,y,0,1});
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            if(visited[now[0]][now[1]][now[2]]){
                continue;
            }
            visited[now[0]][now[1]][now[2]] = true;
            for(int i = 0; i < 4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx >= 0 && nx < N && ny >=0 && ny < M && miro[nx][ny] != 'X'){
                   if(lx == nx && ly == ny){
                       pq.offer(new int[]{nx, ny, 1, now[3] + 1});
                   }else if(ex == nx && ey == ny && now[2] == 1){
                        return now[3];
                   }else{
                       pq.offer(new int[]{nx,ny,now[2],now[3] + 1});
                   }
                }
            }
        }
        return -1;
    }
}