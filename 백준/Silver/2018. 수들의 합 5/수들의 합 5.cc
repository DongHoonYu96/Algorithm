#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

ll n,ret;

int main() {
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);

   cin>>n;
   // v.push_back(0); // 1-idx로 만들기
   // for(int i=1;i<=n;++i) {
   //    v.push_back(i);
   // }

   if(n==1) {
      cout<<1;
      return 0;
   }
   
   // for(int i=1;i<=n;++i) {
   //    v.push_back(i);
   // }

   // s,e가 값의 역할도 하도록 개선!
   ll s=1; 
   ll e=2; //안포
   ret=1; //자기자신 기본값
   ll sum=1;
   while(1) {
      if(e==n+1) break;
      if(sum == n) {
         ret++;
         sum+=e;
         e++;
      }
      else if(sum>n) {
         sum-=s;
         s++;
      }
      else {
         sum+=e;
         e++;
      }
   }
   cout<<ret;
   
   return 0;
}