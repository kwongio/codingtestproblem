import java.util.*;

class Solution {
    private int openStart;
    private int openEnd;
    private int videoLen;
    private int cur;
    public String solution(
        String video_len, // 동영상 길이 "xx:xx"
        String pos, //현재위치
        String op_start,  // 오프닝 시작시간
        //오프닝 중간이 현재위치면 오프닝이 끝나는 위치로 이동
        String op_end, // 오프닝 종료시간
        String[] commands // 명령어
    ) {
        openStart = convertToMinutes(op_start);
        openEnd = convertToMinutes(op_end);
        videoLen = convertToMinutes(video_len);
        cur = convertToMinutes(pos);
        
        for(String command : commands){
            if(isOpening()){
                cur = openEnd;
            }
            
            if(command.equals("next")){
                cur = Math.min(cur + 10, videoLen);
            }else if(command.equals("prev")){
                cur = Math.max(cur - 10, 0);
            }
        }
        
        if(isOpening()){
            cur = openEnd;
        }
        
        return convertToTime(cur);
    }
    
    public boolean isOpening(){
        return openStart <= cur && cur <= openEnd;
    }
    
    public int convertToMinutes(String time){
        String[] times = time.split(":");
        return Integer.valueOf(times[0]) * 60 + Integer.valueOf(times[1]);
    }
    
    public String convertToTime(int minutes){
        return String.format("%02d:%02d", minutes/60, minutes%60);
    }
}