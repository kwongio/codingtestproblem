import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static int[] select;
	static int[] arr;
	static int[] oper;
	static int min = Integer.MAX_VALUE;;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		select = new int[N - 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		oper = new int[4];
		for (int i = 0; i < 4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		DFS(0);
		System.out.println(max);
		System.out.println(min);

	}

	static void DFS(int depth) {
		// 연산자 다 고름
		if (depth == N - 1) {
			int ret = arr[0];
			for (int i = 0; i < select.length; i++) {
				if (select[i] == 0) { // 덧셈
					ret += arr[i + 1];
				} else if (select[i] == 1) { // 뺄셈
					ret -= arr[i + 1];
				} else if (select[i] == 2) { // 곱셈
					ret *= arr[i + 1];
				} else if (select[i] == 3) { // 나눗셈
					ret /= arr[i + 1];
				}
			}
			max = Math.max(max, ret);
			min = Math.min(min, ret);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (oper[i] > 0) {
				select[depth] = i;
				oper[i]--;
				DFS(depth + 1);
				oper[i]++;
			}
		}
	}
}