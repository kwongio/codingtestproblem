import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int K;
    static List<Integer>[] list;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        list = new ArrayList[K];
        String[] split = br.readLine().split(" ");
        int length = (int) Math.pow(2, K) - 1;
        arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        for (int i = 0; i < K; i++) {
            list[i] = new ArrayList<>();
        }

        DFS(0, 0, arr.length);
        for (int i = 0; i < K; i++) {
            for (Integer integer : list[i]) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

    }

    private static void DFS(int depth, int s, int e) {
        if (s > e) return;
        if(depth == K){
            return;
        }
        if (s == e) {
            list[depth].add(arr[s]);
            return;
        }

        int mid = (s + e) / 2;
        list[depth].add(arr[mid]);
        DFS(depth + 1, s, mid - 1);
        DFS(depth + 1, mid + 1, e);
        return;
    }
}