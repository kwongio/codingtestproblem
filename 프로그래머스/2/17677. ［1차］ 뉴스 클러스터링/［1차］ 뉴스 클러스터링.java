import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = getMultiSet(str1);
        Map<String, Integer> map2 = getMultiSet(str2);

        // 교집합 & 합집합 계산
        int intersection = 0;
        int union = 0;
        
        Set<String> allKeys = new HashSet<>();
        allKeys.addAll(map1.keySet());
        allKeys.addAll(map2.keySet());

        for (String key : allKeys) {
            int count1 = map1.getOrDefault(key, 0);
            int count2 = map2.getOrDefault(key, 0);

            intersection += Math.min(count1, count2);
            union += Math.max(count1, count2);
        }

        double jaccard = (union == 0) ? 1 : (double) intersection / union;
        return (int) (jaccard * 65536);
    }
    
    private Map<String, Integer> getMultiSet(String str) {
        Map<String, Integer> map = new HashMap<>();
        str = str.toLowerCase();

        for (int i = 0; i < str.length() - 1; i++) {
            char a = str.charAt(i);
            char b = str.charAt(i + 1);

            if (Character.isLetter(a) && Character.isLetter(b)) {
                String pair = "" + a + b;
                map.put(pair, map.getOrDefault(pair, 0) + 1);
            }
        }
        return map;
    }

}
