package softwareTest;

import java.awt.print.Printable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class MapKeyComparator implements Comparator<Integer> {
	 
	@Override
	public int compare(Integer s1, Integer s2) {
		return -s1.compareTo(s2);  //从小到大排序
	}
}

public class Triangle {
    Map<Integer, Integer> m = new TreeMap<Integer,Integer>(new MapKeyComparator());

	
	public Boolean judge(int x){
		m.put(50, 1);
		m.put(20, 1);
		m.put(5, 2);
		m.put(1, 3);
		for(Map.Entry<Integer, Integer>entry:m.entrySet()){
			int change = entry.getKey();
			int num = entry.getValue();
			for(int i=0;i<num;i++){
				if((x-change)==0){
					return true;
				}
				if(x>=change){
					x-=change;
				}
				else{
					break;
				}
				
			}
		}
		return x==0;
	}
}
