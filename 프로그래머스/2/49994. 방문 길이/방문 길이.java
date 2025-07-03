import java.util.*;

class Pos{
    int y, x;
    Pos(int y, int x){
        this.y=y;
        this.x=x;
    }
}

class Solution {
    
    static void print(Object o){
       System.out.println(o);
    }
    
    public int solution(String dirs) {
        int answer = 0;
        int[][] arr = new int[11][11];
        // print(Arrays.deepToString(arr));
        
        Set<String> s = new HashSet<>();
        
        Pos cur = new Pos(5,5);
        for(int i=0;i<dirs.length();++i){
            var a = dirs.charAt(i);
            if(a=='U'){
                int nx = cur.x;
                int ny=cur.y-1;
                if(nx<0 || ny<0 || nx>=11 || ny>=11) continue;
                var sb = new StringBuilder();
                sb.append(ny);
                sb.append(nx);
                sb.append(cur.y);
                sb.append(cur.x);
                s.add(sb.toString());
                cur = new Pos(ny,nx);
            }
            else if(a=='D'){
                int nx = cur.x;
                int ny=cur.y+1;
                if(nx<0 || ny<0 || nx>=11 || ny>=11) continue;
                var sb = new StringBuilder();
                sb.append(cur.y);
                sb.append(cur.x);
                sb.append(ny);
                sb.append(nx);
                s.add(sb.toString());
                cur = new Pos(ny,nx);
            }
            else if(a=='L'){
                int nx = cur.x-1;
                int ny=cur.y;
                if(nx<0 || ny<0 || nx>=11 || ny>=11) continue;
                var sb = new StringBuilder();
                sb.append(ny);
                sb.append(nx);
                sb.append(cur.y);
                sb.append(cur.x);
                s.add(sb.toString());
                cur = new Pos(ny,nx);
            }
            else if(a=='R'){
                int nx = cur.x+1;
                int ny=cur.y;
                if(nx<0 || ny<0 || nx>=11 || ny>=11) continue;
                var sb = new StringBuilder();
                sb.append(cur.y);
                sb.append(cur.x);
                sb.append(ny);
                sb.append(nx);
                s.add(sb.toString());
                cur = new Pos(ny,nx);
            }

        }
        return s.size();
    }
}