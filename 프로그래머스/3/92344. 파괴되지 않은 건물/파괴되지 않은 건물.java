import java.util.*;
class Solution {
    int[][] sum;
    int N, M ;
    public int solution(int[][] board, int[][] skill) {
        N = board.length;
        M = board[0].length;
        sum = new int[N + 1][M + 1];
        
        for(int[] v : skill){
            int type = v[0];
            int r1 = v[1];
            int c1 = v[2];
            int r2 = v[3];
            int c2 = v[4];
            int degree = (type == 1) ? -v[5] : v[5];
            
            sum[r1][c1] += degree;
            sum[r1][c2 + 1] += -degree;
            sum[r2 + 1][c1] += -degree;
            sum[r2 + 1][c2 + 1] += degree;
        }
        
        for(int i =1; i < N; i++){
            for(int j =0; j < M; j++){
                sum[i][j] += sum[i - 1][j];
            }
        }
        for(int i =0; i < N; i++){
            for(int j =1; j < M; j++){
                sum[i][j] += sum[i][j - 1];
            }
        }
        int ans =0 ;
        for(int i =0 ; i < N; i++){
            for(int j =0 ; j < M; j++){
                board[i][j] += sum[i][j];
                if(board[i][j] > 0){
                    ans++;
                }
            }
        }
        return ans;
    }
}