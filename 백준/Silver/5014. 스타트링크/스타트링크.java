import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int N;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken()); // F층 건물
        int S = Integer.parseInt(st.nextToken());// 현재 위치
        int G = Integer.parseInt(st.nextToken());// 목적지
        int U = Integer.parseInt(st.nextToken());//업
        int D = Integer.parseInt(st.nextToken());//다운

        visited = new boolean[F + 1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{S, 0});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0] == G) {
                System.out.println(now[1]);
                System.exit(0);
            }

            if (!visited[now[0]]) {
                visited[now[0]] = true;
                if (now[0] - D >= 1) {
                    q.add(new int[]{now[0] - D, now[1] + 1});
                }
                if (now[0] + U <= F) {
                    q.add(new int[]{now[0] + U, now[1] + 1});
                }
            }
        }
        System.out.println("use the stairs");
    }
}