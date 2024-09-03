import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	static int N;
	static long[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		long min = arr[arr.length - 1];
		int s = 0;
		int e = 0;
		if (arr.length % 2 == 1) {
			min = Math.max(min, arr[arr.length - 1]);
			e = arr.length - 2;
		} else {
			e = arr.length - 1;
		}

		while (s < e) {
			min = Math.max(min, arr[s] + arr[e]);
			s++;
			e--;
		}
		System.out.println(min);

	}
}