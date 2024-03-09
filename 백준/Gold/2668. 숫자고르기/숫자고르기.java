import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int N;
    static int[] arr;
    static List<Integer> list = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine()) - 1;
        }

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            DFS(i, i);
            visited[i] = false;
        }
        Collections.sort(list); // 리스트를 오름차순으로 정렬
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i ) + 1);
        }
    }

    private static void DFS(int start, int target) {
        if (!visited[arr[start]]) {
            visited[arr[start]] = true;
            DFS(arr[start], target);
            visited[arr[start]] = false;
        }

        if (arr[start] == target) {
            list.add(target);
            return;
        }
    }
}