import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] c) {
        int[] answer = new int[c.length];
        for(int i = 0 ; i < c.length; i++){
            int a = c[i][0] - 1;
            int b = c[i][1] - 1;
            int d = c[i][2] - 1;
            List<Integer> list = new ArrayList<>();            
            for(int j = a; j <= b; j++){
                list.add(arr[j]);
            }
            Collections.sort(list);
            answer[i] =list.get(d);
        }
        return answer;
    }
}