import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[] arr = new char[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().charAt(0);
        }

        int s = 0;
        int e = N - 1;
        StringBuilder result = new StringBuilder();

        while (s <= e) {
            // 두 문자열을 비교하여 사전순으로 앞서는 쪽을 선택
            boolean left = false;
            int leftPtr = s, rightPtr = e;

            while (leftPtr < rightPtr) {
                if (arr[leftPtr] < arr[rightPtr]) {
                    left = true;
                    break;
                } else if (arr[leftPtr] > arr[rightPtr]) {
                    left = false;
                    break;
                }
                leftPtr++;
                rightPtr--;
            }

            if (left) {
                result.append(arr[s++]);
            } else {
                result.append(arr[e--]);
            }
        }

        // 80글자 단위 개행 처리
        for (int i = 0; i < result.length(); i++) {
            if (i > 0 && i % 80 == 0) {
                System.out.println();
            }
            System.out.print(result.charAt(i));
        }
        System.out.println();
    }
}
