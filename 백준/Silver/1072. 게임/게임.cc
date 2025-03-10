#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

ll n,m,ret=-1;
ll z_origin;

//x번 게임더했을때, z 가 변하는지
bool go(ll x) {
   ll z = (100*(m+x))/ (n+x);
   return z!=z_origin;
}

int main(){
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);
   
   cin>>n>>m;
   z_origin = (100*m)/n;

   if(n==m) {
      cout<<-1;
      return 0;
   }

   ll st=0;
   ll en = INT_MAX;
   while(st<=en) {
      ll mid = (st+en)/2;
      
      if(go(mid)) {
         // cout<<"됨 "<<st<<" "<<mid<<" "<<en<<"\n";
         ret=mid;
         en=mid-1;
      }
      else {
         // cout<<"안됨 "<<st<<" "<<mid<<" "<<en<<"\n";
         st=mid+1;
      }
   }

   cout<<ret;
   
}