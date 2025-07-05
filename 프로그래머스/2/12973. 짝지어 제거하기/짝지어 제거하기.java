import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        
        ArrayDeque<Character> stk = new ArrayDeque<>();
        
        for(int i=0;i<s.length();++i){
            if(stk.size()>0 && stk.peek()==s.charAt(i)){
                stk.pop();
                continue;
            }
            stk.push(s.charAt(i));
        }


        return stk.isEmpty()? 1 : 0;
    }
}