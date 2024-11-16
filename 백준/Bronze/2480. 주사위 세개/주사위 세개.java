import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int ret = 0;
		if (a == b && a == c && b == c) {
			ret = 10000 + a * 1000;
		} else if (a == b || a == c || b == c) {
			if(a==b) {
				ret = 1000 + a*100;
			}else if(a==c) {
				ret = 1000 + c*100;
			}else {
				ret = 1000 + b*100;
			}
		} else {
			ret = Math.max(a, Math.max(b, c)) * 100;
		}
		System.out.println(ret);

	}
}