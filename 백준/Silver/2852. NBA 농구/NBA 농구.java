import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int A = 0;
    static int ASum = 0;
    static int BSum = 0;
    static int B = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        String prev = "";
        for (int i = 0; i < N; i++) {
             st = new StringTokenizer(br.readLine());
            int teamId = Integer.parseInt(st.nextToken());
            String time = st.nextToken();

            if (A > B) {
                ASum += getSecond(time) - getSecond(prev);
            } else if (B > A) {
                BSum += getSecond(time) - getSecond(prev);
            }
            if (teamId == 1) {
                A++;
            } else {
                B++;
            }
            prev = time;
        }
        if (A > B) {
            ASum += getSecond("48:00") - getSecond(prev);
        } else if (B > A) {
            BSum += getSecond("48:00") - getSecond(prev);
        }
        printTime(ASum);
        printTime(BSum);



    }

    private static void printTime(int sum) {
        int hour = sum / 60;
        int second = sum % 60;
        String s = ("00" + hour);
        String s1 = "00" + second;
        System.out.println(s.substring(s.length() - 2) + ":" + s1.substring(s1.length() - 2));
    }

    private static int getSecond(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
