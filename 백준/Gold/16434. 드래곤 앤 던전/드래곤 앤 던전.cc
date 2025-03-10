#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

struct A {
   ll t,a,h;
};

ll n,atk;
ll ret;
vector<A> v;

//최대피가 x일때, 되는지
bool go(ll x, ll atk) {
   ll tmp=x; //초기 최대피
   for(int i=0;i<n;++i) {
      if(v[i].t==1) {
         ll cnt=-1;
         cnt+=v[i].h/atk;
         if(v[i].h%atk) cnt++;
         // x -= cnt*v[i].a; //몹 공격력 * 공격횟수만큼 피깍기
         // 용사가 n번 공격해야 몬스터를 잡을 수 있다면, 용사가 공격을 받는 횟수는 n-1번이면 충분합니다.
         // 용사가 먼저 공격하고, 그 순간 몬스터가 죽었다면 용사는 공격받지 않기 때문입니다.
         if(x - cnt*v[i].a <=0 ) {
            // cout<<x<<"\n";
            // cout<<cnt*v[i].a<<"\n";
            return false;
         }
         x -= cnt*v[i].a; // 실제 체력 감소
      }
      else if(v[i].t==2) {
         atk+=v[i].a;
         x+=v[i].h;
         if(x>tmp) x=tmp; //최대 hp 초과 불가능
      }
   }
   return true;
}

int main(){
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);


   cin>>n>>atk;
   for(int i=0;i<n;++i) {
      ll t,a,h;
      cin>>t>>a>>h;
      v.push_back({t,a,h});
   }

   ll st=1;
   ll en = LLONG_MAX;
   while(st<=en) {
      ll mid = (st+en)/2;
      
      if(go(mid, atk)) {
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