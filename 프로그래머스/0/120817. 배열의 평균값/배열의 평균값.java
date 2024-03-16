import java.util.*;
class Solution {
    public double solution(int[] numbers) {
        double answer =0 ;
        answer = (double) Arrays.stream(numbers).sum() / numbers.length;
        return answer;
    }
}