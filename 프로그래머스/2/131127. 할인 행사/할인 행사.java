import java.util.*;

class Solution {
    boolean check(HashMap<String,Integer> m, String[] want, int[] number){
        for(int i=0;i<want.length;++i){
            if(!m.containsKey(want[i])){ //원하는 상품 존재x
                return false;
            }
            if(m.get(want[i]) < number[i]){ // 존재하지만, 갯수부족
                return false;
            }
        }
        return true;
    }
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        int day = 0; //sum of number
        for(var a : number){
            day+=a;
        }
        
        int n = discount.length;
        
        HashMap<String,Integer> m = new HashMap<>();
        for(int i=0;i<10;++i){
            m.put(discount[i],m.getOrDefault(discount[i],0)+1); // (키, 기본값)
        }
        if(check(m, want,number)){
            answer++;
        }
        
        int i=0;
        while(i+10<n){
            m.put(discount[i], m.getOrDefault(discount[i],0)-1);
            m.put(discount[i+10],m.getOrDefault(discount[i+10],0)+1);
            if(check(m,want,number)){
                answer++;
            }
            ++i;
        }
        
        return answer;
    }
}