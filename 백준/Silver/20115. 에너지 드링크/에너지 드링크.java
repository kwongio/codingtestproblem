import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static double[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new double[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Double.parseDouble(st.nextToken());
		}
		Arrays.sort(arr);
		double max = arr[arr.length - 1];
		for (int i = 0; i < N - 1; i++) {
			max += arr[i] / 2;
		}
		System.out.println(max);
	}
}