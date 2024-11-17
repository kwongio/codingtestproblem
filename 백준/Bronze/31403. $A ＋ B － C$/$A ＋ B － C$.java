import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long a = Integer.parseInt(br.readLine());
		long b = Integer.parseInt(br.readLine());
		long c = Integer.parseInt(br.readLine());
		System.out.println(a + b - c);
		System.out.println(Integer.parseInt(a + "" + b) - c);
	}
}