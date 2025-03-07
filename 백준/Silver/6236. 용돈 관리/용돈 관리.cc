#include<bits/stdc++.h>
using namespace std; 

int n,m,ret;
int a[100000+4];

int go(int x) { // 인출할돈이 X 일때, 가능한지
   //인출할돈보다 써야할돈이 크면 반드시 실패
   for(int i=0;i<n;++i) {
      if(a[i] > x) {
         return 0;
      }
   }
   
   int cnt=1; //인출한 횟수
   int remain=x; // 남은돈
   for(int i=0;i<n;++i) {
      if(remain < a[i]) {
         //남은돈은 무조건 통장에 넣어야함 (통장은 무한?)
         remain=0;
         cnt++;
         remain +=x;
      }
      remain -= a[i];
   }
   return cnt <= m ;
}

int go2(int x) {
   int cnt=1, temp=x;
   for(int i=0;i<n;++i) {
      if(x-a[i]<0) {
         x=temp;
         cnt++;
      }
      x-=a[i];
   }
   return cnt<=m;
}

int main(){
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);

   cin>>n>>m;
   for(int i=0;i<n;++i) {
      cin>>a[i];
   }

   int st=*max_element(a, a+n);
   int en=100000*10000; // 주의!
   while(st<=en) {
      int mid = (st+en)/2;
      // cout<<st<<" "<<mid<<" " <<en<<" \n";
      if(go2(mid)) {
         en=mid-1;
         ret=mid;
      }
      else {
         st=mid+1;
      }
   }
   cout<<ret;
}