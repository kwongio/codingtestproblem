import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, Integer> map = new HashMap<>();
        map.put("-", -1);
        for(int i = 0; i < enroll.length; i++){
            map.put(enroll[i], i);
            
        }
        
        for(int i =0 ; i < seller.length; i++){
            String sname = seller[i];
            int idx = map.get(sname);
            int refer = amount[i]*100/10;  //10퍼센트 레퍼럴
            answer[idx] += (amount[i] * 100 - refer);
            
            while(referral[idx] != "-"){ // 그다음 레퍼럴
                int referIdx = map.get(referral[idx]); // 레퍼럴
                if(referIdx == -1){
                    break;
                }
                answer[referIdx] += refer; // 레퍼럴에게 주는 돈
                  if(refer <= 9){
                    break;
                }
                refer = refer/10;
          
                // 단, 10% 를 계산할 때에는 원 단위에서 절사하며, 10%를 계산한 금액이 1 원 미만인 경우에는 이득을 분배하지 않고 자신이 모두 가집니다
                answer[referIdx] -= refer;
                idx = referIdx;
                
            }
        }
        
        return answer;
    }
}