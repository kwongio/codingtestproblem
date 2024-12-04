import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Integer> sol(List<Integer> arr1, List<Integer> arr2, List<Integer> res) {
        // 두 배열 중 하나라도 비어 있으면 결과 반환
        if (arr1.isEmpty() || arr2.isEmpty()) {
            return res;
        }

        // arr1과 arr2에서 각각 가장 큰 값과 그 인덱스를 찾음
        int tmp1 = max(arr1);
        int tmp2 = max(arr2);
        int idx1 = arr1.indexOf(tmp1);
        int idx2 = arr2.indexOf(tmp2);

        // 두 값이 같으면 결과에 추가하고 그 이후 부분으로 재귀 호출
        if (tmp1 == tmp2) {
            res.add(tmp1);
            return sol(arr1.subList(idx1 + 1, arr1.size()), arr2.subList(idx2 + 1, arr2.size()), res);
        }
        // tmp1이 더 크면 arr1에서 제거하고 재귀 호출
        else if (tmp1 > tmp2) {
            arr1.remove(idx1);
            return sol(arr1, arr2, res);
        }
        // tmp2가 더 크면 arr2에서 제거하고 재귀 호출
        else {
            arr2.remove(idx2);
            return sol(arr1, arr2, res);
        }
    }

    // 리스트에서 최대값 찾기
    public static int max(List<Integer> list) {
        int maxVal = list.get(0);
        for (int num : list) {
            if (num > maxVal) {
                maxVal = num;
            }
        }
        return maxVal;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int n = sc.nextInt();
        List<Integer> arr1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr1.add(sc.nextInt());
        }

        int m = sc.nextInt();
        List<Integer> arr2 = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            arr2.add(sc.nextInt());
        }

        // 함수 호출
        List<Integer> ans = sol(arr1, arr2, new ArrayList<>());

        // 결과 출력
        System.out.println(ans.size());
        if (!ans.isEmpty()) {
            for (int num : ans) {
                System.out.print(num + " ");
            }
        }
    }
}