import java.util.*;

class Solution {
    static int[][] board;
    static ArrayDeque<Integer> stk = new ArrayDeque<>();
    static int answer;
    
    void findAndRemove(int move){
        int i=0;
        while(i<board.length && board[i][move-1]==0){
            // System.out.println(board[i][move-1]);
            i++;
        }
        
        
        if(i==board.length) i--;
        
        
        if(board[i][move-1]!=0){
            
            // System.out.println(board[i][move-1]);
            if(stk.size()>0 && stk.peek()==board[i][move-1]){
                // System.out.println(board[i][move-1]);
                stk.pop();
                answer+=2;
            }
            else stk.push(board[i][move-1]); //stack에는 offer 금지!
            
            board[i][move-1]=0; //제거표시
        }
    }
    
    public int solution(int[][] _board, int[] moves) {
        board=_board;
        // System.out.println(Arrays.deepToString(board));
        
        for(int move : moves){
            findAndRemove(move);
        }
        // System.out.println(stk);
        return answer;
    }
}