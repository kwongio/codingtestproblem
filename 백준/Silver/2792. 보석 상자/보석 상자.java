import java.util.*;
import java.io.*;

class Main {
	static int M;
	static int N;
	static int[] arr;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		int e = 0;
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			e = Math.max(arr[i], e);
		}

		int s = 1;
		int min = Integer.MAX_VALUE;
		while (s <= e) {
			int mid = s + (e - s) / 2;
			if (check(mid)) {
				min = Math.min(mid, min);
				e = mid - 1;
			} else {
				s = mid + 1;
			}
		}
		System.out.println(min);
	}

	public static boolean check(int v) {
		int count = 0;
		for (int i = 0; i < M; i++) {
			count += arr[i] / v;
			if (arr[i] % v != 0) {
				count++;
			}
		}
		if (count <= N) {
			return true;
		}

		return false;
	}
}