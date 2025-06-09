class Solution {
    static int n;

    int dfs(int idx, int[] nums){
        if(idx==n-1){
            return 1;
        }
        if(idx>=n){
            return 0;
        }

        int ret=0;
        for(int i=1;i<nums[idx];++i){
            ret+=dfs(idx+i,nums);
        }
        return ret;
    }
    public boolean canJump(int[] nums) {
        n=nums.length;
        
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        q.add(0);

        while(q.size()>0){
            int cur = q.poll();
            
            // System.out.println(cur);
            if(cur==n-1){
                return true;
            }
            // if(cur>=n) continue;
            // if(vis[cur]) continue;
            // vis[cur]=true;
            for(int i=1;i<=nums[cur];++i){
                int nxt=cur+i;
                if(nxt>=n) continue;
                if(vis[nxt]) continue;
                vis[nxt]=true;
                q.add(nxt);
            }
        }

        return 0>0;
    }
}