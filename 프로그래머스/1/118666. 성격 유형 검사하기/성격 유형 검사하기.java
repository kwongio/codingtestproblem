import java.util.*;

class Solution {
    int[] score = {0,3,2,1,0,1,2,3};
    char[][] type = {{'R', 'T'}, {'C','F'}, {'J', 'M'}, {'A','N'}};
    
    HashMap<Character, Integer> map = new HashMap<>();
    public String solution(String[] survey, int[] choices) {
      
        for(char[] t : type){
            map.put(t[0], 0);
            map.put(t[1], 0);
        }
        
        for(int i = 0 ; i < survey.length; i++){
            if(choices[i] <= 3){
                map.put(survey[i].charAt(0), map.get(survey[i].charAt(0)) + score[choices[i]]); 
            }else{
                map.put(survey[i].charAt(1), map.get(survey[i].charAt(1)) + score[choices[i]]);  
            }
        }
            
        StringBuilder answer = new StringBuilder();
        for(char[] t : type){
            answer.append(map.get(t[0]) >= map.get(t[1]) ? t[0] : t[1]); 
        }
      
        return answer.toString();
    }
}