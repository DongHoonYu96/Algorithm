#include <bits/stdc++.h>

using namespace std;

priority_queue<int,vector<int>,greater<int>> pq;

int ret;

int solution(vector<int> scoville, int k) {
    
    for(auto i : scoville){
        pq.push(i);
    }
    
    while(pq.size()>=2){
        auto a = pq.top(); pq.pop();
        if(a>=k){
            break;
        }
        // if(pq.empty()) break;
        auto b= pq.top();pq.pop();
        int c = a + (b*2);
        pq.push(c);
        ret++;
    }
    if(pq.top() < k) return -1;
    return ret;
}