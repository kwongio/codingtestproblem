import java.util.*;

class Solution {
    public String solution(
        String video_len, // 동영상 길이 "xx:xx"
        String pos, //현재위치
        String op_start,  // 오프닝 시작시간
        //오프닝 중간이 현재위치면 오프닝이 끝나는 위치로 이동
        String op_end, // 오프닝 종료시간
        String[] commands // 명령어
    ) {
        int openStart = convertToMinutes(op_start);
        int openEnd = convertToMinutes(op_end);
        
        for(String command : commands){
            int cur = convertToMinutes(pos);
            if(openStart <= cur && cur <= openEnd){
                pos = op_end;
            }
            
            if(command.equals("next")){
                pos = convertToTime(Math.min(convertToMinutes(pos) + 10, convertToMinutes(video_len)));
            }else if(command.equals("prev")){
                pos = convertToTime(Math.max(convertToMinutes(pos) - 10, 0));
            }
        }
        int cur = convertToMinutes(pos);
        if(openStart <= cur && cur <= openEnd){
            pos = op_end;
        }
        return pos;
    }
    
    public int convertToMinutes(String time){
        String[] times = time.split(":");
        int hour = Integer.valueOf(times[0]) * 60;
        int minute = Integer.valueOf(times[1]);
        return hour + minute;
    }
    
    public String convertToTime(int minutes){
        int hour = minutes/60;
        int minute = minutes%60;
        return String.format("%02d:%02d", hour, minute);
    }
}