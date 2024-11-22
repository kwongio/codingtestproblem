import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br;
    private static StringBuilder sb = new StringBuilder();
    static String input;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();
        visited = new boolean[input.length()];

        zoac(0, input.length() - 1);

        br.close();
        System.out.println(sb.toString());
    }

    private static void zoac(int left, int right) throws IOException {
        if (left > right) return;

        int idx = left;

        // left와 right 사이에 있는 글자중 사전식 순서가 가장 낮은 글자를 찾는다.(idx)
        for (int i = left; i <= right; i++) {
            if (input.charAt(idx) > input.charAt(i)) {
                idx = i;
            }
        }
        visited[idx] = true;

        for (int i = 0; i < input.length(); i++) {
            if (visited[i]) {
                sb.append(input.charAt(i));
            }
        }
        sb.append("\n");

        // 여기도 순서가 안맞으면 틀렸습니다를 확인할 수 있다.
        // 반드시 이 dfs 순서로 재귀를 구현해야 한다.
        // 그래야 사전식 순서가 맞춰진다.
        zoac(idx + 1, right);
        zoac(left, idx  - 1);
    }
}