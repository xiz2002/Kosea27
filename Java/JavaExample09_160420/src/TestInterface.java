/**
 * @author ToyMac
 * 인터페이스 = 상수필드 + 추상 메소드
 * 단, JDK1.8 ~ : static 메소드 성분 허용.
 */
public interface TestInterface {
//	void testDemo(){} // 구현부가 없어야 한다. 불가
//	public static void testDemo(){}	
//  public static void main(String[] args) {}
/*	
 *  Until Java 1.7
 *  Static methods are allowed in interfaces only at source level 1.8 or above
 *  Java 1.8이상에서 static 메소드 가능!
 */
	
//	String name; // 불가 / 상수(constant)가 아닌 필드는 허용 불가.
//	final String name = "초기화"; // 가능
	String name = "초기"; // 가능 
//	초기화(initialize) 후 상수화(constant) 시킴.
//	인터페이스는 멤버 필드를 허용하되, 상수 만 가능하다.
//	final 키워드가 없어도 상수 처리.
//	묵시적인 static 상수. (프로그램 시작부터 메모리에 적재 후 실행. 프로그램이 끝날때까지 해당 공간을 차지.)
	
//	abstract void testInterface(); // 가능하다.
	
//	public void TestInferface(String s); // 가능.
	
	void TestInferfaces(); // 가능.

//	private void testInferfaces(); // 불가 / public 과 abstract 만 가능.
//  지시, 명령(order)의 범위가 자신의 클래스에서만 국한(private)될수 없다.
//	인터페이스는 public을 주로 접근 제한자로 사용.
//	주의) 접근지시자 : default 불가 / public 사용
//	인터페이스의 멤버메소드는 인터페이스의 접근 제한자를 따라간다.
	
}
