vector<int> adj[2004];
int vis[2004]; // 1: 방문중, 2: 방문완료

class Solution {
public:
    int dfs(int cur){
        if(vis[cur]==1) return 0; // 사이클!
        if(vis[cur]==2) return 1;
        vis[cur]=1;
        for(auto nxt : adj[cur]){
            int res = dfs(nxt);
            if(res==0) return 0;
        }
        vis[cur]=2; // 탐색완료
        return 1;
    }

    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        for(int i=0;i<2004;++i) adj[i].clear();
        memset(vis,0,sizeof(vis));

        for(auto prerequisite : prerequisites){
            int a = prerequisite[0];
            int b = prerequisite[1];
            // cout<<a<<" "<<b;
            
            adj[b].push_back(a);
        }

        for(int i=0;i<numCourses;++i){
            if(vis[i]) continue;
            if(dfs(i)==0){
                return 0;
            }
        }


        return 1;
    }
};