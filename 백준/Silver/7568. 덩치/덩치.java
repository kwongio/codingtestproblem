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

		for (int[] v : p) {
			int count = 1;
			for (int[] a : p) {
				if (v[0] < a[0] && v[1] < a[1]) {
					count++;
				}
			}
			System.out.print(count + " ");
		}

	}
}