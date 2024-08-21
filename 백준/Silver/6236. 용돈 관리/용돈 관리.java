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
		M = Integer.parseInt(st.nextToken());
		a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		long s = Arrays.stream(a).max().getAsInt();
		long e = 10000 * 100000;
		long ret = 10000 * 100000;

		while (s <= e) {
			long mid = s + (e - s) / 2;
			if (check(mid)) {
				e = mid - 1;
				ret = mid;
			} else {
				s = mid + 1;
			}
		}
		System.out.println(ret);
	}

	static boolean check(long v) {
		int count = 1;
		long money = v;
		for (int i = 0; i < a.length; i++) {
			money -= a[i];
			if (money < 0) {
				count++;
				money = v - a[i];
			}
		}
		return count <= M;
	}
}