import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static int[] a;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		a = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());

		int temp = M;
		for (int i = 0; i < N; i++) {
			temp -= a[i];
		}
		if (temp >= 0) {
			System.out.println(Arrays.stream(a).max().getAsInt());
			System.exit(0);
		}

		long s = 1;
		long e = M;

		while (s <= e) {
			long mid = s + (e - s) / 2;
			if (check(mid)) {
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}
		System.out.println(s - 1);
	}

	static boolean check(long v) {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			if (v > a[i]) {
				sum += a[i];
			} else {
				sum += v;
			}
		}
		return sum <= M;
	}
}