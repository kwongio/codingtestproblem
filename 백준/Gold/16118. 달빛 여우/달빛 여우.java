import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static List<Edge>[] list;
    static int[] foxDistance;
    static int[][] wolf;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        foxDistance = new int[N];
        wolf = new int[2][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Edge(b, c * 2));
            list[b].add(new Edge(a, c * 2));
        }

        Arrays.fill(foxDistance, Integer.MAX_VALUE);
        Arrays.fill(wolf[0], Integer.MAX_VALUE);
        Arrays.fill(wolf[1], Integer.MAX_VALUE);

        fox();
        wolf();

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (foxDistance[i] < Integer.min(wolf[0][i], wolf[1][i])) count++;
        }
        System.out.println(count);
    }



    private static void wolf() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0, 0));

        wolf[0][0] = 0;

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (wolf[now.speed][now.vertex] < now.distance) continue;
            for (Edge next : list[now.vertex]) {
                int nextVertex = next.vertex;
                int distance = wolf[now.speed][now.vertex];
                int speed = 0;

                if (now.speed == 0) {   // 현재 홀수번째로 건넜다면
                    distance += next.distance / 2;    // 속도 두배
                    speed = 1;       // 다음 짝수
                } else {     // 현재 짝수번째로 건넜다면
                    distance += next.distance * 2;    // 속도 1/2배
                    speed = 0;
                }

                if (wolf[speed][nextVertex] > distance) {
                    wolf[speed][nextVertex] = distance;
                    pq.add(new Edge(nextVertex, distance, speed));
                }
            }
        }
    }
    private static void fox() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0));
        foxDistance[0] = 0;
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (foxDistance[now.vertex] < now.distance) continue;
            for (Edge next : list[now.vertex]) {
                if (foxDistance[next.vertex] > foxDistance[now.vertex] + next.distance) {
                    foxDistance[next.vertex] = foxDistance[now.vertex] + next.distance;
                    pq.add(new Edge(next.vertex, foxDistance[now.vertex] + next.distance));
                }
            }
        }
    }
}

class Edge implements Comparable<Edge> {
    int vertex;
    int distance;
    int speed;

    public Edge(int end, int weight) {
        this.vertex = end;
        this.distance = weight;
    }

    public Edge(int end, int weight, int speed) {
        this.vertex = end;
        this.distance = weight;
        this.speed = speed;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.distance, o.distance);
    }
}