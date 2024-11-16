import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		int[] arr = new int[9];
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}

		Loop: for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - arr[i] - arr[j] == 100) {
					arr[i] = 101;
					arr[j] = 101;
					Arrays.sort(arr);
					break Loop;
				}
			}
		}
		for (int i = 0; i < 7; i++) {
			System.out.println(arr[i]);

		}
	}
}