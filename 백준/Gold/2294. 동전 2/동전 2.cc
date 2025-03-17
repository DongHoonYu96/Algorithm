#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

int n,k;
ll dp[10000+4];

int main(){
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);
   
   cin>>n>>k;
      
   fill(dp,dp+10000+4,987654321);
   dp[0]=0;
   
   for(int i=0;i<n;++i) {
      int tmp;
      cin>>tmp; //2원
      for(int j=tmp;j<=k;++j) {
         dp[j]=min(dp[j],dp[j-tmp]+1);
      }
   }
   if(dp[k]==987654321) {
      cout<<-1;
      exit(0);
   }
   cout<<dp[k];
   
}