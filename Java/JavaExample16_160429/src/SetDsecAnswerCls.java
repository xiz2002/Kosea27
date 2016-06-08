import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

// 내림차순 정렬 정답

public class SetDsecAnswerCls {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// @SuppressWarnings("rawtypes")
		// SortedSet set = new TreeSet();
		SortedSet<String> set = new TreeSet<String>();
		set.add("TEST");
		set.add("TEMP");
		set.add("DUST");
		set.add("CALL");
		set.add("aDDR");
		set.add("ZERO");
		set.add("NULL");
		set.add("덤프");
		set.add("브레이크");
		set.add("테스트");

		// NavigableSet : 내림차순 지원클래스
		// NavagableSet 객체로 인스턴스한 후 iterator에 넣어준다.
		NavigableSet<String> nSet = ((NavigableSet<String>) set).descendingSet();

		Iterator<String> it = nSet.iterator();

		while (it.hasNext()) {
			System.out.print(it.next() + ", ");
		} //
		System.out.println();
		// TreeSet : Tree 최상위 클래스
		// set을 Tree로 캐스팅 시켜, descendingIterator()를 이용한다.
		Iterator<String> lt = ((TreeSet<String>) set).descendingIterator();
		while (lt.hasNext()) {
			System.out.print(lt.next() + ", ");
		} //

	} // main

}