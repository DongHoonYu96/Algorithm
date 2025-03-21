#include <bits/stdc++.h>

using namespace std;
priority_queue<int, vector<int> ,greater<int>> pq;
vector<int> v;
int vis[10]; //제거대상
stack<int> s;

string solution(string number, int k) {
    string answer = "";
    
    for(int i=0;i<number.size();++i){
        int num = number[i]-'0';
        while(s.size() && s.top() < num){
            if(k==0) break;
            s.pop();
            k--;
        }
        s.push(num);
    }
    
    // 엣지케이스 : k가 남은경우
    while(k--){
        s.pop();
    }
    
    while(s.size()){
        answer += to_string(s.top());
        s.pop();
    }
    
    
    
    reverse(answer.begin(),answer.end());
    
//     for(int i=0;i<number.size();++i){
//         pq.push(number[i]-'0');
//         v.push_back(number[i]-'0');
//     }
    
//     for(int i=0;i<k;++i){
//         int num = pq.top(); pq.pop();
//         vis[num]++;
//     }
    
//     vector<int> tmp;
//     for(auto i : v){
//         if(vis[i]){
//             vis[i]--;
//             continue;
//         }
//         tmp.push_back(i);
//     }
    
//     for(auto i : tmp){
//         answer+=to_string(i);
//     }
    
    
    return answer;
}