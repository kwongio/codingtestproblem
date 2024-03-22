
import java.util.Scanner;

public class Main {

    static int N, M;
    static long dist[];
    static long cost[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dist = new long[N - 1];
        cost = new long[N];

        for (int i = 0; i < N - 1; i++) {
            dist[i] = sc.nextInt();
        }
        for (int i = 0; i < N ; i++) {
            cost[i] = sc.nextInt();
        }
        long min = cost[0];
        long sum = 0;
        for (int i = 0; i < N - 1; i++) {
            if (min > cost[i]) {
                min = cost[i];
            }
            sum += min * dist[i];
        }
        System.out.println(sum);
    }
}