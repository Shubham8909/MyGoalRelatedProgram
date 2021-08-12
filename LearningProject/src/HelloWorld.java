import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class HelloWorld {
    public static void main(String[] args) {
        String s="bwweake";
        Map<Character,Integer> map= new HashMap<>();
  
        char c[]= s.toCharArray();
        for(int i=0;i<c.length; i++){
        	char ch=c[i];
            if(map.containsKey(c[i])){
            	map.put(ch, map.get(ch)+1);
            }else{
                 map.put(ch,1);
            }
        }
        System.out.print(map.size());
    }
}