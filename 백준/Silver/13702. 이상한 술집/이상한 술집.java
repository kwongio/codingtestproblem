import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int K;
	static int[] a;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		long s = 0;
		long e = Integer.MAX_VALUE;
		long answer = 0;
		while (s <= e) {
			long mid = s + (e - s) / 2;
			if (check(mid)) {
				s = mid + 1;
				answer = Math.max(answer, mid);
			} else {
				e = mid - 1;
			}
		}
		System.out.println(answer);
	}

	static boolean check(long v) {
		if (v == 0) {
			return false;
		}
		long cnt = 0;
		for (int i = 0; i < N; i++) {
			cnt += a[i] / v;
		}
		return cnt >= K;
	}
}