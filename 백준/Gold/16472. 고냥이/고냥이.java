import java.util.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import java.io.*;
import java.lang.reflect.Array;

public class Main {
	static int N;
	static char[] arr;
	static int[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		visit = new int[26];
		arr = br.readLine().toCharArray();
		int ans = 0;
		for (int R = 0, L = 0; R < arr.length; R++) {
			// R 번째를 오른쪽에 추가
			visit[arr[R] - 'a']++;
			// 불가능하면 가능할때까지 L을 이동

			while (true) {
				int kind = 0;
				for (int i = 0; i < 26; i++) {
					if (visit[i] != 0)
						kind++;
				}
				if (kind <= N)
					break;
				visit[arr[L] - 'a']--;
				L++;
			}
			// 정답 개신
			ans = Math.max(ans, R - L + 1);
		}
		System.out.println(ans);
	}
}
