import javax.swing.plaf.IconUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int k;
    static int[] arr;
    static int[] robot;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[N * 2];
        robot = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N * 2; i++) {

            arr[i] = Integer.parseInt(st.nextToken());
        }
        int step = 0;

        while (true) {
            step++;

            int temp = arr[N * 2 - 1];
            for (int i = N * 2 - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = temp;
            for (int i = N - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }
            robot[0] = 0;
            robot[N - 1] = 0;

            for (int i = N - 1; i > 0; i--) {
                if (robot[i - 1] == 1 && arr[i] >= 1 && robot[i] == 0) {
                    robot[i] = 1;
                    robot[i - 1] = 0;
                    arr[i]--;
                }
            }
            if (arr[0] >= 1) {
                robot[0] = 1;
                arr[0]--;
            }

            int count = 0;
            for (int i = 0; i < N * 2; i++) {
                if (arr[i] == 0) {
                    count++;

                }
                if (count == k) {
                    System.out.println(step);
                    System.exit(0);
                }
            }
        }
    }
}