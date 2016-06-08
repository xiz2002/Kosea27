package InnerClass;

import InnerClass.Outter.Inner;

public class Main {

	public static void main(String[] args) {
		Outter outter = new Outter(); // Outter Class(외부 클래스)
//		Inner inner = new Inner(); // 불가
		Inner inner = outter.new Inner();
//		Inner inner = new Outter().new Inner(); // 가능
//		Inner inner = new Inner().new Outter() // 불가
		
		outter.demo();
		inner.demo();
	}

}
