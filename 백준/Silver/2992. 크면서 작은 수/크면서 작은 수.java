import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int min;
    static boolean[] visited;
    static String[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        min = Integer.parseInt(input);
        selected = new String[input.length()];
        visited = new boolean[input.length()];
        String[] str = input.split("");
        Arrays.sort(str);
        DFS(0, str);

        System.out.println(0);

    }

    private static void DFS(int depth, String[] str) {
        if (depth == str.length) {
            StringBuilder sb = new StringBuilder();
            for (String s : selected) {
                sb.append(s);
            }
            if (Integer.parseInt(sb.toString()) > min) {
                System.out.println(Integer.parseInt(sb.toString()));
                System.exit(0);
            }
            return;
        }

        for (int i = 0; i < str.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[depth] = str[i];
                DFS(depth + 1, str);
                visited[i] = false;

            }
        }
    }
}