#include<bits/stdc++.h>
using namespace std; 

int n,m,ret;
int a[100000+4];

int go(int x) { // 블루레이의 크기가 x일때, 가능?

   // 예외처리
   // 블루레이보다 큰게 담길수없음(?)
   // 길이가 가장 큰 기타강의 또한 무조건 블루레이에 들어가야 하기 때문에
   for(int i = 0; i < n; i++){
      if(a[i] > x){
         return false;
      }
   }

   // a[i] <= x 임이 보장됨.

   // x : 빼고 남은크기
   int temp = x; // 블루레이의 크기 저장
   int cnt = 0;
   for(int i = 0; i < n; i++){
      if(x - a[i] < 0){ // 블루레이가 꽉 찰때마다 카운팅
         x = temp; // 남은크기 초기화
         cnt++; // 1칸사용
      }
      x -= a[i];
   }
   if(x != temp) cnt++; // 꽉 차지 않더라도 일부 강의가 기록된 경우
   
   return cnt <= m;
}

int main(){
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);

   cin>>n>>m;
   for(int i=0;i<n;++i) {
      cin>>a[i];
   }

   int st=1;
   int en=100000*10000;
   while(st<=en) {
      int mid = (st+en)/2;
      // cout<<st<<" "<<en<<" \n";
      if(go(mid)) {
         en=mid-1;
         ret=mid;
      }
      else {
         st=mid+1;
      }
   }
   cout<<st;
}