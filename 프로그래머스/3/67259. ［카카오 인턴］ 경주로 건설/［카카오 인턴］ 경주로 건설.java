import java.util.Arrays;
import java.util.PriorityQueue;


class Solution {
    class A{
        int y;
        int x;
        int cost;
        int dir;
        A(int y, int x, int cost, int dir){
            this.y=y;
            this.x=x;
            this.cost=cost;
            this.dir=dir;
        }
    }
    
    // 이동 방향 정의 (우, 아래, 왼, 위)
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int[][][] dist = new int[26][26][4];
    static int answer;
    static int n;
    static PriorityQueue<A> pq = new PriorityQueue<>((a,b)->a.cost-b.cost);
    
    public int solution(int[][] board) {
        int n = board.length;
        
        //무한대로 초기화
        for(int i=0;i<26;++i){
            for(int j=0;j<26;++j){
                for (int k = 0; k < 4; k++) {
                    dist[i][j][k] = 987654321;
                }
            }
        }
        
        //초기값
        dist[0][0][0]=0;
        dist[0][0][1]=0;
        pq.offer(new A(0,0,0,0));
        pq.offer(new A(0,0,0,1));
        
        while(pq.size()>0){
            A cur = pq.poll();
            int y = cur.y;
            int x = cur.x;
            int cost = cur.cost;
            int dir = cur.dir;
            
            // System.out.println(y+ " " +x+ " " +cost+ " " +dir);
            
            for(int i=0;i<4;++i){
                int ny=y+dy[i];
                int nx=x+dx[i];
                int ndir=i;
                int ncost=cost;
                if(dir!=ndir){
                    ncost+=600; //곡선 + 직선
                }
                else{
                    ncost+=100; //직선
                }
                   
                if(ny<0 || nx<0 || ny>=n || nx>=n) continue;
                if(board[ny][nx]==1) continue;

                // //느긋한삭제
                // if(ncost!=dist[ny][nx][ndir]) continue;
                
                if(ncost < dist[ny][nx][ndir]){
                    dist[ny][nx][ndir] = ncost;
                    pq.offer(new A(ny,nx,ncost,ndir));
                }
            }
        }
        
        answer=987654321;
        for(int i=0;i<4;++i){
            answer = Math.min(answer,dist[n-1][n-1][i]);
            System.out.println(dist[n-1][n-1][i]);
        }
        
        return answer;
    }
}
