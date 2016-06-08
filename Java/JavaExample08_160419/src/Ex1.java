/**
 * @author ToyMac
 * 상속 및 접근지시자
 * super / this 관련 예제.
 * 생성자 
 * final
 */
//public class Ex1 extends Object {
public class Ex1 {
// final public class Ex1 {동일
// public final class Ex1 {동일 
// 모든 멤버(필드,메소드) 상속불가 : 캡슐
	
	String mstrName="TESTBOT";
	int miAge=25;
	float mflMoney=9999999999.9f;

	public Ex1() {
//	final public Ex1() { // 생성자에 final을 먹일 수 없다.
		System.out.println("Ex1 생성자");
	}
	
	public Ex1(String s) {
		System.out.println("Ex1 Overloading 된 생성자.");
	}
	
	public static void main(String[] args) {
		
	}

	public void pName() {
//	final public void pName() { // 상속된곳에서 Override가 불가능하다.
		System.out.println("name : " + mstrName);
	}
	
}
