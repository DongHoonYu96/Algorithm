#include <bits/stdc++.h>

using namespace std;

int ret;

int solution(vector<int> people, int limit) {
    int s=0;
    int e = people.size()-1;
    sort(people.begin(),people.end());
    
    while(s<e){
        // cout<<s<<" "<<e<<"\n";
        if(people[s]+people[e]<=limit){
            s++;
            e--;
            ret++;
        }
        else{
            e--;
            ret++;
        }
    }
    if(s==e) ret++; //1개 남은경우
    
    return ret;
}