import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapCls {
	public static void main(String[] args) {
		// Map amp = new HashMap(); ~ JDK 1.4
		// Map<String, Integer> map = new HashMap<String, Object>(); // 불가
		// Map<String, Object> map = new HashMap<String, Integer>(); // 불가
		// Map<String, ?> map = new HashMap<String, Integer>(); // 가능
		// Map<?, ?> map = new HashMap<String, Integer>(); // 가능
		// Map<? extends Object, ? extends Object> map = new HashMap<String,
		// Integer>(); // 제네릭범위제한 / 가능

		// Map<String, Integer> map = new HashMap<String, Integer>();
		// 값의 중복은 마지막 입력이 밀어낸다. / 키 중복은 무시
		// 정렬은 안된다.
		
		Map<String, Integer> map = new TreeMap<String, Integer>(); //
		// 값의 정렬은 TreeMap으로 봐꾸면 가능하다.
		// 정렬은 키가 아닌 값으로 정렬된다.
		
		map.put("김", 1);
		map.put("한", 2);
		map.put("송", 3);
		map.put("나", 4);
		map.put("라", 5);
		map.put("하", 6);
		map.put("박", 9);
		map.put("이", 8);
		map.put("이", 8);
		map.put("박", 10);

		System.out.println("Map size : " + map.size());

		// System.out.println(map.entrySet());

		Set<Entry<String, Integer>> set = map.entrySet(); // 집합으로 변환

		Iterator<Entry<String, Integer>> it = set.iterator(); // 반환자로 변환

		while (it.hasNext()) {
			// Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>)
			// it.next(); //
			Map.Entry<?, ?> entry = (Map.Entry<?, ?>) it.next(); // 호출용으로는
																	// Wild문자를
																	// 써도 좋다.
			// System.out.println(entry.getKey() + " : " + entry.getValue());
			System.out.println(entry.getKey() + " : " + map.get(entry.getKey()));
		}

	}

}
