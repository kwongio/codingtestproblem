import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static int[] select;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		select = new int[M];
		visit = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		DFS(0, 0);
		System.out.println(sb.toString());
	}

	static void DFS(int depth, int start) {
		if (depth == M) {
			StringBuilder sb1 = new StringBuilder();
			for (int i = 0; i < select.length; i++) {
				sb1.append(select[i]).append(" ");
			}
			if (set.contains(sb1.toString()))
				return;
			set.add(sb1.toString());
			sb.append(sb1.toString()).append("\n");
		} else {
			for (int i = 0; i < N; i++) {
				if (!visit[i]) {
					visit[i] = true;
					select[depth] = arr[i];
					DFS(depth + 1, i + 1);
					visit[i] = false;
				}
			}
		}
	}
}
