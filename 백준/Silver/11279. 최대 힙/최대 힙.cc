#include<bits/stdc++.h>
using namespace std; 

typedef long long ll;

int n;
priority_queue<int> pq;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    cin>>n;
    for(int i=0;i<n;++i) {
        int num;
        cin>>num;
        if(num==0) {
            if(pq.empty()) {
                cout<<0<<"\n";
                continue;
            }
            cout<<pq.top()<<"\n";
            pq.pop();
            continue;
        }

        pq.push(num);
    }
    
    return 0;
}