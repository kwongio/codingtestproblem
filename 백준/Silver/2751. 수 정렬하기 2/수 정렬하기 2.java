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
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(a);
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			sb.append(a[i]).append("\n");
		}
		System.out.println(sb);

	}
}
