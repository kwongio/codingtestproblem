import java.util.*;

class Solution {
    public List<Integer> solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        int N = numbers.length;
        for(int i =0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                int sum = numbers[i] + numbers[j];
                if(!list.contains(sum))
                list.add(numbers[i] + numbers[j]);
            }
        }
        Collections.sort(list);
        return list;
    }
}