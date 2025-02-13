#include<bits/stdc++.h>
using namespace std;  

vector<int> topni[4]; //topni[0] : {1,0,1,0,1,1,1,1}
vector<pair<int,int>> v; // 명령어들
vector<pair<int,int>> vv; // [{회전대상톱니 idx, 방향}, ... ]
int k;

void goleft(int cur, int dir) {
    int nxt=cur-1;
    if(nxt<0) {
        return;
    }
    if(topni[nxt][2]!=topni[cur][6]) {
        vv.push_back({nxt,dir*-1});
        goleft(nxt,dir*-1);
    }
}

void goright(int cur, int dir) {
    int nxt=cur+1;
    if(nxt>=4) {
        return;
    }
    if(topni[nxt][6]!=topni[cur][2]) {
        vv.push_back({nxt,dir*-1});
        goright(nxt,dir*-1);
    }
}

void solve(int idx, int dir) {
    vv.clear();

    vv.push_back({idx,dir}); // 나 자신은 회전
    goleft(idx, dir);
    goright(idx,dir);
    for(int i=0;i<vv.size();++i) {
        // cout<<"c: "<<vv[i].first<<" "<<vv[i].second<<"\n";
        // cout<<vv[i].first<<" th is rotating.. \n"; //i가 아니고 vv[i]에 대상이 담겨있음!!!
        if(vv[i].second == 1) { // 시계
            // rotate(topni[i].begin(), topni[i].begin()+1, topni[i].end());
            rotate(topni[vv[i].first].begin(), topni[vv[i].first].begin()+topni[i].size()-1, topni[vv[i].first].end());
        }
        else { //반시계
            rotate(topni[vv[i].first].begin(), topni[vv[i].first].begin()+1, topni[vv[i].first].end());
            // rotate(topni[i].begin(), topni[i].begin()+topni[i].size()-1, topni[i].end());
        }
    }
}

void print() {
    for(int i=0;i<4;++i) {
        for(int j=0;j<8;++j) {
            cout<<topni[i][j];
        }
        cout<<"\n";
    }
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    // 입력
    for(int i = 0; i < 4; i++) {
        string tmp;
        cin>>tmp;
        for(int j=0;j<tmp.size();++j) {
            topni[i].push_back(tmp[j]-'0');
        }
    }
    
    cin >> k; 
    for(int i = 0; i < k; i++){
        int a,b;
        cin>>a>>b;
        a--; // 0-idx로 만듬
        solve(a,b);
        // print();
    }

    int ret=0;
    for(int i=0;i<4;++i) {
        if(i==0 && topni[i][0]==1) {
            ret+=1;
        }
        if(i==1 && topni[i][0]==1) {
            ret+=2;
        }
        if(i==2 && topni[i][0]==1) {
            ret+=4;
        }
        if(i==3 && topni[i][0]==1) {
            ret+=8;
        }
    }

    // 결과 출력
    cout << ret << "\n";
    return 0;
}