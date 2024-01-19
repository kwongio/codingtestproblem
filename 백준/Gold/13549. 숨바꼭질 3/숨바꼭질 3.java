import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N, M;

    static int[] visited = new int[100001];

    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visited[N] = 1;
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == M) {
                System.out.println(visited[now] - 1);
                return;
            }
            if (now * 2 <= 100000 && visited[now * 2] == 0) {
                visited[now * 2] = visited[now];
                q.add(now * 2);
            }

            if (now - 1 >= 0 && visited[now - 1] == 0) {
                visited[now - 1] = visited[now] + 1;
                q.add(now - 1);
            }

            if (now + 1 <= 100000 && visited[now + 1] == 0) {
                visited[now + 1] = visited[now] + 1;
                q.add(now + 1);
            }

        }
    }
}