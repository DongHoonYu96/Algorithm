import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        var set = new HashSet<Integer>();
        var map = new HashMap<Integer,Integer>(); // 숫자, 등장횟수
        
        for(var num : nums){
            set.add(num);
        }
        
        for(var num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        int n = nums.length;
        int m = n/2;
        
        int cnt=0;
        var keys = map.keySet();
        
        // System.out.println(map);
        
        for(var key :keys){
            cnt++;
            if(cnt> m) break;
            map.get(key);
        }
        
        return Math.min(cnt,m);
    }
}