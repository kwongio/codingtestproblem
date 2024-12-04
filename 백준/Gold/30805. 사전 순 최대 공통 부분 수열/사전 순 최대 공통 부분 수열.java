import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static List<Integer> DFS(List<Integer> arr1, List<Integer> arr2, List<Integer> res) {
        if (arr1.isEmpty() || arr2.isEmpty()) {
            return res;
        }

        int tmp1 = max(arr1);
        int tmp2 = max(arr2);
        int idx1 = arr1.indexOf(tmp1);
        int idx2 = arr2.indexOf(tmp2);

        if (tmp1 == tmp2) {
            res.add(tmp1);
            return DFS(arr1.subList(idx1 + 1, arr1.size()), arr2.subList(idx2 + 1, arr2.size()), res);
        }
        else if (tmp1 > tmp2) {
            arr1.remove(idx1);
            return DFS(arr1, arr2, res);
        }
        else {
            arr2.remove(idx2);
            return DFS(arr1, arr2, res);
        }
    }

    public static int max(List<Integer> list) {
        int maxVal = list.get(0);
        for (int num : list) {
            if (num > maxVal) {
                maxVal = num;
            }
        }
        return maxVal;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> arr1 = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
         st = new StringTokenizer(br.readLine());
        List<Integer> arr2 = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            arr2.add(Integer.parseInt(st.nextToken()));
        }
        List<Integer> ans = DFS(arr1, arr2, new ArrayList<>());
        System.out.println(ans.size());
        if (!ans.isEmpty()) {
            for (int num : ans) {
                System.out.print(num + " ");
            }
        }
    }
}