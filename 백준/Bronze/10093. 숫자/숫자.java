import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());

		long temp = a;
		a = Math.min(a, b);
		b = Math.max(temp, b);

		if (b - a == 0) {
			System.out.println(0);
		} else {
			System.out.println(b - a - 1);
		}
		for (long i = a + 1; i < b; i++) {
			System.out.print(i + " ");

		}
	}
}