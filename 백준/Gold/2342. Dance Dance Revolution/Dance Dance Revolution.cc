#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

ll node[5][5];
int cnt; // 숫자갯수
vector<int> v;
ll dp[100004][5][5];

ll dfs(ll idx, int y , int x) {
    if(idx==cnt) {
        return 0; 
    }
    if(idx!=0 && y==x) {
        return 987654321; //배제
    }

    ll & ret = dp[idx][y][x];
    if(ret!=-1) {
        return ret;
    }

    ret=987654321;
    if(y==v[idx]) {
        ret = min(ret,dfs(idx+1,y,x)+1);
    }
    else if(x==v[idx]) {
        ret = min(ret,dfs(idx+1,y,x)+1);
    }
    else {
        //좌발이동
        ret = min(ret,dfs(idx+1,v[idx],x)+node[y][v[idx]]);
        //우발이동
        ret = min(ret,dfs(idx+1,y,v[idx])+node[x][v[idx]]);
    }

    return ret;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    node[0][1]=2;
    node[0][2]=2;
    node[0][4]=2;
    node[0][3]=2;

    node[1][2]=3;
    node[2][1]=3;
    node[2][3]=3;
    node[3][2]=3;
    node[1][4]=3;
    node[4][1]=3;
    node[3][4]=3;
    node[4][3]=3;

    node[2][4]=4;
    node[4][2]=4;
    node[1][3]=4;
    node[3][1]=4;

    memset(dp,-1,sizeof(dp));
    while(1) {
        int n;
        cin>>n;
        if(n==0) break;
        cnt++;
        v.push_back(n);
    }

    cout<<dfs(0,0,0);
    
    return 0;
}