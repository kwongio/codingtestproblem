import javax.sound.sampled.EnumControl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int maxLen = Integer.MIN_VALUE;
    static boolean[] visited;
    static int[] select;
    static int N;
    static int[] numbers;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] str = br.readLine().split(" ");
            if (!str[0].equals("0")) {
                N = Integer.parseInt(str[0]);

                numbers = new int[N];
                select = new int[6];
                visited = new boolean[N];
                for (int i = 0; i < N; i++) {
                    numbers[i] = Integer.parseInt(str[i+1]);
                }

                Arrays.sort(numbers);
                DFS(0, 0);
                System.out.println();
            } else {
                break;
            }
        }


    }

    private static void DFS(int depth, int start) {
        if (depth == 6) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                sb.append(select[i] + " ");
            }
            System.out.println(sb);
            return;
        }


        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                select[depth] = numbers[i];
                DFS(depth + 1, i + 1);
                visited[i] = false;
            }

        }
    }

}
