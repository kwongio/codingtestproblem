import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] d = new int[1000001];
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        d[4] = 7;
        for (int i = 5; i <= 11; i++) {
            d[i] = d[i - 1] + d[i - 2] + d[i - 3];
            
        }
        for (int testcase = 0; testcase < T; testcase++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(d[N]);
        }


    }
}