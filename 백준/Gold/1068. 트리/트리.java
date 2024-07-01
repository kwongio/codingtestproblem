import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N;
    static boolean[] visited;
    static List<Integer>[] tree;
    static int answer;
    static int delete;
    static int root;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        visited = new boolean[N];
        tree = new ArrayList[N];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            int temp = sc.nextInt();
            if (temp != -1) {
                tree[temp].add(i);
            } else {
                root = i;
            }
        }

        delete = sc.nextInt();
        if (delete == root) {
            System.out.println(0);
        } else {
            DFS(root);
            System.out.println(answer);
        }

    }

    static void DFS(int number) {
        visited[number] = true;
        int cNode = 0;
        for (int i : tree[number]) {
            if (!visited[i] && delete != i) {
                cNode++;
                DFS(i);
            }
        }
        if (cNode == 0) {
            answer++;
        }
    }
}