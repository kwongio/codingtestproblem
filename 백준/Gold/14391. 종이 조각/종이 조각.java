import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static int[][] map;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0'; // 숫자로 변환
            }
        }

        DFS(0, new boolean[N][M]);
        System.out.println(max);
    }

    private static void DFS(int index, boolean[][] visited) {
        if (index == N * M) { // 모든 칸을 탐색 완료
            max = Math.max(max, calculateSum(visited));
            return;
        }

        int x = index / M; // 행 좌표
        int y = index % M; // 열 좌표

        // 1️⃣ 현재 칸을 '가로'로 포함
        visited[x][y] = true;
        DFS(index + 1, visited);
        visited[x][y] = false;

        // 2️⃣ 현재 칸을 '세로'로 포함
        DFS(index + 1, visited);
    }

    private static int calculateSum(boolean[][] visited) {
        int sum = 0;

        // 1️⃣ 가로로 연속된 숫자 합산
        for (int i = 0; i < N; i++) {
            int currentNum = 0;
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) { // 가로로 이어지는 경우
                    currentNum = currentNum * 10 + map[i][j];
                } else {
                    sum += currentNum;
                    currentNum = 0;
                }
            }
            sum += currentNum; // 마지막 숫자 추가
        }

        // 2️⃣ 세로로 연속된 숫자 합산
        for (int j = 0; j < M; j++) {
            int currentNum = 0;
            for (int i = 0; i < N; i++) {
                if (!visited[i][j]) { // 세로로 이어지는 경우
                    currentNum = currentNum * 10 + map[i][j];
                } else {
                    sum += currentNum;
                    currentNum = 0;
                }
            }
            sum += currentNum; // 마지막 숫자 추가
        }

        return sum;
    }
}
