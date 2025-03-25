#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

int n,k,ret;

int check(int num) {
   if(num<=1) return 0;
   if(num==2) return 1;
   if(num%2==0) return 0;
   for(int i=2;i*i<=num;i++) {
      if(num%i==0) return 0;
   }

   return 1;
   
}

void dfs(int level, int num) {
   if(level==n) {
      if(check(num))
         cout<<num<<"\n";
      return;
   }
   if(!check(num)) {
      return;
   }

   for(int i=0;i<=9;++i) {
      dfs(level+1,num*10+i);
   }
}



int main() {
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);

   cin>>n;

   // fill(sosu, sosu + 100000000, 1); // 모두 소수라고 가정!
   // sosu[0]=0; sosu[1]=0; //0, 1은 소수 아님
   // for(int i=2;i*i<=99999999;++i) {
   //    if(!sosu[i]) continue;
   //    for(int j=i*i;j<=99999999;j+=i) { //i의 배수는 소수가 아님.
   //       sosu[j]=0;
   //    }
   // }

   //첫숫자는 0이될수없음
   for(int i=1;i<=9;++i) {
      dfs(1,i);
   }
   return 0;
}