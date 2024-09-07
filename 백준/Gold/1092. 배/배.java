import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static Integer[] crain;
	static int M;
	static List<Integer> box;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		crain = new Integer[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			crain[i] = Integer.parseInt(st.nextToken());
		}

		M = Integer.parseInt(br.readLine());
		box = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(crain, Comparator.reverseOrder());
		Collections.sort(box, Collections.reverseOrder());
		if (box.get(0) > crain[0]) {
			System.out.println(-1);
			return;
		} else {
			int cnt = 0;
			while (!box.isEmpty()) {
				int boxIdx = 0;
				int crainIdx = 0;
				while (crainIdx < N) {
					if (boxIdx == box.size())
						break;
					if (crain[crainIdx] >= box.get(boxIdx)) {
						box.remove(boxIdx);
						crainIdx++;
					} else {
						boxIdx++;
					}
				}
				cnt++;
			}
			System.out.println(cnt);
		}
	}
}