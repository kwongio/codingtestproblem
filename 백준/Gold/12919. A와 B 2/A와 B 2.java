import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

class Main {

    static String S, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        S = br.readLine();
        T = br.readLine();

        DFS(T);
        System.out.println(0);
    }

    private static void DFS(String end) {
        if (end.length() < S.length()) return;
        if (end.length() == S.length()) {
            if (S.equals(end)) {
                System.out.println(1);
                System.exit(0);
            }
        }


        if (end.endsWith("A")) {
            DFS(end.substring(0, end.length() - 1));
        }
        if (end.startsWith("B")) {
            DFS(new StringBuilder(end.substring(1)).reverse().toString());
        }
    }
}