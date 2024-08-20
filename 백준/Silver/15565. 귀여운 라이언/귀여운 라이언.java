import java.util.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import java.io.*;
import java.lang.reflect.Array;

public class Main {
	static long N, K;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Long.parseLong(st.nextToken());
		arr = new int[(int) N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int L = 0;
		int count = 0;
		int min = Integer.MAX_VALUE;
		for (int R = 0; R < N; R++) {
			if (arr[R] == 1) {
				count++;
			}

			while ((count > K || arr[L] == 2) && L < R) {
				if (arr[L] == 1) {
					count--;
				}
				L++;
			}
			if (count >= K) {
//				System.out.println(R + " " + L);
				min = Math.min(min, R - L + 1);
			}
		}
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
}
