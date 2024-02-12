import java.util.*;
class Solution {
    static int second = 0;
    static int a;
    static int b;
    static int[] dx = {-1, 0 ,1 ,0};
    static int[] dy = {0, 1, 0 , -1};
    static int[][] map;
    static int N;
    static int M;
    static int answer = 0;
    static boolean[][] visited;
    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
      
        map = new int[N][M];
        
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            char[] c = maps[i].toCharArray();
            for(int j = 0; j < c.length; j++){
                if(c[j] == 'E'){ // 끝
                    map[i][j] = 3;
                }
                if(c[j] == 'O'){ // 통로
                    map[i][j] = 0;
                }
                if(c[j] == 'X'){ // 벽
                   map[i][j] = 1;
                }
                
                if(c[j] == 'L'){ // 레버
                  map[i][j] = 2;
                }
                if(c[j] == 'S'){ // 시작점
                    a = i;
                    b = j;
                }
            }
        }
       int temp1=BFS(a,b,2);
       int temp2=BFS(a,b,3);
        if(temp1 == -1  || temp2 == -1){
            return -1;
        }

        
        
       
        return temp1 + temp2;
    }
    public static int BFS(int x, int y, int dest){
         visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 0});
        
        visited[x][y] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != 1 && !visited[nx][ny]){
                    if(map[nx][ny] == dest){
                        a = nx;
                        b = ny;
                        return now[2] + 1;
                    }
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny,now[2] + 1});
                }
            }
        }     
        return -1;
    }  
}