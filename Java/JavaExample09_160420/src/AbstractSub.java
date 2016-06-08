/**
 * @author ToyMac 추상 클래스(Abstract class)
 * 
 * 1) 일반 클래스는 추상 메소드를 가질 수 없다.
 * 2) 추상 클래스는 반드시 추상 메소드를 가질 필요 없다.
 * 3) 추상 메소드가 한 개이상 포함된 객체는 반드시 추상 클래스 또는 인터페이스여야 한다.
 */
 //*/

public abstract class AbstractSub {

	// abstract String mstrName; // 불가
	String mstrName;
	int miAge;
	float mflMoney;

	AbstractSub() {
	//	System.out.println("AbstractSub Class Initialize");
	}

	public void setName(String name) {
		mstrName = name;
		System.out.println("Name : " + mstrName);
	}
	
//	abstract void AbstractMethod(){}; // 불가
	abstract void AbstractMethod();
//	일반 클래스에서는 불허!
//	추상클래스/인터페이스에서만 사용!
//	추상메소드는 반드시 구현부(realize, implement)가 필요! ((추상)일반 클래스의 메소드가 필요)
//	추상 -> 명령, 지시(상위 계층) : 청사진(설계도)
//	구현 -> 추상에 따라 구현(실체화,일(work))
	
//	중역/임원(회장, 사장 등) : 지시자 / 지시 자체가 일 = 인터페이스
//	중간관리자(팀장, 과장, 대리) : 지사 + 일(구현) = 추상클래스
//	사원(평사원) : 일(구현) = 일반클래스

}
