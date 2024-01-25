import javax.swing.plaf.IconUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] person;

    static boolean[] selected;
    static List<Integer>[] list;
    static int answer = Integer.MAX_VALUE;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        list = new ArrayList[N];
        selected = new boolean[N];
        person = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            person[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            for (int j = 0; j < a; j++) {
                list[i].add(Integer.parseInt(st.nextToken()) - 1);
            }
        }

        DFS(0);
        if (Integer.MAX_VALUE == answer) {
            answer = -1;
        }
        System.out.println(answer);
    }

    private static void DFS(int depth) {
        if (depth == N) {
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                if (selected[i]) {
                    a.add(i);
                } else {
                    b.add(i);

                }
            }
            if (a.size() == 0 || b.size() == 0) {
                return;
            }
            if (check(a) && check(b)) {
                int people = getPeople();
                answer = Math.min(people, answer);
            }
            return;

        }

        selected[depth] = true;
        DFS(depth + 1);
        selected[depth] = false;
        DFS(depth + 1);


    }

    private static int getPeople() {
        int a = 0;
        int b = 0;
        for (int i = 0; i < N; i++) {
            if (selected[i]) {
                a += person[i];
            } else {
                b += person[i];
            }
        }
        return Math.abs(a - b);

    }

    private static boolean check(List<Integer> l) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N];
        q.add(l.get(0));
        visited[l.get(0)] = true;
        int count = 1;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : list[now]) {
                if (l.contains(next) && !visited[next]) {
                    q.offer(next);
                    count++;
                    visited[next] = true;
                }

            }

        }
        if (count == l.size()) {
            return true;
        }
        return false;
    }

}