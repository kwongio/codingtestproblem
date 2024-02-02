import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N = 4;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map;
        map = new int[N][N];
        List<Fish> fishList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int id = Integer.parseInt(st.nextToken());
                int direction = Integer.parseInt(st.nextToken()) - 1;
                fishList.add(new Fish(id, i, j, direction, true));
                map[i][j] = id;
            }
        }
        Collections.sort(fishList, (o1, o2) -> o1.id - o2.id);

        Fish fish = fishList.get(map[0][0] - 1);
        map[0][0] = -1;
        fish.isAlive = false;
        DFS(map, fishList, new Shark(0, 0, fish.direction, fish.id));
        System.out.println(answer);
    }

    static void DFS(int[][] map, List<Fish> fishList, Shark shark) {
        answer = Math.max(answer, shark.score);
        fishList.stream().forEach(fish -> moveFish(fish, map, fishList));

        for (int i = 1; i < N; i++) {
            int nx = dx[shark.direction] * i + shark.x;
            int ny = dy[shark.direction] * i + shark.y;
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] != 0) {
                List<Fish> copyFishList = copyFishList(fishList);
                int[][] copyMap = copyMap(map);

                copyMap[shark.x][shark.y] = 0;
                Fish f = copyFishList.get(map[nx][ny] - 1);
                Shark newShark = new Shark(f.x, f.y, f.direction, shark.score + f.id);
                f.isAlive = false;
                copyMap[f.x][f.y] = -1;

                DFS(copyMap, copyFishList, newShark);
            }
        }
    }

    private static List<Fish> copyFishList(List<Fish> fishList) {
        List<Fish> temp = new ArrayList<>();
        fishList.stream().forEach(e -> temp.add(new Fish(e.id, e.x, e.y, e.direction, e.isAlive)));
        return temp;
    }

    private static int[][] copyMap(int[][] map) {
        int[][] temp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp[i][j] = map[i][j];
            }
        }
        return temp;
    }

    private static void moveFish(Fish fish, int[][] map, List<Fish> fishList) {
        if (!fish.isAlive) return;
        for (int i = 0; i < 8; i++) {
            int d = (fish.direction + i) % 8;
            int nx = dx[d] + fish.x;
            int ny = dy[d] + fish.y;
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] > -1) {
                map[fish.x][fish.y] = 0;
                if (map[nx][ny] == 0) {
                    fish.x = nx;
                    fish.y = ny;
                } else if (map[nx][ny] > 0) {
                    Fish temp = fishList.get(map[nx][ny] - 1);
                    temp.x = fish.x;
                    temp.y = fish.y;
                    map[fish.x][fish.y] = temp.id;

                    fish.x = nx;
                    fish.y = ny;
                }
                fish.direction = d;
                map[nx][ny] = fish.id;
                return;
            }
        }
    }


    static void print(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static class Fish {
        int id;
        int x;
        int y;
        int direction;
        boolean isAlive;

        public Fish(int id, int x, int y, int direction, boolean isAlive) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.isAlive = isAlive;
        }
    }

    static class Shark {
        int x;
        int y;
        int direction;
        int score;

        public Shark(int x, int y, int direction, int score) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.score = score;
        }
    }

}
