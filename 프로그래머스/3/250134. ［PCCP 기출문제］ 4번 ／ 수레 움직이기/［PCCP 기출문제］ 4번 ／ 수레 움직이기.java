class Solution {
    int N, M;
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    int rsx;
    int rsy;
    int bsx;
    int bsy;
    boolean redEnd = false;
    boolean blueEnd = false;
    boolean[][][] visit;
    int min = Integer.MAX_VALUE;
    int[][] arr;
    
    public int solution(int[][] maze) {
        N = maze.length;
        M = maze[0].length;
        arr = maze;
        visit = new boolean[2][N][M];
        
        for(int i =0 ; i < N ; i++){
            for(int j = 0; j < M; j++){
                if(maze[i][j] == 1){
                    rsx = i;
                    rsy = j;
                }else if(maze[i][j] == 2){
                    bsx = i;
                    bsy = j;
                }
            }
        }
        
        visit[0][rsx][rsy] = true;
        visit[1][bsx][bsy] = true;
        
        DFS(rsx, rsy, bsx, bsy, 0);
        if(Integer.MAX_VALUE == min){
            return 0;
        }
        return min;
    }
 public void DFS(int rsx, int rsy, int bsx, int bsy, int turn) {
    if (turn >= min) return; // 이미 최소값을 초과한 경우 중단
    if (redEnd && blueEnd) {
        min = Math.min(turn, min);
        return;
    }

    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            int rnx = redEnd ? rsx : rsx + dx[i];
            int rny = redEnd ? rsy : rsy + dy[i];
            int bnx = blueEnd ? bsx : bsx + dx[j];
            int bny = blueEnd ? bsy : bsy + dy[j];

            // 두 수레가 도착지에 도달한 경우를 처리
            boolean redAtGoal = rnx >= 0 && rnx < N && rny >= 0 && rny < M && arr[rnx][rny] == 3;
            boolean blueAtGoal = bnx >= 0 && bnx < N && bny >= 0 && bny < M && arr[bnx][bny] == 4;

            // 이동 가능 여부 확인
            if (!((redEnd || isRange(rnx, rny, 0)) && (blueEnd || isRange(bnx, bny, 1)))) continue;
            if (rnx == bnx && rny == bny) continue; // 두 수레가 같은 위치
            if (rsx == bnx && rsy == bny && bsx == rnx && bsy == rny) continue; // 교차 위치

            // 방문 및 상태 갱신
            visit[0][rnx][rny] = true;
            visit[1][bnx][bny] = true;
            boolean prevRedEnd = redEnd, prevBlueEnd = blueEnd;
            redEnd = redEnd || redAtGoal;
            blueEnd = blueEnd || blueAtGoal;

            DFS(rnx, rny, bnx, bny, turn + 1);

            // 상태 복구
            visit[0][rnx][rny] = false;
            visit[1][bnx][bny] = false;
            redEnd = prevRedEnd;
            blueEnd = prevBlueEnd;
        }
    }
}
    public boolean isRange(int x, int y, int color){
        return x >=0 && x < N && y >=0 && y < M && !visit[color][x][y] && arr[x][y] != 5;
    }
}