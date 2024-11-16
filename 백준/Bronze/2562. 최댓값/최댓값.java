import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int idx = 0;
		int max = 0;
		for (int i = 1; i <= 9; i++) {
			int a = Integer.parseInt(br.readLine());
			if (max < a) {
				idx = i;
				max = a;
			}
		}
		System.out.println(max);
		System.out.println(idx);
	}
}