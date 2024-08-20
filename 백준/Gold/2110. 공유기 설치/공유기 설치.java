import java.util.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import java.io.*;

public class Main {
	static int N;
	static int C;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		int s = 1;
		int e = 1000000000;
		int ret = 1;
		while (s <= e) {
			int mid = s + (e - s) / 2;
			if (check(mid)) {
				s = mid + 1;
				ret = Math.max(ret, mid);
			} else {
				e = mid - 1;
			}
		}
		System.out.println(ret);
	}

	static boolean check(int v) {
		int s = arr[0];
		int count = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - s >= v) {
				count++;
				s = arr[i];
				if (count == C) {
					return true;
				}
			}
		}

		return false;
	}
}
