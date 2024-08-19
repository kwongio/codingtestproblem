import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static Map<String, Integer> c = new HashMap<String, Integer>();
	static TreeSet<String> list = new TreeSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			String ext = br.readLine().split("\\.")[1];
			if (list.contains(ext)) {
				c.put(ext, c.get(ext) + 1);
			} else {
				list.add(ext);
				c.put(ext, 1);
			}
		}
		for (String s : list) {
			System.out.println(s + " " + c.get(s));
		}
	}
}