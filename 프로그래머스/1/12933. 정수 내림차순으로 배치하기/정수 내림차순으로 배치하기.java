import java.util.*;

class Solution {
    public long solution(long n) {
        String[] s = String.valueOf(n).split("");
        Arrays.sort(s , (o1 ,o2) -> o2.compareTo(o1));
        StringBuilder sb = new StringBuilder();
        for(int i =0 ; i < s.length; i++){
            sb.append(s[i]);
        }
        return Long.parseLong(sb.toString());
    }
}