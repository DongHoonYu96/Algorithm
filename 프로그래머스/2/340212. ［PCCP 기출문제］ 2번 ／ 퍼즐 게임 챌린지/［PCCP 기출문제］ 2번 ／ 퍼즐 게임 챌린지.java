import java.util.*;

class Solution {
    
    boolean go(long x, int[] diffs, int[] times, long limit){
        int prev=0;
        for(int i=0;i<diffs.length;++i){
            if(i!=0) prev=times[i-1];
            
            if(diffs[i]<=x){
                limit -= times[i];
            }
            else{
                long gab = Math.abs(x-diffs[i]);
                limit = limit - (gab*(times[i]+prev) + times[i]);
            }
            // System.out.println(limit);
            if(limit<0) return false;
        }
        // System.out.println(limit);
        return limit>=0;
    }
    
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int mx=0;
        for(int diff : diffs){
            mx=Math.max(mx,diff);
        }
        
        long st = diffs[0]; //1번은 한번에 해결해야함?
        long en = mx;
        while(st<=en){
            long mid = (st+en)/2;
            // System.out.println(st+ " " + mid+" "+en);
            if(go(mid,diffs,times,limit)){
                answer=(int)mid;
                en=mid-1;
            }
            else{
                st=mid+1;
            }
        }
        
        // System.out.println(go(294,diffs,times,limit));
        
        return answer;
    }
}