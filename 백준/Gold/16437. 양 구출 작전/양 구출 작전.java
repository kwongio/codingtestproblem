import javax.naming.spi.DirStateFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static long[] arr;
    static List<Integer>[] list;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new long[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 2; i <= N; i++) { //i는 현재 섬번호
            st = new StringTokenizer(br.readLine());

            String t = st.nextToken(); // 양인지 늑대인지 w는 늑대  s양
            int a = Integer.parseInt(st.nextToken()); // 마리수
            int p = Integer.parseInt(st.nextToken()); // i번째섬에서 p섬으로 가는곳
            if (t.equals("W")) {
                arr[i] = -a;
            } else if (t.equals("S")) {
                arr[i] = a;
            }
            list[p].add(i);
        }
        DFS(1, -1);
        System.out.println(arr[1]);
    }

    private static void DFS(int depth, int pa) {


        for (int next : list[depth]) {
            DFS(next, depth);
        }

        if (pa != -1) {
            if (arr[depth] > 0) {
                arr[pa] += arr[depth];
            }
        }
    }
}