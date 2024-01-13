import java.util.*;
class Solution {
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1, -1};
    static boolean visited[][];
    
    public int solution(int[][] maps) {
        
        visited = new boolean[maps.length][maps[0].length];
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        visited[0][0] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];
                if(nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length){
                    if(!visited[nx][ny] && maps[nx][ny] == 1){
                        maps[nx][ny] = maps[now[0]][now[1]] + 1;
                        visited[nx][ny] = true;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
            
        }
     
        if(visited[maps.length - 1][maps[0].length- 1]){
                return maps[maps.length- 1][maps[0].length - 1];
        }
        return -1;
    }
}
