import java.util.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import java.io.*;
import java.lang.reflect.Array;

public class Main {
	static int N;
	static List<int[]> list = new ArrayList<int[]>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new int[] { a, b });
		}
		Collections.sort(list,
				(o1, o2) -> o1[1] == o2[1] ? Integer.compare(o2[0], o1[0]) : Integer.compare(o1[1], o2[1]));
		PriorityQueue<Integer> q = new PriorityQueue<Integer>((o1, o2) -> o1 - o2);
		for (int[] v : list) {
			q.add(v[0]);
			while (q.size() > v[1]) {
				q.poll();
			}
		}
		int ans = 0;
		for (int v : q) {
			ans += v;
		}
		System.out.println(ans);
	}
}