#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

ll ret, s,c;
ll a[1000000+4];

int go(ll x) {
   ll cnt=0;
   ll res=0;
   for(int i=0;i<s;++i) {
      cnt+=a[i]/x;
      res+=a[i]%x;
   }
   return cnt>=c;
}

int main(){
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);

   cin>>s>>c;
   ll sum=0;
   for(int i=0;i<s;++i) {
      cin>>a[i];
      sum+=a[i];
   }

   ll st=0;
   ll en=INT_MAX;
   while(st<=en) {
      ll mid = (st+en)/2;
      if(go(mid)) {
         ret=mid;
         st=mid+1;
      }
      else {
         en=mid-1;
      }
   }

   // cout<<ret<<"\n"; // 최적의 파닭갯수
   // ll res=0;
   // ll cnt=0; //만든 파닭의 갯수
   // for(int i=0;i<s;++i) {
   //    cnt+=a[i]/ret;
   //    res+=a[i]%ret;
   //    
   // }
   // if(cnt>ret) {
   //    ll gab = cnt-ret;
   //    res+=gab*ret;
   // }
   // // res += sum-ret*c; // 사용하지 않는 부분 더해줘야함
   // cout<<res;
   cout<<sum-ret*c;
}