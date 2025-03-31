#include <bits/stdc++.h>

using namespace std;

int ret=987654321;
int N;

int fac(int n){
    if(n==1) return 1;
    return n * fac(n-1);
}

vector<int> make(int startIdx, vector<int>& weak){
    vector<int> ret;
    if(startIdx==0) return weak; //0부터시작은 그냥 자기자신임
    
    for(int i=startIdx;i<weak.size();++i){ // [1 5 6 7] 에서 [5 6 7] 넣기
        ret.push_back(weak[i]);
    }
    for(int i=0; i<startIdx;++i){ // 앞에 남은것들 , 1을 1+12해서 넣기
        ret.push_back(weak[i]+N);
    }
    return ret;
}

void testmake(){
    vector<int> vv = {1,5,6,7};
    vector<int> tmp = make(1,vv);
    for(auto i :tmp){
        cout<<i<<" ";
    }
}

int solution(int n, vector<int> weak, vector<int> dist) {

    N=n;
    // cout<<fac(8);
    sort(dist.begin(),dist.end()); // 순열위해 정렬필요
    // int n = weak.size();
    
    do{
        for(int i=0;i<weak.size();++i){ //weak를 순열돌리기 (시작위치 다르게)
            vector<int> weakArr = make(i,weak);
            int idx=0; //dist의 idx == 사람수
            // int i=0; // weak의 idx
            int cur = weakArr[0] + dist[0]; //현재사람의 커버가능한 최대거리
            int flag=1; //가능한지
            for(int j=0;j<weakArr.size();++j){ // j : weak의 idx
                if(weakArr[j] > cur){ //커버할수없는경우, 새사람필요
                    if(idx + 1 == dist.size()){ //새사람이 필요한데, 사람이없으면 실패
                        flag = 0; break;
                    }
                    cur = weakArr[j] + dist[++idx];
                }                
            }
            if(flag) ret = min(ret, idx+1); //인덱스+1 == 사람수
        }
    }while(next_permutation(dist.begin(),dist.end()));
    
    // testmake();
    if(ret==987654321) return -1;
    return ret;
}