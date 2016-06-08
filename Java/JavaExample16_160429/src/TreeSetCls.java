import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetCls {
	public static void main(String[] args) {
		// Set trSet = new TreeSet(); // UpCasting
		
		// @Suppress Warnings("rawtype")
		// SortedSet srtSet = new TreeSet();
		SortedSet<String> srtSet = new TreeSet<String>();
		
		// Number, Alpabet.....
		srtSet.add("TEST");
		srtSet.add("TEMP");
		srtSet.add("DUST");
		srtSet.add("CALL");
		srtSet.add("aDDR");
		srtSet.add("ZERO");
		srtSet.add("NULL");
		srtSet.add("덤프");
		srtSet.add("브레이크");
		srtSet.add("테스트");
		
		//	for(String s : srtSet){
		//	System.out.println(s);
		// }
		
		Iterator<String> it = srtSet.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
