import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 참가자
		int K = Integer.parseInt(st.nextToken()); // 한 방 최대 인원수

		// 남학생끼리, 여학생끼리, 같은 학년 끼리

		int[][] arr = new int[2][7]; // 성별 1,0 : 학년 1~6;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			arr[S][Y]++;
		}

		int ans = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j <= 6; j++) {
				ans += (arr[i][j] + K - 1) / K;
			}
		}
		System.out.println(ans);

	}
}