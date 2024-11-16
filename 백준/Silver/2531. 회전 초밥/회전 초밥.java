import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {

	static int N, D, K, C;
	static int[] arr;
	static int[] eat;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 스시 개수
		int D = Integer.parseInt(st.nextToken()); // 가짓수
		int K = Integer.parseInt(st.nextToken()); // 연속으로 먹을 스시 개수
		int C = Integer.parseInt(st.nextToken()); // 쿠폰

		eat = new int[D + 1];
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			int v = Integer.parseInt(br.readLine());
			arr[i] = v;
		}

		int count = 0;
		for (int i = 0; i < K; i++) {
			if (eat[arr[i]] == 0) {
				count++;
			}
			eat[arr[i]]++;
		}

		int max = count;;
		for (int i = 1; i <= N; i++) {
			if(max <= count) {
				if(eat[C] == 0) {
					max = count + 1;
				}else {
					max = count;
				}
			}
			
			
			int end = (i + K - 1) % N;
			if(eat[arr[end]] == 0) {
				count++;
			}
			eat[arr[end]]++;
			
			
			eat[arr[i - 1]]--;
			if(eat[arr[i - 1]] == 0) {
				count--;
			}
		}
		System.out.println(max);

	}
}