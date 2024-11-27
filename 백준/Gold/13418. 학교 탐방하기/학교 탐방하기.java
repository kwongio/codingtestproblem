import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<int[]> list;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        parent = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new int[]{a, b, c});
        }
        int maxCnt = 0;
        list.sort(Comparator.comparingInt(o -> o[2])); // 오르막 ㅇ
        for (int[] cur : list) {
            int a = cur[0];
            int b = cur[1];
            int c = cur[2];

            if (find(a) != find(b)) {
                if (c == 0)
                    maxCnt++;
                union(a, b);
            }
        }
        for (int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }

        int minCnt = 0;
        list.sort(Comparator.comparingInt(o -> -o[2]));
        for (int[] cur : list) {
            int a = cur[0];
            int b = cur[1];
            int c = cur[2];

            if (find(a) != find(b)) {
                if (c == 0)
                    minCnt++;
                union(a, b);
            }
        }
        System.out.println((int)Math.pow(maxCnt, 2) - (int)Math.pow(minCnt, 2));


        //  a b c : 0오르막 1 내리막
        //최선의 경로와 최악의 경로 피로도 차이 구하기 오르막오르면 횟수로 따지기
    }

    static int find(int a) {
        if (parent[a] == a) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }
}