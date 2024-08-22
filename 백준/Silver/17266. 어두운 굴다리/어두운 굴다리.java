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
		M = Integer.parseInt(br.readLine());
		a = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		int s = 0;
		int e = N;
		int min = N;
		while (s <= e) {
			int mid = s + (e - s) / 2;
			if (check(mid)) {
				min = Math.min(min, mid);
				e = mid - 1;
			} else {
				s = mid + 1;
			}
		}
		System.out.println(min);
	}

	static boolean check(int v) {
		int last = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] - last <= v) {
				last = a[i] + v;
			} else {
				return false;
			}
		}
		return last >= N;
	}
}