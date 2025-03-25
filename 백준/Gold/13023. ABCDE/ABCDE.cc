#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

int n,m,ret;
int vis[2004];
vector<int> adj[2004];

int dfs(int cur, int depth) {
   
   if(depth==5) {
      cout<<1;
      exit(0);
   }

   vis[cur]=1;
   int ret = 1;
   for(auto nxt : adj[cur]) {
      if(vis[nxt]) continue;
      ret+=dfs(nxt,depth+1);
   }
   vis[cur]=0;
   return ret;
}

int main() {
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);

   cin>>n>>m;

   for(int i=0;i<m;++i) {
      int a,b;
      cin>>a>>b;
      adj[a].push_back(b);
      adj[b].push_back(a); //a와 b가 친구 -> 양방향맞음
   }

   for(int i=0;i<n;++i) {
      memset(vis,0,sizeof(vis));
      dfs(i,1);
      // if(vis[i]) continue;
      
      // if(dfs(i)>=5) {
      //    cout<<1;
      //    exit(0);
      // }
   }
   // dfs(0);
   // for(int i=0;i<n;++i) {
   //    if(!vis[i]) {
   //       cout<<0;
   //       exit(0);
   //    }
   // }

   cout<<0;
   
   return 0;
}