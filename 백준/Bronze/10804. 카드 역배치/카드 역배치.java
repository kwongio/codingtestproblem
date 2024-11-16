import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] card = new int[21];
		for (int i = 1; i < 21; i++) {
			card[i] = i;
		}
		
		
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int s = a;
			int e = b;
			while(s <= e) {
				int temp = card[s];
				card[s] = card[e];
				card[e] = temp;
				s++;
				e--;
			}
		}
		for (int i = 1; i < 21; i++) {
			System.out.print(card[i] + " ");
		}

	}
}