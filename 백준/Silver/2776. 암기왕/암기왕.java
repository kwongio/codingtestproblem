import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			Set<Integer> s1 = new HashSet<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				s1.add(Integer.parseInt(st.nextToken()));

			}
			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				if (s1.contains(Integer.parseInt(st.nextToken()))) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			}
		}
		System.out.println(sb);

	}
}