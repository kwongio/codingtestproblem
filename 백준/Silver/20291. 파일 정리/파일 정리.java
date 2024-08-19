import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static TreeMap<String, Integer> list = new TreeMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			String ext = br.readLine().split("\\.")[1];
			if (list.containsKey(ext)) {
				list.put(ext, list.get(ext) + 1);
			} else {
				list.put(ext, 1);
			}
		}
		for (String s : list.keySet()) {
			System.out.println(s + " " + list.get(s));
		}
	}
}