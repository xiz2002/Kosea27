import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// 순서를 유지하지 않는 데이터의 집합, 데이터의 중복을 허용하지 않는다.
// 예) 양의 정수집합, 소수의집합 
// 클래스 : HashSet, TreeSet 
// iterator 지원.

public class hashSetCls {

	public static void main(String[] args) {
		// Set haSet = new HashSet(); // ~ JDK 1.4 호환
		Set<String> haSet = new HashSet<String>(); // UpCasting Instance
		// HashSet<String> haSet = new HashSet<String>(); // Instance
		// Set<?> haSet = new HashSet<String>(); // 가능

		haSet.add("너구리"); // ダヌキ
		haSet.add("다시마"); // こんぷ
		haSet.add("구리다"); // くっさ
		haSet.add("고구려");
		haSet.add("구리다"); // 중복 // 그러나 마지막에 들어간 값이 저장된다.
		// 동명이인 (중복된 값)은 허용하지 않는다.
		// 일반 for문으로 불가(Index 부재), iterator를통한 호출.
		System.out.println("haSet Size : " + haSet.size());

		// haSet.get(0); // get으로 호출 불가.(get은 기본적으로 인자로 Index가 들어간다.)

		// for(String s : haSet){ System.out.println(s); }

		// for (Iterator<String> it = haSet.iterator(); it.hasNext();) {
		// System.out.println(it.next()); }

		Iterator<String> it = haSet.iterator();
		while (it.hasNext()) { System.out.println(it.next()); }

	}

}
