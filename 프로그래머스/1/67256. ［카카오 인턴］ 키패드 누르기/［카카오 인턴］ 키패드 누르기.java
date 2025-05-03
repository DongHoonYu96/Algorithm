import java.util.*;

class Solution {
    int dist(int target,int pos){
        
        if(target==2){
            if(pos==1) return 1;
            if(pos==2) return 0;
            if(pos==3) return 1;
            if(pos==4) return 2;
            if(pos==5) return 1;
            if(pos==6) return 2;
            if(pos==7) return 3;
            if(pos==8) return 2;
            if(pos==9) return 3;
            if(pos==0) return 3;
            if(pos==10) return 4;
            if(pos==11) return 4;
        }
        
        if(target==5){
            if(pos==1) return 2;
            if(pos==2) return 1;
            if(pos==3) return 2;
            if(pos==4) return 1;
            if(pos==5) return 0;
            if(pos==6) return 1;
            if(pos==7) return 2;
            if(pos==8) return 1;
            if(pos==9) return 2;
            if(pos==0) return 2;
            if(pos==10) return 3;
            if(pos==11) return 3;
        }
        
        if(target==8){
            if(pos==1) return 3;
            if(pos==2) return 2;
            if(pos==3) return 3;
            if(pos==4) return 2;
            if(pos==5) return 1;
            if(pos==6) return 2;
            if(pos==7) return 1;
            if(pos==8) return 0;
            if(pos==9) return 1;
            if(pos==0) return 1;
            if(pos==10) return 2;
            if(pos==11) return 2;
        }
        
        if(target==0){
            if(pos==1) return 4;
            if(pos==2) return 3;
            if(pos==3) return 4;
            if(pos==4) return 3;
            if(pos==5) return 2;
            if(pos==6) return 3;
            if(pos==7) return 2;
            if(pos==8) return 1;
            if(pos==9) return 2;
            if(pos==0) return 0;
            if(pos==10) return 1;
            if(pos==11) return 1;
        }
        return -1;
    }
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int lpos=10; //*
        int rpos=11; //#
        
        StringBuilder sb = new StringBuilder();
        for(int number : numbers){
            if(number==1 || number==4 || number==7){
                sb.append("L");
                lpos=number;
            }
            else if(number==3 || number==6 || number==9){
                sb.append("R");
                rpos=number;
            }
            else if(dist(number,lpos) > dist(number,rpos)){
                sb.append("R");
                rpos=number;
            }
            else if(dist(number,lpos) < dist(number,rpos)){
                sb.append("L");
                lpos=number;
            }
            else if(dist(number,lpos) == dist(number,rpos)){
                if(hand.equals("right")){
                    sb.append("R");
                    rpos=number;
                }
                else{
                    sb.append("L");
                    lpos=number;
                }
            }
        }
        
        return answer=sb.toString();
    }
}