import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = st.countTokens();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean ascending = isAscending();
        boolean descending = isDescending();
        if(ascending){
            System.out.println("ascending");
        }
        else if(descending){
            System.out.println("descending");
        }else{
            System.out.println("mixed");
        }


    }

    private static boolean isDescending() {
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAscending() {
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] >= arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}