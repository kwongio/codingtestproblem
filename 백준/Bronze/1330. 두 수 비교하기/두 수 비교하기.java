import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		if(a > b) {
			System.out.println(">");
		}else if(a == b) {
			System.out.println("==");
		}if(a < b) {
			System.out.println("<");
		}
	}
}