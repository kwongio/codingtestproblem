import java.util.*;
import java.io.*;

public class Main {
	static int K;
	static int N;
	static int[] a;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		a = new int[K];
		for (int i = 0; i < K; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		long s = 1;
		long e = Arrays.stream(a).max().getAsInt();
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

	static boolean check(long mid) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i] / mid;
		}
		return sum >= N;
	}
}