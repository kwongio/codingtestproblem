import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N = 10;
    static int[] arr = new int[N];
    static int[] v = new int[101];
    static List<List<Integer>> list = new ArrayList<>();
    static int[] mal = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()
        );
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        setMap();
        System.out.println(DFS(0));
    }

    private static int DFS(int depth) {
        if (depth == N) return 0;
        int ret = 0;
        for (int i = 0; i < 4; i++) {
            int temp_idx = mal[i];
            int mal_idx = move(temp_idx, arr[depth]);
            if (isMal(mal_idx, i)) continue;
            mal[i] = mal_idx;
            ret = Math.max(ret, DFS(depth + 1) + v[mal_idx]);
            mal[i] = temp_idx;
        }
        return ret;
    }

    private static boolean isMal(int malIdx, int idx) {
        if (malIdx == 100) return false;
        for (int i = 0; i < 4; i++) {
            if (i == idx) continue;
            if (mal[i] == malIdx) return true;
        }
        return false;
    }

    private static int move(int cur, int cnt) {
        if (cur == 100) return 100;
        if (list.get(cur).size() >= 2) {
            cur = list.get(cur).get(1);
            cnt--;
        }

        while (cnt > 0) {
            cur = list.get(cur).get(0);
            if (cur == 100) break;
            cnt--;
        }
        return cur;
    }


    private static void setMap() {
        for (int i = 0; i <= 19; i++) {
            list.add(new ArrayList<>());
            list.get(i).add(i + 1);
        }
        for (int i = 0; i < 30; i++) {
            list.add(new ArrayList<>());
        }

        v[1] = 2;
        v[2] = 4;
        v[3] = 6;
        v[4] = 8;
        v[5] = 10;
        v[6] = 12;
        v[7] = 14;
        v[8] = 16;
        v[9] = 18;
        v[10] = 20;
        v[11] = 22;
        v[12] = 24;
        v[13] = 26;
        v[14] = 28;
        v[15] = 30;
        v[16] = 32;
        v[17] = 34;
        v[18] = 36;
        v[19] = 38;
        v[20] = 40;

        v[21] = 13;
        v[22] = 16;
        v[23] = 19;

        v[24] = 25;
        v[25] = 30;
        v[26] = 35;


        //10에서 시작
        list.get(5).add(21);
        list.get(21).add(22);
        list.get(22).add(23);
        list.get(23).add(24);


        //끝에
        list.get(24).add(25);
        list.get(25).add(26);
        list.get(26).add(20);
        list.get(20).add(100);

        v[27] = 22;
        v[28] = 24;

        //20에서 시작
        list.get(10).add(27);
        list.get(27).add(28);
        list.get(28).add(24);

        v[29] = 28;
        v[30] = 27;
        v[31] = 26;

        //30 에서 시작
        list.get(15).add(29);
        list.get(29).add(30);
        list.get(30).add(31);
        list.get(31).add(24);
    }
}