import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < commands.length; i++){
            int a = commands[i][0] - 1;
            int b = commands[i][1] - 1;
            int c = commands[i][2] - 1;
            for(int j = a; j <= b; j++){
                list.add(array[j]);
            }
            Collections.sort(list);
            answer[i] = list.get(c);
            list.clear();
        }
        return answer;
    }
}