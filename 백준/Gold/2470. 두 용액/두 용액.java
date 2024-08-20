import java.util.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import java.io.*;

public class Main {
	static int N;
	static int[] a;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		List<Integer> list = new ArrayList<Integer>();
		int s = 0;
		int e = N - 1;
		while (s < e) {
			int v = a[s] + a[e];
			int ret = Math.abs(a[s] + a[e]);
			if (ret < min) {
				list.clear();
				list.add(a[s]);
				list.add(a[e]);
				min = ret;
			}
			if (v < 0) {
				s++;
			} else {
				e--;
			}
		}
		for (Integer v : list) {
			System.out.print(v + " ");
		}
	}
}