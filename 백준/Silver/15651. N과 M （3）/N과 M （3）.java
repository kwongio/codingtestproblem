import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static int[] select;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		select = new int[M];
		visit = new boolean[N];

		DFS(0, 1);
		System.out.println(sb);
	}

	static void DFS(int depth, int start) {
		if (depth == M) {
			for (int i = 0; i < select.length; i++) {
				sb.append(select[i]).append(" ");
			}
			sb.append("\n");
		} else {
			for (int i = 1; i <= N; i++) {
				select[depth] = i;
				DFS(depth + 1, i);
			}
		}
	}
}