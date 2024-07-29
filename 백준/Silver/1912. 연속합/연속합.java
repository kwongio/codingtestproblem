import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] arr;
	static int[] sum;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		sum = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {

			arr[i] = Integer.parseInt(st.nextToken());
		}
		int count = 0;
		for (int i = 0; i < N; i++) {
			count += arr[i];
			max = Math.max(count, max);
			if (count < 0) {
				count = 0;
			}

		}
		System.out.println(max);
	}
}