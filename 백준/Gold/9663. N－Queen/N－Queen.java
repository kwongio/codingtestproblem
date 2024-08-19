import java.util.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import java.io.*;

public class Main {
	static int N;
	static int[] select;
	static boolean[] visit;
	static int count;
	// 순서가 중요
	// 중복 제거

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		select = new int[N];
		visit = new boolean[N];
		DFS(0);
		System.out.println(count);
	}

	static void DFS(int depth) {
		// 연산자 다 고름
		if (depth == N) {
			count++;
			return;
		}
		for (int i = 0; i < N; i++) {
			select[depth] = i;
			if (!visit[i] && check(depth)) {
				visit[i] = true;
				DFS(depth + 1);
				visit[i] = false;
			}
		}
	}

	static boolean check(int depth) {
		for (int i = 0; i < depth; i++) {
			if (Math.abs(depth - i) == Math.abs(select[depth] - select[i])) {
				return false;
			}
		}
		return true;
	}
}
