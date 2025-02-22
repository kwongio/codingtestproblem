import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<int[]> list = new ArrayList<>();
    static int[] parent;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new int[]{a, b, c});
        }
        list.sort(Comparator.comparingInt(a -> a[2]));


        int count = 0;
        for (int[] v : list) {
            int a = v[0];
            int b = v[1];
            int c = v[2];
            if (count == N - 2) {
                break;
            }
            if (find(a) != find(b)) {
                answer += c;
                count++;
                union(a, b);
            }

        }
        System.out.println(answer);
    }

    static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        parent[b] = a;
    }
}
