import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static List<Integer>[] list;
    static boolean[] visit;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        parent = new int[N];
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        list = new List[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        visit = new boolean[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(find(a) != find(b)){
                union(a, b);
            }else{
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println(0);
    }

    static int find(int a) {
        if (parent[a] == a) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            parent[a] = b;
        }
    }
}

