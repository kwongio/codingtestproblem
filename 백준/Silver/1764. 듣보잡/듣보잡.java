import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static String[] a;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		a = new String[N];
		for (int i = 0; i < N; i++) {
			a[i] = br.readLine();
		}
		Arrays.sort(a);

		int ret = 0;
		StringBuilder sb = new StringBuilder();
		List<String> answer = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			String input = br.readLine();
			int s = 0;
			int e = N - 1;
			while (s <= e) {
				int mid = s + (e - s) / 2;
				if (a[mid].equals(input)) {
					ret++;
					answer.add(a[mid]);
					break;
				} else if (a[mid].compareTo(input) < 0) {
					s = mid + 1;
				} else {
					e = mid - 1;
				}
			}
		}
		Collections.sort(answer);
		System.out.println(ret);
		
		for(String s : answer) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);
	}
}