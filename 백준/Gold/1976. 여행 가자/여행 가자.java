import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[] parent;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    union(i, j);
                }
            }
        }
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(city[i][j]);
//            }
//            System.out.println();
//        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken()));
        for (int i = 1; i < M; i++) {
            int now = Integer.parseInt(st.nextToken());
            if (start != find(now)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    static int find(int a) {
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }
}