
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    static int N, M;

    static int[] visited = new int[100001];
    static int[] predecessor = new int[100001];


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
                break;
            }

            if (now + 1 <= 100000 && visited[now + 1] == 0) {
                visited[now + 1] = visited[now] + 1;
                predecessor[now + 1] = now;
                q.add(now + 1);
            }
            if (now - 1 >= 0 && visited[now - 1] == 0) {
                visited[now - 1] = visited[now] + 1;
                predecessor[now - 1] = now;
                q.add(now - 1);
            }


            if (now * 2 <= 100000 && visited[now * 2] == 0) {
                visited[now * 2] = visited[now] + 1;
                predecessor[now * 2] = now;
                q.add(now * 2);
            }
        }
        int index = M;
        Stack<Integer> stack = new Stack<>();
        stack.push(M);
        while (index != N) {
            stack.push(predecessor[index]);
            index = predecessor[index];
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}