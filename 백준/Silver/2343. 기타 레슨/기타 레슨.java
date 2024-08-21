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
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		long s = 1;
		long e = Long.MAX_VALUE;
		long min = Long.MAX_VALUE;
		while (s <= e) {
			long mid = s + (e - s) / 2;
			if (check(mid)) {
				e = mid - 1;
				min = (long) Math.min(min, mid);
			} else {
				s = mid + 1;
			}
		}
		System.out.println(min);
	}

	static boolean check(long v) {
		int count = 1;
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > v) {
				return false;
			}
			if (sum + a[i] <= v) {
				sum += a[i];
			} else {
				count++;
				sum = a[i];
			}
		}
		return count <= M;
	}
}