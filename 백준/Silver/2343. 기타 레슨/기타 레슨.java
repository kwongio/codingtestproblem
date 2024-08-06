import java.util.*;
import java.io.*;

class Main {
	static int M;
	static int N;
	static int[] arr;
	static long min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long s = 1;
		long e = 100000 * 100000;
		long min = Long.MAX_VALUE;
		// 큰걸로쪼개면
		while (s <= e) {
			long mid = s + (e - s) / 2;
			if (check(mid)) {
				min = Math.min(mid, min);
				// 낮힐수록 많이 나옴
				e = mid - 1;
			} else {
				// 높힐수록 적게나옴
				s = mid + 1;
			}
		}
		System.out.println(min);
	}

	public static boolean check(long mid) {
		long count = 1;
		long sum = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i] > mid)
				return false;
			if (sum + arr[i] <= mid) {
				sum += arr[i];
			} else {
				sum = arr[i];
				count++;
			}
		}
		if (count <= M) {
			return true;
		}
		return false;
	}
}