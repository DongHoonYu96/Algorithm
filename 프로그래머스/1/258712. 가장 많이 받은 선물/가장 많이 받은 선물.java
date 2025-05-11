import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int n = friends.length;
        
        HashMap<String, Integer> m1 = new HashMap<>(); //str to index
        HashMap<Integer, String> m2 = new HashMap<>(); //index to str
        
        HashMap<String, Integer> m4 = new HashMap<>(); //선물지수
        HashMap<String, Integer> ret = new HashMap<>(); //받을선물수
        
        for(int i=0;i<n;++i){
            m1.put(friends[i],i);
            m2.put(i,friends[i]);
            m4.put(friends[i],0);
            ret.put(friends[i],0);
        }
        // System.out.println(m1);
        
        int graph[][] = new int[n][n];
        for(int i=0;i<gifts.length;++i){
            String[] tmp = gifts[i].split(" ");
            String from = tmp[0];
            String to = tmp[1];
            graph[m1.get(from)][m1.get(to)] +=1;
            
            m4.put(from,m4.get(from)+1);
            m4.put(to,m4.get(to)-1);
            
//             if(m2.containsKey(from)){
//                 m2.put(from,m2.get(from)+1);
//             }
//             else{
//                 m2.put(from,1);
//             }
            
//             if(m3.containsKey(to)){
//                 m3.put(from,m3.get(to)+1);
//             }
//             else{
//                 m3.put(from,1);
//             }
            
        }
        // for(int i=0;i<n;++i){
        //     for(int j=0;j<n;++j){
        //         System.out.print(graph[i][j]+" ");
        //     }System.out.println();
        // }
        
        // System.out.println(m4);
        
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                //주고받지않은경우
                if(graph[i][j]==0 && graph[j][i]==0){
                    if(m4.get(m2.get(i)) > m4.get(m2.get(j))){
                        ret.put(m2.get(i),ret.get(m2.get(i))+1); //i가 받을선물 + 1
                    }
                    else if(m4.get(m2.get(i)) < m4.get(m2.get(j))){
                        ret.put(m2.get(j),ret.get(m2.get(j))+1); //j가 받을선물 + 1
                    }
                }
                else {
                    if(graph[i][j] > graph[j][i]){
                        ret.put(m2.get(i),ret.get(m2.get(i))+1); //i가 받을선물 + 1
                    }
                    else if(graph[i][j] < graph[j][i]){
                        ret.put(m2.get(j),ret.get(m2.get(j))+1); //j가 받을선물 + 1
                    }
                    else{ //선물지수도 같다면
                        if(m4.get(m2.get(i)) > m4.get(m2.get(j))){
                            ret.put(m2.get(i),ret.get(m2.get(i))+1); //i가 받을선물 + 1
                        }
                        else if(m4.get(m2.get(i)) < m4.get(m2.get(j))){
                            ret.put(m2.get(j),ret.get(m2.get(j))+1); //j가 받을선물 + 1
                        }
                    }
                }
            }
        }
        
        answer=0;
        
        System.out.println(ret);
        
        for(String key : ret.keySet()){
            if(ret.get(key) > answer){
                answer=ret.get(key);
            }
        }
        
        return answer/2;
    }
}