import java.util.*;
import java.io.*;

public class Main {
	static int T;
	static int N, M;
	static int[] a;
	static int[] b;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for (int testCase = 0; testCase < T; testCase++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			a = new int[N];
			M = Integer.parseInt(st.nextToken());
			b = new int[M];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(b);
			int ret = 0;
			for (int i = 0; i < N; i++) {
				int s = 0;
				int e = M - 1;
				int mid = 0;
				int d = 0;
				while (s <= e) {
					mid = (s + e) / 2;
					if (b[mid] < a[i]) {
						s = mid + 1;
						d = mid + 1;
					} else {
						e = mid - 1;
					}
				}
				ret += d;
			}
			System.out.println(ret);
		}

	}
}
