import java.util.*;

class Solution {
    public int[] solution(int n, int[] info) {
        int[] answer = new int[11];
        int ret=0; //가장 큰 점수차
        boolean canWin=false;
        
        for(int subset = 0; subset< (1<<10);++subset){
            int a=0,b=0,cnt=0; // 라이언점수, 어피치점수, 라이언이 쏜 화살수
            int[] tmp = new int[11]; // 라이언이 쏜 점수 배열
            for(int i=0;i<10;++i){
                if((subset & (1<<i)) > 0){
                    cnt += info[i]+1; // 어피치보다 1발만 더 쏘면 최적으로 이김
                    tmp[i] = info[i]+1;
                    a+= Math.abs(10-i);
                }
                else if(info[i]>0){ // 어치피승
                    // 1발도 안쏘는게 최적
                    b+= Math.abs(10-i);
                }
            }
            
            //n 보다 화살이 더 필요하면 실패
            if(cnt > n){
                continue;
            }
            
            // 어치피가 더 많이 점수를 딴경우 실패
            if(a <= b){
                continue;
            }
            
            // 화살을 다 써야함 ! -> 남은화살은 0점에 다쏘기
            tmp[10] = n-cnt;
            
            canWin=true;
            // System.out.println(a+" "+b);
            
            //더 큰 점수차로 이길수 있는경우
            if(ret < Math.abs(a-b)){
                ret = Math.abs(a-b);
                // System.out.println(a+" "+b);
                answer=tmp;
            }
            else if (ret == Math.abs(a-b)){ // 동점인경우는 적은점수 많이 맞춘정답 우선
                ret = Math.abs(a-b);
                // System.out.println(a+" "+b);
                for(int i=10;i>=0;--i){
                    if(tmp[i] > answer[i]){
                        answer=tmp;
                        break;
                    }
                }
            }
            
            
            
        }
        int[] fail = new int[1];
        fail[0]=-1;
        if(!canWin) return fail;
        return answer;
    }
}