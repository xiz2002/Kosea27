
public class Subclass extends AbstractSub {

	Subclass() {}

	Subclass(String s) {}
//	오버로딩된 생성자가 있을경우는 기본 생성자를 호출할 경우에 기본 생성자가 명시적으로 선언.
	
	/* (non-Javadoc)
	 * @see AbstractSub#AbstractMethod()
	 * 추상(지시) -> 구현(오버라이드) 
	 */
	
	@Override
	void AbstractMethod() {
		System.out.println("구현부1");
	}
}
