import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int[] arr;
    static int[] select;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9];
        select = new int[7];
        visit = new boolean[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        DFS(0, 0);
    }

    private static void DFS(int depth, int start) {
        if (depth == 7) {
            if (Arrays.stream(select).sum() == 100) {
                Arrays.sort(select);
                for (int i = 0; i < 7; i++) {
                    System.out.println(select[i]);
                }
                System.exit(0);
            }
            return;
        }
        for (int i = start; i < 9; i++) {
            if (!visit[i]) {
                visit[i] = true;
                select[depth] = arr[i];
                DFS(depth + 1, i + 1);
                visit[i] = false;
            }
        }
    }
}