import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int K;
	static int max = 0;
	static String[] words;
	static boolean[] visit = new boolean[26];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		words = new String[N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			str = str.replace("a", "");
			str = str.replace("t", "");
			str = str.replace("n", "");
			str = str.replace("i", "");
			str = str.replace("c", "");
			words[i] = str;

		}
		visit['a' - 'a'] = true;
		visit['n' - 'a'] = true;
		visit['t' - 'a'] = true;
		visit['i' - 'a'] = true;
		visit['c' - 'a'] = true;
		if (K < 5) {
			System.out.println(max);
		} else {
			DFS(0, 0);
			System.out.println(max);
		}
	}

	static void DFS(int depth, int s) {
		if (depth == K - 5) {
			int count = 0;
			for (int i = 0; i < words.length; i++) {
				boolean flag = true;
				for (int j = 0; j < words[i].length(); j++) {
					if (!visit[words[i].charAt(j) - 'a']) {
						flag = false;
						break;
					}
				}
				if (flag) {
					count++;
				}
			}
			max = Math.max(max, count);
			return;
		}

		for (int i = s; i < 26; i++) {
			if (visit[i]) {
				continue;
			}
			visit[i] = true;
			DFS(depth + 1, i + 1);
			visit[i] = false;
		}
	}
}
