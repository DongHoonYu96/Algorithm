#include <bits/stdc++.h>

using namespace std;

struct Node{
    int n;
    Node* prev;
    Node* next;
    Node(int n, Node* prev, Node* next) :
        n(n),prev(prev),next(next){}
        
};

//(삽입,)삭제가 빈번할때는 리스트!
//행갯수n , 첫인덱스 k
string solution(int n, int k, vector<string> cmd) {
    string answer(n,'X'); //n만큼 X로 채우기
    
    //노드연결
    Node* cursor = new Node(0,NULL,NULL); //첫노드
    for(int i=1;i<n;++i){
        cursor->next=new Node(i,cursor,NULL);
        cursor=cursor->next;
    }
    
    // k로 커서 이동
    //n=4, k=1 일때 : 0 , 1, 2, 3
    //3에서 1로 2회이동해야함
    //2회==n-k-1회
    for(int i=0;i<n-k-1;i++) cursor = cursor->prev;
    
    stack<Node*> del;
    for(auto op : cmd){
        if(op[0]=='U'){
            //if(k==0) continue;
            int x=stoi(op.substr(2));
            while(x--) cursor=cursor->prev;
        }
        else if(op[0]=='D'){
            //if(k==n-1) continue;
            int x=stoi(op.substr(2));
            while(x--) cursor=cursor->next;
        }
        else if(op=="C"){
            del.push(cursor); //삭제할노드 포인터 넣기
            //앞노드가 있는경우 , 그림그려보면 쉬움
            if(cursor->prev != NULL) cursor->prev->next=cursor->next; // < -연결
            if(cursor->next!=NULL) cursor->next->prev = cursor->prev; // -> 연결
            
            //마지막노드인경우 이전노드 가르키도록
            if(cursor->next==NULL) cursor = cursor->prev;
            else cursor = cursor->next; //마지막노드가아니면 다음노드를 가르킴
            
        }
        else if(op=="Z"){
            auto r = del.top(); del.pop();
            if(r->prev != NULL) r->prev->next=r; // -> 다시연결
            if(r->next != NULL) r->next->prev=r; // <- 다시연결
        }
    }
    
    //정답채우기
    answer[cursor->n]='O';
    // <-로 가면서 살아있는 idx에 O 채우기
    while(cursor->prev!=NULL){
        answer[cursor->prev->n]='O';
        cursor=cursor->prev;
    }
    // ->로 가면서 살아있는 idx에 O 채우기
    while(cursor->next!=NULL){
        answer[cursor->next->n]='O';
        cursor=cursor->next;
    }
    
    return answer;
}