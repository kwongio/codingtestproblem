import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int N;
    static int min = Integer.MAX_VALUE;
    static boolean[] broken;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int brokenButton = Integer.parseInt(br.readLine());

        broken = new boolean[10];
        if (brokenButton > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < brokenButton; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        // 현재 채널에서 +, -만 사용하는 경우 초기화
        min = Math.abs(N - 100);

        // 0부터 9까지 가능한 숫자로 탐색 시작
        for (int i = 0; i <= 9; i++) {
            if (!broken[i]) {
                DFS(1, i);
            }
        }

        System.out.println(min);
    }

    private static void DFS(int depth, int num) {
        if (depth > 6) return; // 최대 깊이 제한 (6자리 수까지)

        // 최소 버튼 누름 수 갱신
        min = Math.min(min, depth + Math.abs(N - num));

        // 다음 자리수 탐색
        for (int i = 0; i <= 9; i++) {
            if (!broken[i]) {
                DFS(depth + 1, num * 10 + i);
            }
        }
    }
}
