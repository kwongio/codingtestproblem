import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;

public class Main {
    static int N;
    static int[] select;
    static boolean[] visit;
    static List<String> list = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int M;
    static Map<Character, Integer> alpha = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                if(!alpha.containsKey(input.charAt(j))){
                    alpha.put(input.charAt(j), alpha.size());
                }
            }
            list.add(input);
        }
        M = alpha.size();
        visit = new boolean[M];
        select = new int[M];

        DFS(0);
        System.out.println(max);
    }

    private static void DFS(int depth) {
        if (depth == M) {
            int sum =0 ;
            for (String s : list) {
                sum += cal(s);
            }
            max = Math.max(sum, max);
            return;
        }

        for (int i = 0; i < M; i++) {
            if (!visit[i]) {
                visit[i] = true;
                select[depth] = 9 - i;
                DFS(depth + 1);
                visit[i] = false;
            }
        }
    }

    private static int cal(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum = sum * 10 + select[alpha.get(s.charAt(i))];
        }
        return sum;
    }
}
