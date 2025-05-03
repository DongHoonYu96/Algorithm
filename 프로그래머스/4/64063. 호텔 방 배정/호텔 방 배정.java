import java.util.*;

class Solution {
    static HashMap<Long,Long> m = new HashMap<>();
    static ArrayList<Long> ret= new ArrayList<>();
    
    long find(long x){
        //방이 빈경우, 방번호+1을 다음방으로하고, 방번호 리턴
        if(m.get(x)==null){
            m.put(x,x+1);
            return x;
        }
        
        long nxt = find(m.get(x));
        m.put(x,nxt+1);
        return nxt;
    }
    
    public long[] solution(long k, long[] room_number) {
        long[] answer = {};
        // System.out.println(m.get(0)); //null
        
        for(long number : room_number){
            long n = find(number);
            ret.add(n);
        }
        
        answer = new long[ret.size()];
        for(int i=0;i<ret.size();++i){
            answer[i]=ret.get(i);
        }
        return answer;
    }
}