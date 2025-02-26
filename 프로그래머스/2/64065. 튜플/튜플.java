import java.util.*;

class Solution {
    public List<Integer> solution(String s) {
        int[] answer = {};
        s= s.substring(1, s.length() - 1);
        String[] str = s.split("\\},\\{");
        for(int  i = 0 ; i <str.length; i++){
            str[i] = str[i].replace("{", "");
            str[i] = str[i].replace("}", "");
        }
        Arrays.sort(str, (o1, o2) -> o1.length() - o2.length());
        List<Integer> list = new ArrayList<>();
        
         for(int  i = 0 ; i <str.length; i++){
            String[] a = str[i].split(",");
            for(int j = 0; j < a.length; j++){
                int v= Integer.parseInt(a[j]);
                if(!list.contains(v)){
                    list.add(v);
                }
            }
             // System.out.println(list);
        }
        
        return list;
    }
}