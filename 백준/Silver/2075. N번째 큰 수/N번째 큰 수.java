import java.util.*;
import java.io.*;
import java.nio.BufferUnderflowException;

class Main {
	static int N;

	static long[][] board;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board = new long[N][N];
		PriorityQueue<Long> q = new PriorityQueue<Long>((o1, o2) -> Long.compare(o1, o2));
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				q.add(Long.parseLong(st.nextToken()));
				if (q.size() == N + 1) {
					q.poll();
				}
			}
		}
		System.out.println(q.poll());
	}
}