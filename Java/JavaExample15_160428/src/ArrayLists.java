import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
/**
 * @author ToyMac
 * ArrayList는 capacity 가 없다. (가변적)
 * 
 */
public class ArrayLists {

	public static void main(String[] args) {

		// ArrayList<Object> arrlist = new ArrayList<Object>();

		List<Object> list = new ArrayList<Object>();
		// = new Vector<Object>();

		// list = new ArrayList<Object>();

		list.add("1"); // String to Object UpCasting
		list.add(2); // Integer to Object UpCasting
		list.add('3'); // Character to Object UpCasting
		list.add(4.0); // Double to Object UpCasting
		list.add(4.f); // Float to Object UpCasting

		/*
		 * for (int i = 0; i < list.size(); i++) {
		 * System.out.println(list.get(i)); }
		 */

		/*
		 * for(Object o : list) { System.out.println(o); }
		 */

		/*
		 * for (Iterator iterator = list.iterator(); iterator.hasNext();) {
		 * System.out.println(iterator.next()); }
		 */

		/*
		 * for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
		 * // <?> : Wild문자, 객체가 구분될때 사용(명확하게)
		 * System.out.println(iterator.next());
		 * }
		 */
		
		/*
		 * for (Iterator<? extends Object> iterator = list.iterator();
		 * iterator.hasNext();) { // <? extends Object> : Object를 상속받은 객체만 대입 가능
		 * (조건) System.out.println(iterator.next()); }
		 */

		/*
		 * ArrayList 지원 안됨! Enumeration<Object> en = list.elements(); while
		 * (en.hasMoreElements()) { System.out.println(en.nextElement()); }
		 */

		
		/* // Iterator<Object> it = list.iterator();
		 * Iterator<?> it = list.iterator(); while (it.hasNext()) {
		 * System.out.println(it.next()); }
		 */
		
		ListIterator<?> it = list.listIterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
