#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

int v,ret;
int vis[100000+4];
vector<pair<int,int>> adj[100000+4]; // <정점, 거리>

int main() {
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);

   cin>>v;

   for(int i=0;i<v;++i) {
      int a;
      cin>>a;
      while(1) {
         int b,c;
         cin>>b;
         if(b==-1) {
            break;
         }
         cin>>c;
         adj[a].push_back({b,c});
      }
   }

   queue<int> q;
   q.push(1);
   vis[1]=1; //후처리 -1 필요, 방문처리별도로 안해도됨
   while(q.size()) {
      int cur = q.front();
      q.pop();

      for(auto nxt : adj[cur]) {
         if(vis[nxt.first]) {
            continue;
         }
         vis[nxt.first] += vis[cur]+nxt.second;
         q.push(nxt.first);
      }
   }

   int mx = *max_element(vis,vis+v+1); // 1-idx임에주의
   int node1=0;
   for(int i=0;i<=v;++i) { // 1-idx임에주의
      if(mx==vis[i]) {
         node1=i;
         break;
      }
   }
   // cout<<mx<<"\n";
   // cout<<node1;

   memset(vis,0,sizeof(vis));
   // queue<int> q2;
   q.push(node1);
   vis[node1]=1; //후처리 -1 필요, 방문처리별도로 안해도됨
   while(q.size()) {
      int cur = q.front();
      q.pop();

      for(auto nxt : adj[cur]) {
         if(vis[nxt.first]) {
            continue;
         }
         vis[nxt.first] += vis[cur]+nxt.second;
         q.push(nxt.first);
      }
   }

   int mx2 = *max_element(vis,vis+v+1); // 1-idx임에주의
   int node2=0;
   for(int i=0;i<=v;++i) { // 1-idx임에주의
      if(mx2==vis[i]) {
         node2=i;
         break;
      }
   }
   cout<<vis[node2]-1;
   return 0;
}