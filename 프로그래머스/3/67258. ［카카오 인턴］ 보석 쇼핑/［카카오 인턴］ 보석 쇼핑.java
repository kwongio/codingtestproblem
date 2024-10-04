import java.util.*;

class Solution {
    int min = Integer.MAX_VALUE;
    public int[] solution(String[] gems) {
        min = gems.length;
        
        Set<String> set = new HashSet<>();
        for(String gem : gems){
            set.add(gem);
        }
        int count = set.size();
        
        Map<String, Integer> map = new HashMap<>();
        
        int s = 0;
        int e = 0;
        List<int[]> list = new ArrayList<>();
        while(true){
            if(count == map.size()){
                list.add(new int[]{s + 1, e, e - s});
                map.put(gems[s], map.get(gems[s])- 1);
                if(map.get(gems[s]) == 0){
                    map.remove(gems[s]);
                }
                s++;
            }else if(e == gems.length){
                break;
            }else{
                map.put(gems[e], map.getOrDefault(gems[e], 0) + 1);
                e++;
            }
        }
        list.sort((o1, o2) -> {
            if(o1[2] == o2[2]){
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
            return o1[2] - o2[2];
        });
            
        return new int[]{list.get(0)[0], list.get(0)[1]};
    }
}