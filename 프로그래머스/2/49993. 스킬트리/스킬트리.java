import java.util.*;

class Solution {
    public int solution(String s, String[] st) {
        
        int ans =0 ;
        for(int i = 0 ; i < st.length; i++){
            String sk = st[i].replaceAll("[^"+s +"]", "");
            if(s.indexOf(sk) == 0){
                ans++;
            }
        }
        return ans;
    }
}