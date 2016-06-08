import java.util.ListIterator;
import java.util.Vector;

/**
 * Vector는 Capacity가 있는 대신, 한계 공간에 도달하면 자동으로 늘린다.
 * 기본 공간 10
 * 증가되는 공간은 초기공간을 더한다. 
 * Ex) Capacity = 현재가용공간 + 초기지정공간 
 */
public class Vectors {

	public static void main(String args[]) {
		// Vector v = new Vector(); // 〜 JDK 1.4 まで
		// Vector<Object> v = new Vector<Object>(); JDK 1.5 ~ から
		// ＜ジェネリクス＞が いない 1.4と 同じだ。
		// Vector<E> v = new Vector<E>();
		// E : element(), Class / Interface
		// Ex) Node, Tag(xml), Object(instance, class)
		// C++) Vector<int> v(7);
		// C++ 에서는 원시형 허용!
		// Java) Vector<Integer> v = new Vector<Integer>();
		// Java 에서는 원시형 불허!
		// Vector<Integer> v = new Vector<Integer>(); // 가능
		// Vector<int> v = new Vector<int>(); // 불가
		// 숙지) 배열과 차이점 !(배열은 멤버 가 아니다.)
		Vector<Object> v = new Vector<Object>();
		v.add("1");
		v.add(2);
		v.addElement(3.0);
		v.add(3.f);
		v.add('5');
		v.addElement(true);

		/*
		 * for (int i = 0; i < v.size(); i++) { // System.out.println(v.get(i));
		 * // print문으로들어가면 타입형에 관계없이 String으로 출력한다.
		 * System.out.println(v.elementAt(i)); }
		 */

		/*
		 * Enhanced for
		 * (Object object : v) { System.out.println(object); }
		 */

		// 위와 동일한 알고리즘 사용

		/*
		 * Iterator Ver. for
		 * for (Iterator<Object> iterator = v.iterator();
		 * iterator.hasNext();) { System.out.println(iterator.next()); }
		 */

		/* 
		 * Iterator Ver. While
		 * Iterator<Object> iterator = v.iterator(); while(iterator.hasNext()) {
		 * System.out.println(iterator.next()); }
		 */
		
		/*
		 * Enumeration 
		 * Enumeration 은 ArrayList는 불가능. 
		 * Enumeration<Object> en = v.elements();
		 * while (en.hasMoreElements()) {	System.out.println(en.nextElement()); }
		 */
		
		/*
		 * ListIterator는 Iterator 개선판. Previous가 가능하다.
		 */
		 ListIterator<Object> listiterator = v.listIterator(); 
		 while(listiterator.hasNext()) { System.out.println(listiterator.next()); }
		 
	}
}