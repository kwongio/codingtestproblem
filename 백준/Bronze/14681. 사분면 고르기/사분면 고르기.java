import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a =Integer.parseInt(br.readLine());
		int b =Integer.parseInt(br.readLine());
		if(a > 0 && b > 0) {
			System.out.println(1);
		}else if(a > 0 && b < 0) {
			System.out.println(4);
		}else if(a < 0 && b > 0) {
			System.out.println(2);
		}else if(a < 0 && b < 0) {
			System.out.println(3);
		}
	}
}