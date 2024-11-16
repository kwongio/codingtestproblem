import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < N; i++) {
			int v =Integer.parseInt(st.nextToken());
			map.put(v, map.getOrDefault(v, 0) + 1);
		}
		int input = Integer.parseInt(br.readLine());
		if(map.get(input) == null) {
			System.out.println(0);
		}else {
			System.out.println(map.get(input));
		}
	}
}