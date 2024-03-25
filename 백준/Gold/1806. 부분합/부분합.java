import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int[] arr = new int[N + 1];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        while (end <= N && start <= N) {
            if (sum >= S && min > end - start) {
                min = end - start;
            } else if (sum < S) {
                sum += arr[end++];
            } else {
                sum -= arr[start++];
            }
        }
        if (min == Integer.MAX_VALUE) {
            System.out.println("0");
        } else {
            System.out.println(min);

        }
    }

}
