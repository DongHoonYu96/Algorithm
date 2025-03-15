#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

int n,m;
int a[54][54],vis[54][54];
int dp[54][54]; // ->, 세로, 대각
int ret;

int dfs(int y, int x) {
   if(y<0 || x<0 || y>=n || x>=m) {
      // ret=max(ret,cnt);
      return 0;
   }
   if(a[y][x]==-1) {
      // ret=max(ret,cnt);
      return 0;
   }
   if(vis[y][x]) {
      cout<<-1;
      exit(0);
   }
   // cout<<y<<" "<<x<<"\n";
   
   int & ret = dp[y][x];
   if(ret!=-1) {
      return ret;
   }
   ret=0;
   
   int num=a[y][x];
   vis[y][x]=1;
   ret=max(ret,dfs(y-num,x)+1);
   ret=max(ret,dfs(y+num,x)+1);
   ret=max(ret,dfs(y,x+num)+1);
   ret=max(ret,dfs(y,x-num)+1);
   vis[y][x]=0;
   return ret;
}

void dfs2(int y, int x, int cnt) {
   
   if(y<0 || x<0 || y>=n || x>=m) {
      ret=max(ret,cnt);
      
      return;
   }
   if(a[y][x]==-1) {
      ret=max(ret,cnt);
      return;
   }
   cout<<y<<" "<<x<<" "<<cnt<<"\n";
   

   int num=a[y][x];
   dfs2(y-num,x, cnt+1);
   dfs2(y+num,x, cnt+1);
   dfs2(y,x+num, cnt+1);
   dfs2(y,x-num, cnt+1);
   return;
}

int main(){
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);

   cin>>n>>m;
   for(int i=0;i<n;++i) {
      string tmp;
      cin>>tmp;
      for(int j=0;j<m;++j) {
         if(tmp[j]=='H') {
            a[i][j]=-1; //구멍
            continue;
         }
         a[i][j]=tmp[j]-'0';
      }
   }
   // for(int i=0;i<n;++i) {
   //    for(int j=0;j<m;++j) {
   //       cout<<a[i][j]<<" ";
   //    }cout<<"\n";
   // }
   memset(dp,-1,sizeof(dp));

   cout<<dfs(0,0);
   // dfs2(0,0,0);
   // cout<<ret;
   // cout<<dfs(0,0,0);
   // cout<<ret;
}