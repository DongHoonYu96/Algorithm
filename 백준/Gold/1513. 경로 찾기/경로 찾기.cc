#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

int n,m,c;
int a[54][54];
ll dp[54][54][54][54]; //y,x,방문해야하는오락실수, 마지막으로방문한오락실번호 : 그때, 경우의수
const int mod=1000007;

ll dfs(int y, int x, int cnt, int prev) {
   if(y <=0 || x<=0 || y>n || x>m ) {
      return 0; //배제
   }
   if(y==n && x==m) {
      if(cnt==0 && a[y][x]==0) {
         return 1;
      }
      if(cnt==1 && a[y][x] > prev) {
         return 1;
      }
      return 0; //그외는 유효하지않은 경로, 배제
   }

   ll & ret = dp[y][x][cnt][prev];
   if(ret!=-1) {
      return ret % mod;
   }

   ret=0; //리프노드 시작 리턴값
   // 현재 위치가 빈 칸인 경우
   if(a[y][x]==0) {
      // 아래쪽과 오른쪽으로 이동하는 경우의 수를 더함 (상태 변화 없음)
      ret=(dfs(y+1,x,cnt,prev) + dfs(y,x+1,cnt,prev))%mod;
   }
   // 현재 위치가 오락실이고, 이전 오락실보다 번호가 큰 경우
   else if(a[y][x]>prev){
      ret=(dfs(y+1,x,cnt-1,a[y][x]) + dfs(y,x+1,cnt-1,a[y][x]))%mod;
   }
   // 오락실이지만 이전 오락실보다 번호가 작은 경우는 유효하지 않으므로 ret = 0 유지
   
   return ret % mod;
}

int main(){
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);

   memset(dp,-1,sizeof(dp));
   cin>>n>>m>>c;
   int cnt=1;
   for(int i=0;i<c;++i) {
      int y,x;
      cin>>y>>x;
      a[y][x]=cnt;
      cnt++;
   }
   for(int i=0;i<=c;++i) {
      cout<<dfs(1,1,i,0)<<" ";
   }
}