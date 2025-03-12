#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

int n;
double a[10000+4]; //원본
double dp[10000+4]; // 
double ret;

int main(){
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);

   cin>>n;
   for(int i=0;i<n;++i) {
      cin>>a[i];
   }

   dp[0]=a[0];
   ret=a[0];
   for(int i=1;i<n;++i) {
      double gob = dp[i-1] * a[i];
      if(gob < a[i]) {
         dp[i]=a[i];
      }
      else {
         dp[i] = gob;
      }
      ret=max(ret,dp[i]);
   }
   cout<<fixed<<setprecision(3);
   cout<<ret;
}