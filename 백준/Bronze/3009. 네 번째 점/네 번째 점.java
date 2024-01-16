import java.io.*;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = 0;
        int b = 0;
        int[] x = new int[3];
        int[] y = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        x[0] = Integer.parseInt(st.nextToken());
        y[0] = Integer.parseInt(st.nextToken());

         st = new StringTokenizer(br.readLine());
        x[1] = Integer.parseInt(st.nextToken());
        y[1] = Integer.parseInt(st.nextToken());
         st = new StringTokenizer(br.readLine());
        x[2] = Integer.parseInt(st.nextToken());
        y[2] = Integer.parseInt(st.nextToken());


        a = (x[0] == x[1]) ? x[2] : (x[0] == x[2] ? x[1] : x[0]);
        b = (y[0] == y[1]) ? y[2] : (y[0] == y[2] ? y[1] : y[0]);
        System.out.println(a + " " + b);




    }

}
