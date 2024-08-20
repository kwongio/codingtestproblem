import java.util.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import java.io.*;
import java.lang.reflect.Array;

public class Main {
	static long N, M;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		arr = new int[(int) N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long sum = 0;
		int L = 0;
		int ans = 0;

		for (int R = 0; R < N; R++) {
			sum += arr[R];

			while (sum > M && L < R) {
				sum -= arr[L];
				L++;
			}
			if (sum == M) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}
