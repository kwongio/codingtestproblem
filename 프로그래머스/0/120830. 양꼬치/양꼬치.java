class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        int service = n / 10;
        service = Math.max(k - service, 0);
        answer += service * 2000;
        answer += 12000*n;
        return answer;
    }
}