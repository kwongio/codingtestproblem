import java.util.*;

class Solution {
    public  String solution(String number, int k) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (char c : number.toCharArray()) {
            while (!q.isEmpty() && q.peekLast() < c - '0' && k > 0) {
                q.pollLast();
                k--;
            }
            q.addLast(c - '0');

        }
        StringBuilder result = new StringBuilder();
        int size = q.size() - k;
        for (int i = 0; i < size; i++) {
            result.append(q.poll());
        }
        return result.toString();
    }
   
}