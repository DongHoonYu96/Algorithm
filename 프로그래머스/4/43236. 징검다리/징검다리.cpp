#include <bits/stdc++.h>

using namespace std;

int ret,n; 
int dist;
vector<int> rocks;
int go(int x){
    int cnt=0;
    int prev=0; //이전위치
    for(auto rock : rocks){
        //제거대상
        if(abs(prev-rock) < x){
            cnt++;
        }
        else{
            prev=rock;
        }
    }
    
    //마지막 처리
    if(abs(prev-dist) < x){
        cnt++;
    }
    
    return cnt <=n;
    
}

int solution(int _distance, vector<int> _rocks, int _n) {
    dist=_distance;
    rocks=_rocks;
    n=_n;
    
    sort(rocks.begin(),rocks.end());
    
    int st=1;
    int en=1000000000;
    while(st<=en){
        int mid = (st+en)/2;
        if(go(mid)){
            ret=mid;
            st=mid+1;
        }
        else{
            en=mid-1;
        }
    }
    return ret;
}