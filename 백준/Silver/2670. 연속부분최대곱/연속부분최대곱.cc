#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

int n;
double a[10000+4];
double ret;

int main(){
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);

   cin>>n;
   for(int i=0;i<n;++i) {
      cin>>a[i];
      ret = max(ret, a[i]); // 단일 요소도 체크
   }

   for(int i=0;i<n;++i) {
      double sum=a[i];
      for(int j=i+1;j<n;++j) {
         sum *= a[j];
         ret=max(ret,sum);
      }
      
   }
   cout<<fixed<<setprecision(3);
   cout<<ret;
   
}