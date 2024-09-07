import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static List<int[]> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list.add(new int[] { s, e });
		}
		Collections.sort(list, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
		int cnt = 0;
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		q.add(list.get(0)[1]);
		for (int i = 1; i < N; i++) {
			if (q.peek() <= list.get(i)[0]) {
				q.poll();
			}
			q.add(list.get(i)[1]);
		}
		System.out.println(q.size());

	}
}