import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 키, 몸무게 -> 등수
		int N = Integer.parseInt(br.readLine());

		List<int[]> p = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			p.add(new int[] { h, w });
		}

		
		StringBuilder sb = new StringBuilder();
		for (int[] p1 : p) {
			int rank = 1;
			for (int[] p2 : p) {
				if (isSmall(p1, p2)) {
					rank++;
				}
			}
			sb.append(rank).append(" ");
		}
		System.out.println(sb);
	}

	public static boolean isSmall(int[] p1, int[] p2) {
		return p1[0] < p2[0] && p1[1] < p2[1];
	}
}