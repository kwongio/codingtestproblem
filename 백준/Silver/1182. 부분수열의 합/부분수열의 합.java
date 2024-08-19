import java.util.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import java.io.*;

public class Main {
	static int N;
	static int S;
	static int count;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		DFS(0, 0);
		if (S == 0)
			count--;
		System.out.println(count);
	}

	static void DFS(int depth, int sum) {
		if (depth == N) {
			if (sum == S)
				count++;
			return;
		}
		DFS(depth + 1, sum);
		DFS(depth + 1, sum + arr[depth]);
	}
}
