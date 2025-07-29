import java.util.*;

class pair{
    int idx, cnt;
    pair(int idx, int cnt){
        this.idx=idx;
        this.cnt=cnt;
    }
    
    public String toString(){
        return this.idx+" "+this.cnt;
    }
}

class music{
    String name;
    int cnt;
    ArrayList<pair> v = new ArrayList<>(); 
    music(String name, int cnt, ArrayList<pair> v){
        this.name = name;
        this.cnt=cnt;
        this.v=v;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> ret = new ArrayList<>();
        
        HashMap<String,ArrayList<pair>> m1 = new HashMap<>();
        HashMap<String,Integer> m2 = new HashMap<>();
        
        int n = genres.length;
        for(int i=0;i<n;++i){
            //최초 삽입인경우 초기화, 값 삽입은 아래서 진행!
            if(!m1.containsKey(genres[i])){
                ArrayList<pair> tmp = new ArrayList<>();
                // tmp.add(new pair(plays[i],i));
                m1.put(genres[i],tmp);
                m2.put(genres[i],0);
            }
            var tmp = m1.get(genres[i]);
            tmp.add(new pair(i,plays[i]));
            m1.put(genres[i],tmp);
            m2.put(genres[i],m2.get(genres[i])+plays[i]);
        }
        // System.out.println(m1);
        // System.out.println(m2);
        
        //<장르, List를 내림차순 정렬>
        var sortedGen = m2.entrySet().stream()
            .sorted((a,b)-> Integer.compare(b.getValue(), a.getValue()));
        
        sortedGen.forEach(e -> {
            var sortedSong = m1.get(e.getKey()).stream()
                .sorted((a,b)->Integer.compare(b.cnt,a.cnt))
                .limit(2);
            sortedSong.forEach(song -> ret.add(song.idx));
        });
        
        return ret.stream().mapToInt(Integer::intValue).toArray();
    }
}