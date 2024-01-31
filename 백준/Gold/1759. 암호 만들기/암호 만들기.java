import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int L;
    static int C;
    static char[] str;

    static char[] select;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        str = new char[C];
        select = new char[L];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < split.length; i++) {
            str[i] = split[i].toCharArray()[0];
        }
        Arrays.sort(str);
        DFS(0, 0);

    }

    private static void DFS(int depth, int start) {
        if (depth == L) {
            if (isValid()) {
                System.out.println(select);
            }
            return;
        }

        for (int i = start; i < C; i++) {
                select[depth] = str[i];
                DFS(depth + 1, i + 1);

        }
    }
    public static boolean isValid() {
        int mo = 0;
        int ja = 0;

        for (char x : select) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                mo++;
            } else {
                ja++;
            }
        }

        if (mo >= 1 && ja >= 2) {
            return true;
        }
        return false;
    }

}
