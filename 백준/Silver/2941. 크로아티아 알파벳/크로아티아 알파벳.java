import java.util.*;

public class Main {

    static int ret;
    static ArrayList<Integer> v = new ArrayList<>();


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        StringBuilder sb = new StringBuilder();
        sb.append(s);

        s = s.replace("c=", "!");
        s = s.replace("c-", "!");
        s = s.replace("dz=", "!");
        s = s.replace("d-", "!");
        s = s.replace("lj", "!");
        s = s.replace("nj", "!");
        s = s.replace("s=", "!");
        s = s.replace("z=", "!");

//        StringBuilder buffer = new StringBuilder(s.substring(0, 2));
//        for(int i=2;i<s.length()-1;++i){
//            if(buffer.toString() == "c="|| buffer.toString() == "c-" || (buffer.toString() == "d-")
//                    || buffer.toString() == "lj" || buffer.toString() == "nj" ||
//                    (buffer.toString() == "s=") || (buffer.toString() == "z=")) {
//                ret++;
//                buffer.delete(0,1);
//                buffer.append(s.charAt(i));
//
//            }
//        }
        System.out.println(s.length());
    }
}