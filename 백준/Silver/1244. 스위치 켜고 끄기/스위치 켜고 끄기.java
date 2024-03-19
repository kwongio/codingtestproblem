import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (gender == 1) { //남자
                for (int j = 1; j <= N; j++) {
                    if (j % num == 0) {
                        arr[j] = arr[j] == 1 ? 0 : 1;
                    }
                }

            } else {
                int start = num - 1;
                int end = num + 1;
                while (start >= 1 && end <= N) {
                    if (arr[start] == arr[end]) {
                        start -= 1;
                        end += 1;
                    } else {

                        break;
                    }
                }
                for(int k = start + 1 ; k<= end - 1; k++){
                    arr[k] = arr[k] == 1 ? 0 : 1;
                }
            }

        }
        for (int t = 1; t <= N; t++) {
            System.out.print(arr[t] + " ");
            if(t % 20 == 0){
                System.out.println();
            }
        }
    }
}