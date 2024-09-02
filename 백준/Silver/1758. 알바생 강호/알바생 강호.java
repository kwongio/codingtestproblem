import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static Integer[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new Integer[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr, Collections.reverseOrder());
		long ret = 0;
		for (int i = 0; i < N; i++) {
			if(arr[i] - (i) > 0) {
				ret += arr[i] - i;
			}
		}
		System.out.println(ret);
	}
}