import java.util.*;

class Solution {
    static int[] answer = new int[2];
    
    public int[] solution(int n, String[] words) {
        
        
        var ret = new ArrayList<Integer>();

        var map = new HashMap<String,Boolean>();
        
        int idx=0;
        var prev = "";
        for(var word : words){
            if(map.containsKey(word)){
                ret.add((idx%n) + 1);
                ret.add((idx/n)+1);
                return ret.stream().mapToInt(Integer::intValue).toArray(); 
            }
            if(prev.length()!=0 && prev.charAt(prev.length()-1) != word.charAt(0)){
                ret.add((idx%n) + 1);
                ret.add((idx/n)+1);
                return ret.stream().mapToInt(Integer::intValue).toArray(); 
            }
            prev=word;
            map.put(word,true);
            idx++;
        }
        
        
        return answer;
    }
}