import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        int[] answer = new int[2];
        String pre = words[0];
        set.add(words[0]);
        for(int i =1; i < words.length;i++){
            if(set.contains(words[i]) || words[i].length() == 1 || words[i].charAt(0) != pre.charAt(pre.length() - 1)){
                answer[0] = (i)%n + 1;
                answer[1] = i/n + 1;
                break;
            }
            set.add(words[i]);
            pre = words[i];
        }
        
        return answer;
    }
}