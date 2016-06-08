package InnerClass;

//public static class Outter() { // 불가 
public class Outter {

	public Outter() {
		System.out.println("Outter Constructor");
	}
	
	public void demo() {
		System.out.println("Outter Demo Method");
	}
	
	/*
	 * Inner, 중첩 Class
	 * 내부 클래스는 Static 가능 ! 멤버 클래스
	 * public static class Inner
	 * 생성되는 class는 $를 가지게된다. (Outter$Inner)
	 */
	public class Inner {

		public String name;

		public Inner() {
			System.out.println("Inner Constructor");
		}

		public void demo() {
			System.out.println("Inner Demo Method");
		}
	}
}
