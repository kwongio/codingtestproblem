import java.util.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import java.io.*;

public class Main {
	static int N;
	static int M;
	static int[] arr;

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
		int s = 0;
		int e = 1000000000;
		int ret = 0;
		while (s <= e) {
			int mid = s + (e - s) / 2;
			if (check(mid)) {
				ret = Math.max(ret, mid);
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}
		System.out.println(ret);
	}

	static boolean check(int v) {
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (v < arr[i]) {
				sum += arr[i] - v;
			}
		}
		if (sum >= M) {
			return true;
		}
		return false;
	}
}
