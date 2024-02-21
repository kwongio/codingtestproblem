import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    static int[] parent;
    static int[] level;
    static int T;
    static int F;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int testcase = 0; testcase < T; testcase++) {
            F = Integer.parseInt(br.readLine());
            parent = new int[F * 2];
            level = new int[F * 2];
            int idx = 0;
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < F * 2; i++) {
                parent[i] = i;
                level[i] = 1;
            }
            for (int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                if (!map.containsKey(a)) {
                    map.put(a, idx++);
                }
                if (!map.containsKey(b)) {
                    map.put(b, idx++);
                }
                System.out.println(union(map.get(a), map.get(b)));
            }

        }
    }

    static int union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
            level[a] += level[b];
            level[b] = 1;
        }
        return level[a];
    }

    static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
}