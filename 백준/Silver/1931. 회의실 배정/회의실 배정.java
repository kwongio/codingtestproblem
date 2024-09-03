import java.io.*;
import java.util.*;


public class Main {
	static PriorityQueue<int[]> q = new PriorityQueue<int[]>(
			(o1, o2) -> o1[1] == o2[1] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]));
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			q.add(new int[] { s, e });
		}
		int ret = 0;
		int e = -1;
		while (!q.isEmpty()) {
			int[] v = q.poll();
			if (e <= v[0]) {
				e = v[1];
				ret++;
			}
		}
		System.out.println(ret);
	}
}