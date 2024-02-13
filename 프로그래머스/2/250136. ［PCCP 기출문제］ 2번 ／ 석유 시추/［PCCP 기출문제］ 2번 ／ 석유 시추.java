import java.util.*;
class Solution {
    static int[] dx = {-1, 0 , 1, 0};
    static int[] dy=  {0, 1 , 0, -1};
    static boolean[][] visited;
    static int[] cnt;
    public int solution(int[][] land) {
        cnt = new int[land[0].length];
        visited = new boolean[land.length][land[0].length];
        
        for(int i = 0 ; i < land[0].length; i++){
            for(int j = 0; j < land.length; j++){
                if(land[j][i] == 1 && !visited[j][i]){
                   BFS(j, i, land);
                }
            }
        }

        return Arrays.stream(cnt).max().getAsInt();
    }
    static void BFS(int x, int y, int[][] land){
        boolean[] pos = new boolean[land[0].length];
        int count = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;
        pos[y] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];
                if(nx >= 0 && nx < land.length && ny >=0 && ny< land[0].length){
                    if(!visited[nx][ny] && land[nx][ny] == 1){
                        visited[nx][ny] = true;
                        pos[ny] = true;
                        count++;
                        q.add(new int[]{nx,ny});
                    }
                }
                
            }
        }

        for(int i = 0 ; i < pos.length; i++){
            if(pos[i]){
                cnt[i] += count;    
            }
        }
    }
}