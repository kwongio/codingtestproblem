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

	static int removeBlock(int[][] board) {
		int h = 0;
		for (int i = 0; i < HEIGHT; i++) {
			int count = 0;
			for (int j = 0; j < WIDTH; j++) {
				if (board[i][j] >= 1) {
					count++;
				}
			}
			if (count == 4) {
				score++;
				h = i;
				for (int j = 0; j < WIDTH; j++) {
					if (board[i][j] >= 1) {
						board[i][j] = 0;
					}
				}
				return h;
			}
		}
		return 0;
	}

	static void downBlock(int[][] board, int h) {
		// 블록의 범위 구하기
		for (int i = 0; i < WIDTH; i++) {
			for (int j = h; j > 0; j--) {
				board[j][i] = board[j - 1][i];
				board[j - 1][i] = 0;
			}
		}
	}

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static void push(int t, int x, int y, int num) {
		// 블럭 생성
		int h = Integer.MAX_VALUE;
		int h1 = Integer.MAX_VALUE;

		if (t == 1) {

			h = getHeight(green, y);
			green[h][y] = num;

			h1 = getHeight(blue, 3 - x);
			blue[h1][3 - x] = num;

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
		int removeH = -1;
		while ((removeH = removeBlock(blue)) != 0) {
			downBlock(blue, removeH);
			h1++;
		}
		while ((removeH = removeBlock(green)) != 0) {
			downBlock(green, removeH);
			h++;
		}

		if (h == 0) {
			for (int j = 0; j < WIDTH; j++) {
				green[HEIGHT - 1][j] = 0;
				green[HEIGHT - 2][j] = 0;
			}
			downBlock(green, HEIGHT - 2);
			downBlock(green, HEIGHT - 1);
		} else if (h == 1) {
			for (int j = 0; j < WIDTH; j++) {
				green[HEIGHT - 1][j] = 0;
			}
			downBlock(green, HEIGHT - 1);
		}
		if (h1 == 0) {
			for (int j = 0; j < WIDTH; j++) {
				blue[HEIGHT - 1][j] = 0;
				blue[HEIGHT - 2][j] = 0;
			}
			downBlock(blue, HEIGHT - 2);
			downBlock(blue, HEIGHT - 1);
		} else if (h1 == 1) {
			for (int j = 0; j < WIDTH; j++) {
				blue[HEIGHT - 1][j] = 0;
			}
			downBlock(blue, HEIGHT - 1);
		}
	}
}