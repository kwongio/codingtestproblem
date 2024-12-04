import java.util.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }


        // dp
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        int count = 1;
        int max = Arrays.stream(dp).max().getAsInt();
        System.out.println(max);

        for (int i = N - 1; i >= 0; i--) {
            if (dp[i] == max) {
                list.add(arr[i]);
                max--;
            }
        }
        Collections.reverse(list);
        list.forEach(v -> System.out.print(v + " "));

    }


}