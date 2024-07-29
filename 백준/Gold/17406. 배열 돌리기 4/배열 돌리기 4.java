import java.util.*;
import java.io.*;

public class Main {
	static int min = Integer.MAX_VALUE;
	static int[][] arr;
	static List<int[]> v;
	static int N;
	static int M;
	static int K;
	static int[] select;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		select = new int[K];
		arr = new int[N][M];
		v = new ArrayList<>();
		visit = new boolean[K];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			v.add(new int[] { r, c, s });
		}
		DFS(0);
		System.out.println(min);
	}

	public static void DFS(int depth) {
		if (depth == K) {
			int[][] copyMap = new int[N][M];
			for (int i = 0; i < N; i++) {
				copyMap[i] = Arrays.copyOf(arr[i], M);
			}

			for (int i = 0; i < K; i++) {
				int[] now = v.get(select[i]);
				int r = now[0];
				int c = now[1];
				int s = now[2];
				int sx = r - s;
				int sy = c - s;
				int ex = r + s;
				int ey = c + s;
				int step = (ex - sx) / 2;
				ArrayDeque<Integer>[] q = new ArrayDeque[step];
				for (int j = 0; j < step; j++) {
					q[j] = new ArrayDeque<Integer>();
				}
				for (int k = 0; k < step; k++) {
					for (int j = sy + k; j <= ey - k; j++) {
						q[k].add(copyMap[sx + k][j]);
					}
					for (int j = sx + 1 + k; j <= ex - k; j++) {
						q[k].add(copyMap[j][ey - k]);
					}
					for (int j = ey - 1 - k; j >= sy + k; j--) {
						q[k].add(copyMap[ex -k][j]);
					}
					for (int j = ex - 1 - k; j >= sx + 1 + k; j--) {
						q[k].add(copyMap[j][sy+ k]);
					}

					q[k].addFirst(q[k].pollLast());
					for (int j = sy + k; j <= ey - k; j++) {
						copyMap[sx + k][j] = q[k].pollFirst();
					}
					for (int j = sx + 1 + k; j <= ex - k; j++) {
						copyMap[j][ey -  k] = q[k].pollFirst();
					}
					for (int j = ey - 1 - k; j >= sy + k; j--) {
						copyMap[ex -  k][j] = q[k].pollFirst();
					}
					for (int j = ex - 1 - k; j >= sx + 1 + k; j--) {
						copyMap[j][sy + k] = q[k].pollFirst();
					}
				}

			}

			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < M; j++) {
					sum += copyMap[i][j];
				}
				min = Math.min(min, sum);
			}
			return;
		}
		for (int i = 0; i < K; i++) {
			if (!visit[i]) {
				visit[i] = true;
				select[depth] = i;
				DFS(depth + 1);
				visit[i] = false;
			}
		}
	}
}