#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

ll k;
int main() {
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);

   cin>>k;

   int len=1;
   int cnt=2;
   while(k>cnt) {
      k-=cnt;
      cnt *=2;
      len++;
   }

   int idx = k; //그룹내 위치
   idx--; //0-idx로

   // cout<<k<<" ";
   string ret="";
   for(int i=0;i<len;++i) {
      if(idx & (1<<i)) {
         ret = "7" + ret;
      }
      else {
         ret="4" + ret;
      }
   }
   cout<<ret;
   
}