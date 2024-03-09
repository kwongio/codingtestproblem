import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
    
        List<Integer> list = new ArrayList<>();
        String[] str = s.split(" ");
        for(int i = 0; i < str.length; i++){
            list.add(Integer.parseInt(str[i]));
        }
        Collections.sort(list);
        s = String.valueOf(list.get(0));
        s += " " + list.get(str.length -1);
        return s;
    }
}