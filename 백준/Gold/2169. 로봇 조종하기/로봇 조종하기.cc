#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

int n,m;
int a[1004][1004], dp[1004][1004][3], vis[1004][1004];
int dy[] = {1,0,0};
int dx[] = {0,1,-1};

int dfs(int y, int x, int dir) {
   if(y<0 || x<0 || y>=n || x>=m) {
      return -987654321;
   }
   if(vis[y][x]) {
      return -987654321;
   }
   if(y==n-1 && x==m-1) {
      return a[y][x];
   }

   int & ret = dp[y][x][dir];
   if(ret!=-1) {
      return ret;
   }

   vis[y][x]=1;
   ret=-987654321;
   for(int i=0;i<3;++i) {
      int ny=y+dy[i];
      int nx=x+dx[i];
      ret=max(ret,dfs(ny,nx,i));
   }
   vis[y][x]=0;
   
   if(ret != -987654321) {
      ret += a[y][x];
   }
   
   return ret;
}

int main() {
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);

   memset(dp,-1,sizeof(dp));
   
   cin>>n>>m;
   for(int i=0;i<n;++i) {
      for(int j=0;j<m;++j) {
         cin>>a[i][j];
      }
   }
   
   int result = max({dfs(0,0,0), dfs(0,0,1), dfs(0,0,2)});
   cout << result;
   
   return 0;
}