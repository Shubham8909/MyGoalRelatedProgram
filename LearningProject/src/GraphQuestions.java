import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GraphQuestions {

	public static void main(String[] args) {
		int arr[][]= {{1,2},{1,3},{2,4},{3,4},{3,6},{6,7},{4,5}};
        creatGraph(arr);
	}

	private static void creatGraph(int[][] arr) {
		Map<Integer,List<Integer>> map= new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			int x=arr[i][0];
			int y=arr[i][1];
		    if(map.containsKey(x)) {
		    	map.get(x).add(y);
		    }else {
		    	ArrayList<Integer> list=new ArrayList<>();
		    	list.add(y);
		    	map.put(x, list);
		    }
			/*
			 * if(map.containsKey(y)) { map.get(y).add(x); }else { ArrayList<Integer>
			 * list=new ArrayList<>(); list.add(x); map.put(y, list); }
			 */
		}
		
		for(Entry<Integer, List<Integer>> entry: map.entrySet() ) {
			System.out.println(entry.getKey()+"---"+entry.getValue());
		}
	}

}
