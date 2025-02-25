import java.util.*;

class Solution {
    int N;
    int[][][] dis;
    int min = Integer.MAX_VALUE;
    int[] dx= { -1,0,1,0};
    int[] dy = {0,1,0,-1};
    public int solution(int[][] board) {
        N = board.length;
        dis = new int[4][N][N];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for(int i =0 ; i < 4; i++){
            for(int j = 0; j < N; j++){
                Arrays.fill(dis[i][j], Integer.MAX_VALUE);
            }
        }
        q.add(new int[]{0,0,0,0});
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y= now[1];
            int sum = now[2];
            int d = now[3];
            if(min <= sum) continue;
            if(x == N - 1 && y == N - 1){
                min = Math.min(min, sum);
                continue;
            }
            for(int i =0 ; i < 4; i++){
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if(nx >=0 && nx < N && ny >=0 && ny < N  && board[nx][ny] ==0 ){
                    if(i == d || sum == 0){
                        if(dis[i][nx][ny] > sum + 100 ){
                            q.add(new int[]{nx, ny, sum + 100, i});
                            dis[i][nx][ny] = sum + 100;
                        }

                    }else{
                        if(dis[i][nx][ny] > sum + 600){
                            q.add(new int[]{nx, ny, sum + 600, i});
                            dis[i][nx][ny] = sum + 600;
                        }
                    }
                }
            }
        }
        return min;
    }
}