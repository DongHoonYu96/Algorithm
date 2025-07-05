import java.util.*;

class Pair{
    int val,idx;
    Pair(int val, int idx){
        this.val=val;
        this.idx=idx;
    }
    
    public String toString(){
        return this.val+" "+this.idx;
    }
}

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        ArrayDeque<Pair> stk = new ArrayDeque<Pair>();
        for(int i=0;i<prices.length;++i){
            while (stk.size()>0 && stk.peek().val > prices[i]){ // 작은게온다면, 확정하기
                var j = stk.pop().idx;
                answer[j]=i-j;
            }
            stk.push(new Pair(prices[i],i));
        }
        
        //남아잇는애들 -> 한번도 떨어지지 않은 주식이다.
        while(stk.size()>0){
            int j = stk.pop().idx;
            answer[j] = n-1-j;
        }
        
        
        // System.out.println(stk);
        return answer;
    }
}