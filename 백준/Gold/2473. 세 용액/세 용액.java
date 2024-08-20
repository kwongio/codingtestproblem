import java.util.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import java.io.*;
import java.lang.reflect.Array;

public class Main {
	static int N;
	static int[] a;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		a = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		List<Integer> list = new ArrayList<Integer>();
		long ans = Long.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int s = i + 1;
			int e = N - 1;
			while (s < e) {
				long v = (long)a[s] +(long) a[e] +(long) a[i];
				long sum = Math.abs((long)a[s] + (long)a[e] + (long)a[i]);

				if (sum < ans) {
					ans = sum;
					list.clear();
					list.add(a[s]);
					list.add(a[e]);
					list.add(a[i]);
				}
				if (v > 0) {
					e--;
				} else {
					s++;
				}
			}
		}

		Collections.sort(list);
		for (int v : list) {
			System.out.print(v + " ");
		}
	}
}