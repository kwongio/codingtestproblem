import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, Q;
    static List<int[]> logs;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        logs = new ArrayList<>();
        parent = new int[N + 1];

        // Union-Find 초기화
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        // 통나무 정보 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            logs.add(new int[]{x1, x2, i + 1});
        }

        // 통나무를 시작점 기준으로 정렬
        logs.sort(Comparator.comparingInt(o -> o[0]));

        // 통나무 연결
        int[] current = logs.get(0); // 첫 번째
        for (int i = 1; i < logs.size(); i++) {
            int[] next = logs.get(i);

            // 현재 통나무와 다음 통나무가 겹치는지 확인
            if (current[1] >= next[0]) {
                union(current[2], next[2]); // 두 통나무를 같은 그룹으로 연결
                current[1] = Math.max(current[1], next[1]); // 최대 끝점 갱신
            } else {
                current = next; // 겹치지 않으면 다음 통나무로 이동
            }
        }

        // 질문 처리
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 같은 그룹인지 확인
            if (find(a) == find(b)) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }

        // 결과 출력
        System.out.print(sb);
    }

    // Union-Find의 Find 함수
    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]); // 경로 압축
    }

    // Union-Find의 Union 함수
    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA; // 하나의 그룹으로 병합
        }
    }
}