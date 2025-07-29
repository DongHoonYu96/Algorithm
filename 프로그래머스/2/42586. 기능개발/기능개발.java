import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int n = progresses.length;
        
        ArrayList<Integer> v = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        for(int i=0;i<n;++i){
            int a = 100-progresses[i];
            int b = a/speeds[i];
            if(a%speeds[i] > 0 ) b++;
            v.add(b);
            q.add(b);
        }
        // System.out.println(q);
        
        while(q.size()>0){
            int cur = q.poll();
            int cnt=1;
            while(q.size()>0){
                int nxt = q.peek();
                if(cur < nxt){
                    break;
                }
                q.poll();
                cnt++;
            }
            ret.add(cnt);
        }
        
        // for(int i=0;i<v.size();++i){
        //     int cur = v.get(i);
        //     int cnt=1;
        //     while(cur >= nxt){
        //         cnt++;
        //     }
        //     ret.add(cnt);
        //     i+=cnt;
        // }
        
        return ret.stream().mapToInt(Integer::intValue).toArray();
    }
}