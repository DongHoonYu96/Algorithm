#include<bits/stdc++.h>
using namespace std; 

int n,m;
int a[300000+4];

int go(int x) {
   int cnt=0; // 필요한 학생수
   for(int i=0;i<m;++i) {
      cnt += (a[i]/x);
      if(a[i]%x !=0 ) {
         cnt++;
      }
   }
   return cnt <= n;
}

int main(){
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);

   cin>>n>>m;
   for(int i=0;i<m;++i) {
      cin>>a[i];
   }

   int st=1;
   int en=pow(10,9);
   while(st<en) {
      int mid = (st+en)/2;
      // cout<<st<<" "<<en<<" \n";
      if(go(mid)) {
         en=mid;
      }
      else {
         st=mid+1;
      }
   }

   
   cout<<st;
}