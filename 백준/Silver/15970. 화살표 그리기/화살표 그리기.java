import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static Map<Long, Long> num = new HashMap<>();
	static List<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int color = Integer.parseInt(st.nextToken());
			list[color].add(num);
		}
		int ret = 0;
		for (int i = 1; i < N + 1; i++) {
			Collections.sort(list[i]);
			int prev = 100_001;
			for (int j = 0; j < list[i].size() - 1; j++) {
				if (Math.abs(list[i].get(j) - prev) > Math.abs(list[i].get(j + 1) - list[i].get(j))) {
					ret += Math.abs(list[i].get(j + 1) - list[i].get(j));
				} else {
					ret += Math.abs(list[i].get(j) - prev);
				}
				prev = list[i].get(j);
			}
			if (list[i].size() >= 2 && prev != 100_001)
				ret += Math.abs(list[i].get(list[i].size() - 1) - prev);
		}
		System.out.println(ret);
	}
}