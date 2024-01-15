import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int maxSum;
    static int result;
    static int N;
    static int[] card;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        maxSum = Integer.parseInt(st.nextToken());
        result = 0;
        card = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 0, 0);

        System.out.println(result);

    }

    private static void DFS(int L, int sum, int selectCount) {
        if (sum > maxSum) {
            return;
        }

        if (selectCount == 3) {
            result = Math.max(result, sum);
            return;
        }

        if(L == N && selectCount != 3){
            return;
        }
        DFS(L + 1, card[L] + sum, selectCount + 1);
        DFS(L + 1, sum, selectCount);
    }
}
