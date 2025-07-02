import java.util.*;

class Pair{
    int i;
    double rate;
    Pair(int i, double rate){
        this.i=i;
        this.rate=rate;
    }
    
    @Override
    public String toString(){
        return this.i+" "+this.rate;
    }
}

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        HashMap<Integer,Integer> m1 = new HashMap<>(); // <스테이지, 도달수>
        HashMap<Integer,Integer> m2 = new HashMap<>(); // <스테이지, 도달 & not clear 수 >
        for(int i=1;i<=501;++i){
            m1.put(i,0);
            m2.put(i,0);
        }
        
        for(int stage: stages){
            for(int i=1;i<=stage;++i){
                m1.put(i,m1.get(i)+1);
            }
            
            m2.put(stage,m2.get(stage)+1);
        }
        
        // System.out.println(m1);
        // System.out.println(m2);
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                // 1) rate 내림차순 비교
                int cmp = Double.compare(b.rate, a.rate);
                if (cmp != 0) return cmp;
                // 2) rate 같으면 i 오름차순 비교
                return Integer.compare(a.i, b.i);
            }
        );
        
        for(int i=1;i<=N;++i){
            double rate;
            if(m1.get(i)==0){
                rate = 0.0f;
            }
            else
                rate = (double)m2.get(i)/(double)m1.get(i);
            pq.offer(new Pair(i,rate));
        }
        
        ArrayList<Integer> ret = new ArrayList<>();
        while(pq.size()>0){
            Pair p = pq.poll();
            ret.add(p.i);
            // System.out.println(p);
        }
        
        return ret.stream().mapToInt(Integer::intValue).toArray();
    }
}