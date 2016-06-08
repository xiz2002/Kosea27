import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {
//		AbstractSub sub = new AbstractSub(); // 불가
//		추상 클래스는(추상클래스의)생성자를 이용하여 객체를 생성할 수 없다.
//		인터페이스는 생성자자체가 없다. ==> 객체 생성 불가.
//		추상클래스 인스턴스명 = new 상속하는 일반 클래스의 생성자();
		
		AbstractSub sub = new Subclass(); // UpCasting
		Subclass2 sub2 = new Subclass2(); // Instance;
		AbstractSub asc = sub2; // UpCasting
		TestInterface tis = (TestInterface) asc; // DownCasting (추상화클래스에서 인터페이스로 변경)
//		추상클래스 + (상속하는 클래스의)생성자 --> 객체 생성
//		지시한 객체 + 구현객체
		sub.AbstractMethod();
		sub2.TestInferfaces();
		asc.AbstractMethod();
		tis.TestInferfaces();
		
/*-----------------------------*/
		ArrayList<String> list = new ArrayList<String>(); //(1)// Instance
		List<String> list2 = new ArrayList<String>();	// (2)// UpCasting / Java.util
//		(2)의 경우가 많이 사용됨.
//		Thread 를 사용하여 스레드의 안전성(Thread-Safe)을 점검하는 작업으로 변환될 경우
//		(3)과 같이 변할수 있다.(융통, 이식)
		list2 = new Vector<String>(); // (3)
		list2 = new LinkedList<String>(); // (4)
	}
}
