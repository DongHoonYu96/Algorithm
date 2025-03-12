#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

ll ret, n,m;
ll a[10000+4];

int go(ll x) {
   ll temp=m; // 시작하자마자 m 명 태우고 시작
   // temp : 태운사람수
   for(int i=0;i<m;++i) {
      temp+=x/a[i];
   }
   return temp >=n;
}

int main(){
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);

   cin>>n>>m;
   for(int i=0;i<m;++i) {
      cin>>a[i];
   }

   if(n<=m) {
      cout<<n;
      return 0;
   }

   ll st=1;
   ll en=6000000000+4;
   en = 60000000004;
   while(st<=en) {
      ll mid = (st+en)/2;
      if(go(mid)) {
         ret=mid;
         en=mid-1;
      }
      else {
         st=mid+1;
      }
   }
   // ret : n명 이상을 태울수 있는 최소시간 , 정확히 n 명이 아님!!
   // cout<<ret;

   // ret-1 분까지 실제 몇명이 탔는지 계산
   // temp : 탄 사람수
   ll temp=m;
   for(int i=0;i<m;++i) {
      temp+=(ret-1)/a[i];
   }

   // ret 시간을 자세히 조사
   for(int i=0;i<m;++i) {
      // 주기가 맞아야 사람을 태울수 있음
      if(ret%a[i]==0) {
         temp++;
      }
      // n번째 사람을 태웠으면 놀이기구 번호 출력
      if(temp==n) {
         cout<<i+1;
         return 0;
      }
   }
}