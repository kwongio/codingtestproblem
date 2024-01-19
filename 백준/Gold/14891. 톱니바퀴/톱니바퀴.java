import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new int[4][8];
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            char[] c = st.nextToken().toCharArray();
            for (int j = 0; j < c.length; j++) {
                arr[i][j] = c[j] - '0';
            }
        }
        int rotate = Integer.parseInt(br.readLine());

        for (int i = 0; i < rotate; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());
            int[] dir = new int[4];
            dir[start] = direction;

            for (int j = start - 1; j >= 0; j--) {
                if (arr[j][2] != arr[j + 1][6]) {
                    dir[j] = dir[j + 1] * -1;
                }else{
                    break;
                }
            }
            for (int j = start + 1; j < 4; j++) {
                if (arr[j][6] != arr[j - 1][2]) {
                    dir[j] = dir[j - 1] * -1;
                }else{
                    break;
                }
            }
            for (int j = 0; j < 4; j++) {
                if (dir[j] == 1) {
                    int temp = arr[j][7];
                    for (int k = 7; k >= 1; k--) {
                        arr[j][k] = arr[j][k - 1];
                    }
                    arr[j][0] = temp;
                } else if(dir[j] == -1) {
                    int temp = arr[j][0];
                    for (int k = 0; k < 7; k++) {
                        arr[j][k] = arr[j][k + 1];
                    }
                    arr[j][7] = temp;
                }
            }
        }
        int result = 0;
        if(arr[0][0] == 1){
            result+=1;
        }
        if(arr[1][0] == 1){
            result+=2;
        }
        if(arr[2][0] == 1){
            result+=4;
        }
        if(arr[3][0] == 1){
            result+=8;
        }
        System.out.println(result);


    }
}