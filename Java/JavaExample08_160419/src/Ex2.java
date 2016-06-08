/**
 * @author ToyMac
 * Ex1 : superClass (상위)
 * Ex2 : sub Class (하위)
 * 상속(inheritance) : 기존 코드의 재사용 re-use
 */

public class Ex2 extends Ex1 {

	String mstrName="TESTBOT2";
	float money=999999999.8f;
	static final int age=20; // 정적 광역 상수
	// final Field(변수) --> 상수화(constant) : 대입(assign)불가 : 불변의 수 : (캡슐)
	
	/*
	 * 생성자는 인스턴스(객체)를 생성하고 멤버 필드를
	 * 초기화 하는 역할을 주로 담당. 
	 * 리턴값(결과값) 불가
	 * Static 불가 
	 * 생성자 명은 클래스와 동명이어야 한다. 
	 */
	public Ex2 () { // 기본 생성자(default constructor)
		// 오버로딩된 생성자가 없을 경우 기본 생성자는 기본적으로 묵시적(implicit) 선언 !
		super(); // 부모 클래스의 기본 생성자를 의미.
		System.out.println("Ex2 생성자");
	}
	
	// 생성자 오버로딩 : 다형성  
	public Ex2 (String s) {
		this(); // 기본생성자를 지칭(Ex2())
		System.out.println("JavaEx22(String str) : " + s);
	}
	
	public Ex2 (String s, String t) {
		super(s);
//		this(s); // Ex2(s) 를 지칭
//		super(); // Ex1(s) 를 지칭
//		Ex2(); 불가 --> this();
//		Ex2(s); 불가 --> this(s);
//		Ex1(); 불가 --> super();
//		Ex1(s); 불가 --> super(s);
	}
	
	
	/* Over-riding 
	 * 타다 -> 안으로 (코드 내부 : {.....})
	 * 재정의 : OverLoading, OverRiding(도서에 따라 차이)
	 * 조건
	 * 1) 클래스 - 클래스 상속 / 인터페이스 - 클래스 구현을 전제
	 * 2) 부모클래스의 메소드와 동명(이름이 같아야 한다) / 오버로딩과 공통 
	 * 3) 매개변수(인수,인자)가 상위 메소드와 동일!
	 * 4) 리턴(결과)값이 상위 메소드와 동일!
	 * 5) 접근 지시자(제한자/접근가시성(access visibility))는 축소되어서는 안됨.
	 *    유지 및 확장 가능!
	 *    Ex) 상위 (public) -> 하위 (private) 불가
	 *        상위 (default) -> 하위 (public) 가능
	 *        상위 (default) -> 하위 (default) 가능
	 * 접근 지시자(제한자) 의 접근 가시성
	 * 개방 <-------------------------------------> 폐쇄
	 * public - protected - default(package) - private
	 * 
	 * 1) public : 모든 클래스. package에서 참조 가능.
	 * 2) protected : 같은 패키지내에서는 public과 동일, 상속되었을 경우만 다른 패키지에서 참조가능.
	 * 3) default(package) : 같은 패키지내에서만 참조 가능.
	 * 4) private : 같은 클래스 내에서만 참조 가능.
	 * 
	 * super/this(상위/하위 객체)
	 * 동적 키워드이므로 Static(정적) 영역에서는 사용 불가 
	 */
	
	@Override
	// void pName(String t) { // 불가
	// String pName() { // 불가 
	// private void pName() { // 불가 
	// protected void pName() { // 가능 
	public void pName() {
		System.out.println("name: " + mstrName);
	}
	
	public static void main(String[] args) {
		Ex2 tb2 = new Ex2();
		tb2.testInHerit();

		Ex2 tb3 = new Ex2("tb3");
		tb3.pName();
		
		//tb2.age = 4;
		System.out.println("tb2.age : " + Ex2.age );
		// Static 
	}

	void testInHerit() {
		// super/this(상위/하위 객체)
		// 동적 키워드이므로 Static(정적) 영역에서는 사용 불가 
		System.out.println("SuperName : " + super.mstrName);
		System.out.println("ThisName : " + this.mstrName);
		super.pName();
		this.pName();
	}
}