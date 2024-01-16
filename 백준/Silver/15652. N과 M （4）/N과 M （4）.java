

import java.util.*;

public class Main {
    static int n;
    static int m;
    static boolean visited[];
    static int selected[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n + 1];
        selected = new int[m];
        DFS(1, 0);
    }

    private static void DFS(int at, int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(selected[i] + " ");

            }
            System.out.println();
        } else {

            for (int i = at; i <= n; i++) {
                selected[depth] = i;
                DFS(i, depth + 1);
            }
        }
    }
}