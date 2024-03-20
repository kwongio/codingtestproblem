import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> list = new ArrayList<>();
        if(cacheSize == 0){
            return cities.length*5;
        }
        for(String str : cities){
            str= str.toUpperCase();
            if(list.contains(str)){
                for(int i = 0; i <cacheSize; i++){
                    if(list.get(i).equals(str)){
                        list.remove(str);
                        list.add(str);
                        break;
                    }
                }
                answer+=1;
            }else{
                answer+=5;
                if(list.size() < cacheSize){
                    list.add(str);
                }else{
                    list.remove(0);
                    list.add(str);
                }   
            }


        }
        return answer;
    }
}