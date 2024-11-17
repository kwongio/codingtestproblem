import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t= Integer.parseInt(st.nextToken());
		int m= Integer.parseInt(st.nextToken());
		
		if(m < 45) {
			t = t- 1;
			if(t < 0) {
				t = 23;
			}
		}
		
		m = (m + 15)%60;
		System.out.println(t + " " + m);
	}
}
