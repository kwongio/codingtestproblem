import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

static int[] house;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        house = new int[N];
        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);
        int left = 0;
        int right = house[N - 1] - house[0] + 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (install(mid) < C) {
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(left - 1);
    }

    private static int install(int distance) {

        int count = 1;
        int lastInstall = house[0];

        for (int i = 1; i < house.length; i++) {
            if (house[i] - lastInstall >= distance) {
                count++;
                lastInstall = house[i];
            }
        }
        return count;
    }

}