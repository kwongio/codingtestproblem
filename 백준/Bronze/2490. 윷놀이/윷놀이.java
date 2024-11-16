import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int[] arr = new int[] { a, b, c, d };
			int count = (int) Arrays.stream(arr).filter((v) -> v == 0).count();
			if(count == 4) {
				System.out.println("D");
			}else if(count == 3) {
				System.out.println("C");
			}else if(count == 2) {
				System.out.println("B");
			}else if(count == 1) {
				System.out.println("A");
			}else {
				System.out.println("E");
			}
		}
	}
}