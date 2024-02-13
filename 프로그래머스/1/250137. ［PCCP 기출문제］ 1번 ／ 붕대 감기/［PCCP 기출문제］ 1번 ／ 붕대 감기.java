class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int ht = bandage[0]; // 시전시간
        int sh = bandage[1]; // 초당 회복량
        int ph = bandage[2]; // 추가 회복량
        int max = health; // 최대체력
        int ct = 0; // 연속 시간
        
        int i = 0;
        int attckInx = 0;
       while(true){
            int time = attacks[attckInx][0]; // 공격시간
            int damage = attacks[attckInx][1]; // 피해량

            
            if(i == time){
                attckInx++;
          
                health -= damage;
                if(health <= 0){
                    return -1;
                }
                 ct = 0;
                if(attckInx == attacks.length){
                    break;
                }
                i++;
                continue;
            }
            

            int tmp = health + sh;
            if(tmp >= max){
                health = max;
            }else{
                health = tmp;
            }
           ct++;
            if(ht == ct){
                int temp = health + ph;
                if(temp >= max){
                    health = max;
                }else{
                    health = temp;
                }
                ct =0;
            }
           i++;
        }
        return health;
    }
}