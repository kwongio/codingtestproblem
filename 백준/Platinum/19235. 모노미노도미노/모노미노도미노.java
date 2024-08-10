import java.util.*;

import java.io.*;

public class Main {
	static int N;
	static final int HEIGHT = 6;
	static final int WIDTH = 4;

	static int[][] blue = new int[HEIGHT][WIDTH];
	static int[][] green = new int[HEIGHT][WIDTH];
	static int score = 0;
	static int blockNum = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			push(t, x, y, blockNum++);

//			System.out.println((i + 1) + "턴");
//			System.out.println(t + " " + x + " " + y);
//			print();
		}

		System.out.println(score);
		int sum = 0;
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				if (blue[i][j] >= 1) {
					sum++;
				}
				if (green[i][j] >= 1) {
					sum++;
				}
			}
		}
		System.out.println(sum);
	}

	static void print() {
		System.out.println("블루");
		for (int i = 0; i < blue.length; i++) {
			System.out.println(Arrays.toString(blue[i]));
		}
		System.out.println();

		System.out.println("초록");
		for (int i = 0; i < blue.length; i++) {
			System.out.println(Arrays.toString(green[i]));
		}
		System.out.println();
	}

	static boolean isRange(int x, int y) {
		return x >= 0 && x < HEIGHT && y >= 0 && y < WIDTH;
	}

	static int getHeight(int[][] board, int y) {
		int height = HEIGHT - 1;
		for (int i = HEIGHT - 1; i >= 0; i--) {
			if (board[i][y] >= 1) {
				height = i - 1;
			}
		}
		return height;
	}

	static boolean removeBlock(int[][] board) {
		boolean isRemove = false;
		for (int i = 0; i < HEIGHT; i++) {
			int count = 0;
			for (int j = 0; j < WIDTH; j++) {
				if (board[i][j] >= 1) {
					count++;
				}
			}
			if (count == 4) {
				score++;
				isRemove = true;
				for (int j = 0; j < WIDTH; j++) {
					if (board[i][j] >= 1) {
						board[i][j] = 0;
					}
				}
			}

		}
		return isRemove;
	}

	static void downBlock(int[][] board) {
		// 블록의 범위 구하기
		for (int i = HEIGHT - 1; i >= 0; i--) {
			for (int j = 0; j < WIDTH; j++) {
				if (board[i][j] >= 1) {
					BFS(i, j, board[i][j], board);
				}
			}
		}
	}

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static void BFS(int x, int y, int color, int[][] board) {
		boolean[][] visit = new boolean[HEIGHT][WIDTH];
		ArrayDeque<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] { x, y });
		visit[x][y] = true;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if (isRange(nx, ny) && board[nx][ny] == color && !visit[nx][ny]) {
					visit[nx][ny] = true;
					q.add(new int[] { nx, ny });
				}
			}
		}
		while (true) {
			for (int i = HEIGHT - 1; i >= 0; i--) {
				for (int j = 0; j < WIDTH; j++) {
					if (visit[i][j]) {
						if (isRange(i + 1, j)) {
							if (board[i + 1][j] == 0 || board[i + 1][j] == color) {
								visit[i][j] = false;
								visit[i + 1][j] = true;
							} else {
								return;
							}
						} else {
							return;
						}
					}
				}
			}

			for (int i = HEIGHT - 1; i >= 0; i--) {
				for (int j = 0; j < WIDTH; j++) {
					if (visit[i][j]) {
						board[i - 1][j] = 0;
						board[i][j] = color;
					}
				}
			}
		}
	}

	static void push(int t, int x, int y, int num) {
		// 블럭 생성
		int h = Integer.MAX_VALUE;
		int h1 = Integer.MAX_VALUE;

		if (t == 1) {
//			green[0][y] = 1;
			h = getHeight(green, y);
			green[h][y] = num;
			// y좌표 별로 최대 높이 구하기
			// 그리고 블럭 만들기

			h1 = getHeight(blue, 3 - x);
			blue[h1][3 - x] = num;
//			
		} else if (t == 2) {

			h = Math.min(getHeight(green, y), getHeight(green, y + 1));
			green[h][y] = num;
			green[h][y + 1] = num;

			h1 = getHeight(blue, 3 - x);
			blue[h1 - 1][3 - x] = num;
			blue[h1][3 - x] = num;
			h1--;

		} else if (t == 3) {

			h = getHeight(green, y);
			green[h - 1][y] = num;
			green[h][y] = num;
			h--;

			h1 = Math.min(getHeight(blue, 3 - x), getHeight(blue, 3 - x - 1));
			blue[h1][3 - x] = num;
			blue[h1][3 - x - 1] = num;
		}

		// 한줄이 생기면 삭제
		while (removeBlock(blue)) {
			downBlock(blue);
			h1++;
		}
		while (removeBlock(green)) {
			downBlock(green);
			h++;
		}

		if (h == 0) {
			for (int j = 0; j < WIDTH; j++) {
				green[HEIGHT - 1][j] = 0;
				green[HEIGHT - 2][j] = 0;
			}
			downBlock(green);

		} else if (h == 1) {
			for (int j = 0; j < WIDTH; j++) {
				green[HEIGHT - 1][j] = 0;
			}
			downBlock(green);
		}

		if (h1 == 0) {
			for (int j = 0; j < WIDTH; j++) {
				blue[HEIGHT - 1][j] = 0;
				blue[HEIGHT - 2][j] = 0;
			}
			downBlock(blue);

		} else if (h1 == 1) {
			for (int j = 0; j < WIDTH; j++) {
				blue[HEIGHT - 1][j] = 0;
			}
			downBlock(blue);
		}
	}

}