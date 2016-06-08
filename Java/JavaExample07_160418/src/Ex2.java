/**
 * @author ToyMac
 *
 */
public class Ex2 {
//	member field(variable/constant:변수/상수)

	String mstrName;
	int miAge;
	float mflMoney;

	public static void main(String[] args) {
//		객체(instance, object) 생성(construction)
//		Ex2 : 형식 객체(청사진, 붕어빵틀)
//		exTest : 실질 객체(붕어빵) / 인스턴스화.
//		new : 동적 변수 생성 키워드 / 메모리에 인스턴스 명령어.
//		참고)C++ -->  new : 연산자로 간주.
//		Method() : 생성자(constructor)
//		타입 변수명 = new 생성자(인자)
		Ex2 exTest = new Ex2();
		
//		인스턴스 없이 Class 직접 접근시 Static 필드가 아니면 불가.
//		Ex2.mstrName="TEST"; (x)
		
		exTest.mstrName="TEST";
//		인스턴스 객체.메소드
//		~.~ 
		
		System.out.println("exTest.mstrName : " + exTest.mstrName);
//		exTest.p("TEST2"); // Static method 일 경우 인스턴스로 접근하는건 권장하지 않는다.
		Ex2.p("TEST2"); //클래스 변수 
		p("TEST3");
//		위 두 경우는 static 일 경우 가능
//		static way(정적 호출 방식)
	}
	
//	member method(function) : member method(function)
	public static void p(String s) {
		System.out.println("str : " + s);
	}
	
	public void pName(String s) {
		Ex2 Ex = new Ex2(); // 해당 메소드에서 인스턴스 후 셋터에 접근가능 
		Ex.setName(s); // (O)
		
		setName(s); // (O)
		this.setName(s); // (O)
//		JavaEx20.setName(s); // (X) // Static method가 아니다. 
		System.out.println(mstrName); 
	}
	
//	다형성(poly-morphism)
//	Method Overloading (Over-Load-ing)
//	같은 명의 메소드이지만 매개변수의 종류 및 갯수가 다르다.
//	참고) load(유입, 입력, 들어오다) --> 매개변수

/*	
 *  C언어는 다형성이 불가능하다.
 *	printStrInt(String s, int i)
 */	
	public void p(String s, int i){
		System.out.println("str + int : " + s + i);
	}
	
	
	
//	Setter(Set Field Method)
	public void setName(String s) {
		this.mstrName = s; //<-- 멤버변수에 인자 대입.
//		this : 자기자신을 의미.
//		C++ : this->name = name;
//		super : 상위 객체를 지칭. /  C++에서는 해당 키워드가 없음.
//		super/this : 동적 키워드 
//		--> static 영역에서는 사용 불가
//		인자(인수)와 멤버 필드명이 다를 경우 둘다 멤버필드? this.name = name 
	}
	
//	Getter(Get Field Method)
	public String getName(){
		return mstrName; // 멤버변수 리턴.
	}

}
