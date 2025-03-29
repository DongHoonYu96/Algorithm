#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

ll n,m,ret;
string str;
vector<int> v;
map<char,int> mp;
int a,b,c,d;

int check() {
   if(mp['A'] < a) return 0;
   if(mp['C'] < b) return 0;
   if(mp['G'] < c) return 0;
   if(mp['T'] < d) return 0;
   return 1;
}

int main() {
   ios_base::sync_with_stdio(0);
   cin.tie(0); cout.tie(0);

   cin>>n>>m>>str;

   cin>>a>>b>>c>>d;
   
   int s=0;
   int e=0; //안포함
   for(int i=0;i<m;++i) {
      mp[str[i]]++;
      e++;
   }

   while(e<=n) {
      if(check()) {
         ret++;
      }
      mp[str[s++]]--;
      mp[str[e++]]++;
   }
   
   cout<<ret;
   
   return 0;
}