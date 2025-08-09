import java.util.*;

class Solution {
    static HashMap<Integer, Integer> parent = new HashMap<>();
    
    int find(int node){
        if(parent.get(node)==node){
            return node;
        }
        
        parent.put(node,find(parent.get(node)));
        return parent.get(node);
    }
    
    void union(int x, int y){
        var rootX = find(x);
        var rootY = find(y);
        parent.put(rootY,rootX);
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        Arrays.sort(costs, (a,b)->a[2]-b[2]);
        System.out.println(Arrays.deepToString(costs));
        
        //초기 : 자기자신을 부모로 설정
        for(int i=0;i<n;++i){
            parent.put(i,i);
        }
        
        // System.out.println(find(0));
        
        int edges=0;
        
        for(var cost : costs){
            //모두 연결된경우 break
            if(edges == n-1) break;
            
            
            var a = cost[0];
            var b = cost[1];
            var c = cost[2];
            
            //사이클이 있으면 연결x
            if(find(a)==find(b)){
                continue;
            }
            
            union(a,b); //연결하기 == union!
            answer+=c;
        }
        
        return answer;
    }
}