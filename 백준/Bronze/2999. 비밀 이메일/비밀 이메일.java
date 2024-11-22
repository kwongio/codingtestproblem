import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static char[][] arr;
    static int R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        N = str.length();
        //R <= C
        // R * N
        int maxR = 0;
        int maxC = 0;
        for (int i = 1; i <= N; i++) {
            int R = i;
            int C = N / i;
            if (R * C == N) {
                if (maxR < R && R <= C) {
                    maxR = R;
                    maxC = C;
                }
            }
        }

        arr = new char[maxR][maxC];

        int cnt =0 ;
        for (int i = 0; i < maxC; i++) {
            for (int j = 0; j < maxR; j++) {
                arr[j][i] = str.charAt(cnt++);
            }

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxR; i++) {
            for (int j = 0; j < maxC; j++) {
                sb.append(arr[i][j]);
            }
        }
        System.out.println(sb);
                
    }
}
