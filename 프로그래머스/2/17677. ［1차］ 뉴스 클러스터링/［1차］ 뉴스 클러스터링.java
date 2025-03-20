import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for(int i = 0 ; i <str1.length() - 1; i++){
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i + 1);
            if(Character.isLetter(c1) && Character.isLetter(c2)){
                String str = c1+ ""+c2;
                map1.put(str, map1.getOrDefault(str, 0) + 1);
            }
        }
        
        for(int i = 0 ; i <str2.length() - 1; i++){
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i + 1);
            if(Character.isLetter(c1) && Character.isLetter(c2)){
                String str = c1+ ""+c2;
                map2.put(str, map2.getOrDefault(str, 0) + 1);
            }
        }
        
        Set<String> keys = new HashSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());
        
        int total = 0;
        int intersection = 0;
        for(String s : keys){
            if(map1.containsKey(s) && map2.containsKey(s)){
                total+= Math.max(map1.get(s), map2.get(s));
                intersection+=Math.min(map1.get(s), map2.get(s));
            }else if(map1.containsKey(s)){
                total+=map1.get(s);
            }else if(map2.containsKey(s)){
                total+=map2.get(s);
            }
        }
        if(total == 0){
            return 65536;
        }
        
        return(int)(((double)intersection/total) * 65536);
    }
}