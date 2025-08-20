import java.util.*;

class Solution {
    static int n,K,answer; //구 : 최대 던전수
    static boolean[] vis = new boolean[8];
    static int[][] dungeons = new int[8][8];
    
    void go(ArrayList<Integer> v){
        int cnt=0;
        int k=K;
        for(var i : v){
            var min = dungeons[i][0];
            var cost = dungeons[i][1];
            
            if(k < min || k < 0){
                answer = Math.max(answer,cnt);
                return;
            }
            
            cnt++;
            k-=cost;
        }
        answer = Math.max(answer,cnt);
    }
    
    void perm(ArrayList<Integer> v){
        if(v.size()==n){
            // System.out.println(v);
            go(v);
            
            return;
        }
        
        for(int i=0;i<n;++i){
            if(vis[i]) continue;
            vis[i]=true;
            v.add(i);
            perm(v);
            v.remove(v.size()-1);
            vis[i]=false;
        }
    }
    
    public int solution(int k, int[][] _dungeons) {
        K=k;
        dungeons=_dungeons;
        n=dungeons.length;
        
        // 순열 (8!)
        perm(new ArrayList<Integer>());
        
        return answer;
    }
}