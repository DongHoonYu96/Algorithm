#include <bits/stdc++.h>

using namespace std;

// 올바른 괄호문자열인가?
// 균형은 앞의 for문에서 보장됨
int check(string str){
    stack<char> stk;
    
    for(int i=0;i<str.size();++i) {
        if(str[i]=='('){
            stk.push('(');
        }
        else if (stk.size() && str[i]==')'){
            stk.pop();
        }
    }
    
    if(stk.size()) return 0;
    return 1;
}

string go(string w){
    if(w=="") return "";
    
    int cnt1=0; int cnt2=0;
    int i=0;
    for(;i<w.size();++i){
        if(w[i]=='(') cnt1++;
        else cnt2++;
        if(cnt1==cnt2){
            break;
        }
    }
    //u는 분리불가 && 균형잡힌 문자열 보장
    string u = w.substr(0,i+1);
    string v = w.substr(i+1,w.size());
    
    // cout<<u<<"\n"<<v;
    if(check(u)){
        return u + go(v);
    }
    else{
        string s = "(" + go(v) + ")";
        u = u.substr(1,u.size()-2);
        // reverse(u.begin(),u.end());
        
        string res="";
        for(int i=0;i<u.size();++i){
            if(u[i]=='(') res+=")";
            else res+="(";
        }
        
        s = s + res;
        return s;
    }
    
    
    return "";
}

string solution(string p) {

    return go(p);
}