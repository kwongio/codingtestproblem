import java.util.*;
import java.io.*;

public class Main {
	static int N = 5;
	static char[][] board = new char[N][N];
	static int ans = 0;
	static boolean[] visit;
	static int[] select = new int[7];
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 5; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < 5; j++) {
				board[i][j] = c[j];
			}
		}
		DFS(0, 0);
		System.out.println(ans);
	}

	static void DFS(int index, int count) {

		if (count == 7) {
			BFS();
			return;
		}

		if (index == 25)
			return;
		select[count] = index;
		DFS(index + 1, count + 1);
		DFS(index + 1, count);
	}

	static void BFS() {
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
		visit = new boolean[7];
		q.add(select[0]);
		int cnt = 1;
		int sCnt = 0;
		visit[0] = true;
		while (!q.isEmpty()) {
			int now = q.poll();
			int x = now / 5;
			int y = now % 5;
			if (board[x][y] == 'S') {
				sCnt++;
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				for (int j = 1; j < 7; j++) {
					if (!visit[j] && nx == select[j] / 5 && ny == select[j] % 5) {
						visit[j] = true;
						cnt++;
						q.add(select[j]);
					}
				}
			}
		}
		if (cnt == 7 && sCnt >= 4) {
			ans++;
		} else {
		}
	}
}