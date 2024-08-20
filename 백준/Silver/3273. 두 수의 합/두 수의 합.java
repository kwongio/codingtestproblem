import java.util.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import java.io.*;
import java.lang.reflect.Array;

public class Main {
	static int N, M, X;
	static int[] a, b;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		a = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		X = Integer.parseInt(br.readLine());
		Arrays.sort(a);
		int s = 0;
		int e = N - 1;
		int ret = 0;
		while (s < e) {
			int sum = a[s] + a[e];
			if (sum > X) {
				e--;
			} else if (sum < X) {
				s++;
			} else {
				ret++;
				e--;
			}
		}
		System.out.println(ret);
	}
}
