import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        int maxy = Arrays.stream(y).max().getAsInt();
        int miny = Arrays.stream(y).min().getAsInt();
        int maxx = Arrays.stream(x).max().getAsInt();
        int minx = Arrays.stream(x).min().getAsInt();
        int i = (maxy - miny) * (maxx - minx);
        System.out.println(i);


    }

}
