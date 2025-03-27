#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

ll a,b,ret;
int sosu[10000000+1];
vector<ll> v;

int check(int x) {
   if( x <=1 ) return 0; //1은 소수가 아님
   if ( x<=2) return 1;
   if( x%2) return 0; // 짝수는 소수가 아님

   // 2, 3, 4 ...
   // 하나씩보면서
   // 나누어떨어지는게 있으면, 소수가 아님.
   for(int i=2;i*i<=b;i++) {
      if(x%i == 0 ) return 0;
   }
   return 1;
}

void make() {
   fill(sosu,sosu+10000000+1,1); //모두 소수라고 가정
   sosu[1]=0;// 1은 소수아님
   for(ll i=2;i*i<=b;++i) {
      if(!sosu[i]) continue;
      for(ll j=2*i;j*j<=b;j+=i) { //소수 i의 배수들은 소수가아님, 시작 : 2*i부터!!
         sosu[j]=0;
      }
   }

   for(ll i=2;i*i<=b;++i) {
      if(sosu[i]) {
         v.push_back(i);
      }
   }
   
}

int main() {
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);

   cin>>a>>b;
   make();
   for(auto i : v) {
      int cnt=0;
      ll tmp = i; // 777777(소수)
      while((double)i <= (double)b / (double)tmp) {
         if( (double)i >= (double)a/(double)tmp) {
            cnt++;
         }
         tmp = tmp * i;
      }
      ret+=cnt;
   }

   cout<<ret;
   
   return 0;
}