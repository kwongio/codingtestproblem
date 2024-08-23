import java.util.*;
import java.io.*;

public class Main {
	static int N, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		long s = 0;
		long e = Long.MAX_VALUE;
		long ans = Long.MAX_VALUE;
		while (s <= e) {
			long mid = s + (e - s) / 2;
			if (check(mid)) {
				e = mid - 1;
				ans = Math.min(ans, mid);
			} else {
				s = mid + 1;
			}
		}
		System.out.println(ans);
	}

	static boolean check(long v) {
		long sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += Math.min(v / i, N);
		}

		return sum >= K;
	}
}