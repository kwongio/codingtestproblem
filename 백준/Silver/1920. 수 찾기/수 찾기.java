import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static int[] a;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		a = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int b = Integer.parseInt(st.nextToken());
			int s = 0;
			int e = N - 1;
			while (s <= e) {
				int mid = s + (e - s) / 2;
				if (a[mid] == b) {
					sb.append(1).append("\n");
					break;
				} else if (a[mid] > b) {
					e = mid - 1;
				} else if (a[mid] < b) {
					s = mid + 1;
				}
			}
			if(s >  e) {
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
	}
}