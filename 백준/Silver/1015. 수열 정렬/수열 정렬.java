import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr;
	static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		p = new int[N];
		st = new StringTokenizer(br.readLine());
		List<B> b = new ArrayList<Main.B>();
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			b.add(new B(arr[i], i));
		}
		Collections.sort(b);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			p[b.get(i).idx] = i;
		}

		for (int i = 0; i < N; i++) {
			sb.append(p[i]).append(" ");
		}
		System.out.println(sb);

	}

	static class B implements Comparable<B> {
		int num;
		int idx;

		public B(int num, int idx) {
			super();
			this.num = num;
			this.idx = idx;
		}

		@Override
		public int compareTo(B o) {

			return Integer.compare(this.num, o.num);
		}
	}
}
