class Pair{
    int idx, cnt;
    Pair(int idx, int cnt){
        this.idx=idx;
        this.cnt=cnt;
    }
}

class Solution {
    static int n;

    public int jump(int[] nums) {
        n=nums.length;
        
        Queue<Pair> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        q.add(new Pair(0,0));

        while(q.size()>0){
            Pair cur = q.poll();
            
            // System.out.println(cur);
            if(cur.idx==n-1){
                return cur.cnt;
            }

            for(int i=1;i<=nums[cur.idx];++i){
                int nxt=cur.idx+i;
                if(nxt>=n) continue;
                if(vis[nxt]) continue;
                vis[nxt]=true;
                q.add(new Pair(nxt,cur.cnt+1));
            }
        }

        return -1;
    }
}