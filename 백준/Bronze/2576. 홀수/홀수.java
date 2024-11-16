import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ret =0 ;
		int min = 1000000000;
		for (int i = 0; i < 7; i++) {
			int num = Integer.parseInt(br.readLine());
			
			
			if(num % 2 == 1) {
				ret += num;
				min = Math.min(min, num);
			}
		}
		if(ret == 0) {
			System.out.println(-1);
		}else {
			System.out.println(ret);
			System.out.println(min);
		}
	}
}