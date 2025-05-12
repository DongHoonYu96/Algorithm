import java.util.*;

class Solution {
    
    int timeToSec(String min, String sec){
        return Integer.parseInt(min)*60 + Integer.parseInt(sec);
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        String[] tmp1 = video_len.split(":");
        int videoLen = timeToSec(tmp1[0],tmp1[1]);
        
        String[] tmp2 = pos.split(":");
        int Pos = timeToSec(tmp2[0],tmp2[1]);
        
        String[] tmp3 = op_start.split(":");
        int opStart = timeToSec(tmp3[0],tmp3[1]);
        
        String[] tmp4 = op_end.split(":");
        int opEnd = timeToSec(tmp4[0],tmp4[1]);
        
        
        
        
        for(String command : commands){
            //오프닝 건너뛰기
            if(Pos>=opStart && Pos <= opEnd){
                Pos = opEnd;
            }
            if(command.equals("next")){
                Pos = Math.min(Pos+10,videoLen);
            }
            else{
                Pos = Math.max(Pos-10,0);
            }
        }
        //오프닝 건너뛰기
        if(Pos>=opStart && Pos <= opEnd){
            Pos = opEnd;
        }
        
        int a = Pos/60;
        int b = Pos-(a*60);
        
        String m = String.valueOf(a);
        String s = String.valueOf(b);
        while(m.length()!=2){
            m = "0"+m;
        }
        while(s.length()!=2){
            s = "0"+s;
        }
        
        answer = m+":"+s;
        
        return answer;
    }
}