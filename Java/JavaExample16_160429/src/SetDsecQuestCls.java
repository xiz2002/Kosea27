import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.SortedSet;
import java.util.TreeSet;

// 내림차순 정렬을 하라.

public class SetDsecQuestCls {

	public static void main(String args[]) {
		SortedSet<String> srtSet = new TreeSet<String>();
		ArrayList<String> arrList = new ArrayList<String>();
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

		System.out.println(srtSet);

		Iterator<String> it = srtSet.iterator();
		while (it.hasNext()) {
			arrList.add(it.next());
		}
		// Previous를 할 경우 ListIterator로 넘길때, size를 보내줘야한다. (size로 시작위치/기본은 0)
		ListIterator<String> lt = arrList.listIterator(arrList.size());
//		System.out.println(lt.hasPrevious());
//		System.out.println(lt.previousIndex());
		while (lt.hasPrevious()) {
			System.out.print(lt.previous()+", ");
		}
	}
}
