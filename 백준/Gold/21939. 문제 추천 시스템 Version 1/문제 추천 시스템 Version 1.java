import java.io.*;
import java.util.*;

public class Main {
    static TreeMap<Integer, TreeSet<Integer>> problems = new TreeMap<>(); // 난이도별 문제 관리
    static Map<Integer, Integer> problemMap = new HashMap<>(); // 문제 번호 -> 난이도 매핑

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken()); // 문제 번호
            int L = Integer.parseInt(st.nextToken()); // 난이도
            addProblem(P, L);
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("add")) {
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                addProblem(P, L);
            } else if (command.equals("solved")) {
                int P = Integer.parseInt(st.nextToken());
                removeProblem(P);
            } else if (command.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());
                sb.append(recommendProblem(x)).append("\n");
            }
        }
        System.out.print(sb);
    }

    static void addProblem(int P, int L) {
        problemMap.put(P, L);
        problems.computeIfAbsent(L, k -> new TreeSet<>()).add(P);
    }

    static void removeProblem(int P) {
        int L = problemMap.get(P);
        problemMap.remove(P);
        TreeSet<Integer> set = problems.get(L);
        set.remove(P);
        if (set.isEmpty()) {
            problems.remove(L);
        }
    }

    static int recommendProblem(int x) {
        if (x == 1) { // 가장 어려운 문제
            return problems.lastEntry().getValue().last();
        } else { // 가장 쉬운 문제
            return problems.firstEntry().getValue().first();
        }
    }
}