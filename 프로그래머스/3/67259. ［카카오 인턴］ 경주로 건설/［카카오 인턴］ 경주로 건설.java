import java.util.*;

class Solution {

    int N;
    boolean[][][] visited;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1,};

    public int solution(int[][] board) {
        N = board.length;
        visited = new boolean[N][N][4];
        return bfs(board);
    }

    public int bfs(int[][] board) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 0, -1, 0));
        int min_cost = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.x == N - 1 && now.y == N - 1) {
                min_cost = Math.min(min_cost, now.cost);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + this.dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || board[nx][ny] == 1) {
                    continue;
                }

                int nextCost = now.cost;
                if (now.dir == -1 || now.dir == i) {
                    //처음이라 비교대상이 없는 경우엔 무조건 100원만 추가,
                    //이전과 같은 방향인 경우에도 100원 추가
                    nextCost += 100;
                } else {
                    nextCost += 600;
                }

                if (!visited[nx][ny][i] || board[nx][ny] >= nextCost) {
                    q.add(new Node(nx, ny, i, nextCost));
                    visited[nx][ny][i] =  true;
                    board[nx][ny] = nextCost;
                }
            }
        }
        return min_cost;
    }

    public class Node {
        int x, y, dir, cost;

        public Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
}