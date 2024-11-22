import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    static int N;
    static List<Integer> arr;
    static int[] select;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] number = br.readLine().split(" ");
            N = Integer.parseInt(number[0]);
            if (N == 0) {
                break;
            }
            arr = new ArrayList<>();
            select = new int[6];
            for (int i = 1; i <= N; i++) {
                int value = Integer.parseInt(number[i]);
                arr.add(value);
            }
            arr.sort(Comparator.comparing(o -> o));
            DFS(0, 0);
            System.out.println();
        }
    }

    private static void DFS(int depth, int s) {
        if (depth == 6) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                sb.append(select[i]).append(" ");
            }
            System.out.println(sb);
            return;
        }
        for (int i = s; i < N; i++) {
            select[depth] = arr.get(i);
            DFS(depth + 1, i + 1);
        }
    }
}