import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        ArrayList<String> ret = new ArrayList<>();
        
        HashMap<String,String> m1 = new HashMap<>();
        
        for(var r : record){
            var strs = r.split(" ");
            if(strs[0].equals("Enter")){
                var uuid = strs[1];
                var nick = strs[2];
                m1.put(uuid,nick);
            }
            else if(strs[0].equals("Leave")){
                var uuid = strs[1];
            }
            else if(strs[0].equals("Change")){
                var uuid = strs[1];
                var nick = strs[2];
                m1.put(uuid,nick);
            }
        }
        // System.out.println(m1);
        
        for(var r : record){
            var strs = r.split(" ");
            if(strs[0].equals("Enter")){
                var uuid = strs[1];
                // var nick = strs[2];
                ret.add(m1.get(uuid)+"님이 들어왔습니다.");
            }
            else if(strs[0].equals("Leave")){
                var uuid = strs[1];
                ret.add(m1.get(uuid)+"님이 나갔습니다.");
            }
            else if(strs[0].equals("Change")){
                // var uuid = strs[1];
                // // var nick = strs[2];
                // ret.add(m1.get(uuid)+"님이 들어왔습니다.")
            }
        }
        
        return ret.stream().toArray(String[]::new);
    }
}