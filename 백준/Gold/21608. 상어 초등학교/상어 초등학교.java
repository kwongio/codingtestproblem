import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static List<Integer>[] list;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Map<Integer, int[]> hashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


//        비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
//        1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
//        2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
        N = Integer.parseInt(st.nextToken());
        list = new ArrayList[N * N];
        map = new int[N][N];

        for (int i = 0; i < N * N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int k = 0; k < N * N; k++) {
            st = new StringTokenizer(br.readLine());
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());
            int s3 = Integer.parseInt(st.nextToken());
            int s4 = Integer.parseInt(st.nextToken());
            int s5 = Integer.parseInt(st.nextToken());
            hashMap.put(s1, new int[]{s2, s3, s4, s5});
            init(s1);
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int count = 0;
                for (int f : hashMap.get(map[i][j])) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                            if (map[nx][ny] == f) {
                                count++;
                            }
                        }
                    }
                }
                if (count == 1) {
                    answer+= 1;
                } else if (count == 2) {
                    answer+= 10;
                } else if (count == 3) {
                    answer+= 100;
                } else if (count == 4) {
                    answer+= 1000;
                }
            }
        }
        System.out.println(answer);

    }

    private static void init(int s1) {
        int[] friends = hashMap.get(s1);
        int f1 = friends[0];
        int f2 = friends[1];
        int f3 = friends[2];
        int f4 = friends[3];
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int emptyCount = 0;
                int friendCount = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = dx[k] + i;
                    int ny = dy[k] + j;
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        if (map[nx][ny] == f1 || map[nx][ny] == f2 || map[nx][ny] == f3 || map[nx][ny] == f4) {
                            friendCount++;
                        }

                        if (map[nx][ny] == 0) {
                            emptyCount++;
                        }
                    }
                }
                list.add(new int[]{i, j, friendCount, emptyCount});
            }
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1[2] == o2[2]) {
                if (o1[3] == o2[3]) {
                    if (o1[0] == o2[0]) {
                        return o1[1] - o2[1];
                    } else {
                        return o1[0] - o2[0];
                    }
                } else {
                    return o2[3] - o1[3];
                }
            }
            return o2[2] - o1[2];
        });

        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i)[0];
            int y = list.get(i)[1];
            if (map[x][y] == 0) {
                map[x][y] = s1;
                return;
            }
        }

    }
}