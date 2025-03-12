#include <bits/stdc++.h>

using namespace std;

int ret=987654321;

vector<string> split(string s, int dan){
    vector<string> ret;
    for(int i=0;i<s.size();){
        ret.push_back(s.substr(0+i,dan));
        i+=dan;
    }
    return ret;
}

int solution(string s) {
    int n = s.size();
    int ret = n; // 전역변수 대신 지역변수로 사용
    
    // 단위 : 1~ 전체
    for(int dan=1;dan<=s.size();++dan){
        int answer = s.size();
        vector<string> v = split(s,dan);
        
        int i = 0;
        while(i < v.size()) {
            string tmp = v[i];
            int count = 1;
            
            // 같은 패턴이 연속되는지 확인
            while(i + count < v.size() && tmp == v[i + count]) {
                count++;
            }
            
            // 반복된 패턴이 있는 경우
            if(count > 1) {
                // (패턴 길이 × 반복횟수) - (압축된 길이: 패턴 길이 + 숫자 길이)
                answer -= (dan * count) - (dan + to_string(count).length());
            }
            
            // 다음 검사할 인덱스로 이동
            i += count;
        }
        
        ret = min(ret, answer);
    }
    return ret;
}