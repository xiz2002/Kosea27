import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MapDescCls {

	public static void main(String[] args) {

		Map<String, Integer> map = new TreeMap<String, Integer>();

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

		/* 원본 */
		System.out.println("Map size : " + map.size());
		Set<Entry<String, Integer>> set = map.entrySet(); // 집합으로 대입
		Iterator<Entry<String, Integer>> it = set.iterator(); // 반복자로 대입

		while (it.hasNext()) {
			Map.Entry<?, ?> entry = (Map.Entry<?, ?>) it.next();
			// 호출용으로는 Wild문자를 써도 좋다.
			System.out.print("[ " + entry.getKey() + " : " + entry.getValue() + " ], ");
		}
		System.out.println();

		/* 방법 1 */
		/* 맵 자체를 내림차순으로 집합으로 만드는 방법 */

		NavigableMap<String, Integer> descMap = ((TreeMap<String, Integer>) map).descendingMap();
		// 내림차순 맵으로 변환
		// ((TreeMap<String, Integer>) map).descendingMap();
		// (TreeMapp으로 캐스팅 후 해당 메소드를 호출)
		// 생성을 HashMap으로 했을 경우 불가능하다.
		// treeMap.putAll(hashMap); // 직접 대입.
		set = descMap.entrySet(); // 집합으로 대입
		it = set.iterator(); // 반복자로 대입

		while (it.hasNext()) {
			Map.Entry<?, ?> entry = (Map.Entry<?, ?>) it.next();
			// 호출용으로는 Wild문자를 써도 좋다.
			System.out.print("[ " + entry.getKey() + " : " + entry.getValue() + " ], ");
		}
		System.out.println();

		/* 방법 2 */
		/* 집합을 역순으로 만드는 방법 */
		/* 근데 왜 안돼는거지? */
		// ~ 맵은 원본을 그대로 가져와 사용
//		NavigableSet<Entry<String, Integer>> nSet = ((TreeMap<String, Integer>)map).descendingKeySet();
		NavigableSet<String> nSet = ((TreeMap<String, Integer>)map).descendingKeySet();
		Iterator<String> lt = nSet.descendingIterator();
		while (lt.hasNext()) {
//			System.out.println(lt.next());
			String key = lt.next();
			System.out.print("[ " + key + " : " + map.get(key) + " ], ");
		}

	}
}
