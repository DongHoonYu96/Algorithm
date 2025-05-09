import java.util.*;

class Node {
    int val;
    boolean removed;
    Node prev,next;
    
    Node(int val, boolean removed, Node prev, Node next){
        this.val=val;
        this.removed=removed;
        this.prev=prev;
        this.next=next;
    }
    
    void setPrev(Node prev){
        this.prev=prev;
    }
    
    void setNext(Node next){
        this.next=next;
    }
}

class Solution {
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        
        Node [] arr = new Node[n];
        
        Node first = new Node(0,false,null,null);
        Node prev=first;
        arr[0]=first;
        
        for(int i=1;i<n;++i){
            Node node = new Node(i,false,null,null);
            arr[i]=node;
            prev.setNext(node);
            node.setPrev(prev);
            prev=node;
        }
        
        Node cursor=first;
        while(k-- > 0){
            cursor = cursor.next;
        }
        System.out.println(cursor.val);
        // while(cursor.next!=null){
        //     System.out.println(cursor.val);
        //     cursor = cursor.next;
        // }
        // System.out.println(cursor.val);
        
        Stack<Node> stk = new Stack<>();
        
        for(String op : cmd){
            if(op.charAt(0)=='U'){
                int x = Integer.parseInt(op.substring(2)); //주의 : x는 30만 이하임. 한자리 아님!, 2~끝까지
                while(x-- >0){
                    cursor = cursor.prev;
                }
            }
            else if(op.charAt(0)=='D'){
                int x = Integer.parseInt(op.substring(2));
                while(x-- >0){
                    cursor = cursor.next;
                }
            }
            else if(op.charAt(0)=='C'){
                cursor.removed=true;
                stk.push(cursor);
                if(cursor.next==null){ //막행인경우
                    cursor = cursor.prev;
                    cursor.next=null;
                }
                else if(cursor.prev==null){ //첫행인경우
                    cursor = cursor.next;
                    cursor.prev=null;
                }
                else{
                    cursor.prev.next = cursor.next;
                    cursor.next.prev = cursor.prev;
                    cursor = cursor.next;
                }
            }
            else if(op.charAt(0)=='Z'){
                Node node = stk.pop();
                node.removed=false;
                
                if(node.next==null){ //막행인경우
                    node.prev.next=node;
                }
                else if(node.prev==null){ //첫행인경우
                    node.next.prev=node;
                }
                else{
                    node.prev.next=node;
                    node.next.prev=node;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;++i){
            if(arr[i].removed==true){
                sb.append("X");
            }
            else{
                sb.append("O");
            }
        }
        
        return sb.toString();
    }
}