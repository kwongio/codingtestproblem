import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<int[]> points = new ArrayList<>();
        List<Integer> arrY = new ArrayList<>();
        List<Integer> arrX = new ArrayList<>();
        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        // 입력 받기
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            points.add(new int[]{a, b});
            arrX.add(a);
            arrY.add(b);
        }

        // 만날 장소 정하기
        for (int y : arrY) {
            for (int x : arrX) {
                List<Integer> dist = new ArrayList<>();

                // 만날 장소로 각각의 점들이 오는 비용 계산하기
                for (int[] point : points) {
                    int ex = point[0];
                    int ey = point[1];
                    int d = Math.abs(ex - x) + Math.abs(ey - y);
                    dist.add(d);
                }

                // 가까운 순서대로 정렬하기
                Collections.sort(dist);

                int tmp = 0;
                for (int i = 0; i < dist.size(); i++) {
                    tmp += dist.get(i);
                    if (answer[i] == -1) {
                        answer[i] = tmp;
                    } else {
                        answer[i] = Math.min(answer[i], tmp);
                    }
                }
            }
        }

        // 결과 출력
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}