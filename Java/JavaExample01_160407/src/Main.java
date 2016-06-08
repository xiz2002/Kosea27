/**
 * @author ToyMac
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int iVal1 = 1; // Integer 32bit = 4byte = word( Variable Declaration )
		// Ex) 변수 = 변하는 수 = 메모리에 할당된 변하는 값.
		// 변수 값(Value, literal) 대입(할당:Assignment)
		// 상수(literal, constant)
		// literal(값(Value)의 의미 상수)
		// constant(불변의 수 로서써의 상수)

		int iVal2 = 444; // 선언 + 대입 = 변수 초기화(initialization)

		System.out.println(iVal1+", "+iVal2);
		// String + 다른 모든 자료형 = String
		// int 자료형의 변수는 C Language처럼 기본값이 없다.
		// + 연산자 : 연결 (concatenation) 연산
		
		// 160408 ~
		System.out.println(Integer.MIN_VALUE+", "+Integer.MAX_VALUE);
		// 실질 객체(Active object, instance). 멤버(필드/메소드)
		// -> 일반적인 멤버 접근법
		// Abc abcd = new Abc(); 인스턴스시킴(메모리에 적재/실체화시킴)
		// abcd.Valriable, abcd.Method;
		// 멤버 성분이 static(정적)이면 인스턴스 없이 클래스(변수)로 직접 접근가능.
//		int iVal3 = 2147483648; (Out of Range);
		long loVal = 2147483648L; // 접미가 있어야 한다. (8Byte Integer)
		int iVal3 = (int)loVal; // 8Byte -> 4Byte Casting (Casting시 Small -> Large 로. 그 반대로 할 경우 값이 깨진다.)
		
		System.out.println(loVal+", "+iVal3);
		// 값의 손실(절사)
		
		long loVal2 = 20160408; // int 범위내의 값 (접미사 생략)
		int iVal4 = (int)loVal2; //형변환후에도 값이 유지 (명시적 Casting)
		System.out.println(iVal4);
		long loVal3 = iVal4; // 작은 자료형 -> 큰 자료형 : 자동 형변환 (묵시적 Casting)
		System.out.println(loVal3);
		
		// 부동(Float) 수점 연산 -> 실수
		float fVal1 = 123.4f; // 123.4f 4Byte 실수 (접미사를 통한 명시적 Casting)
//		float fVal2 = 123.4; (X)
//		123.4, 123.4d, 123.4D : double Type (8byte) 실수
//		자바는 기본적으로 실수는 Double로 처리한다.
		float fVal2 = (float)123.4; // 명시적 Casting
		float fVal3 = 123; // 정수 -> 실수 
		System.out.println(fVal3);
		float fVal4 = 123L;
		System.out.println(fVal4);
		
		// 기본(내장) 자료형 (데이터타입, data Type)
		// 프리미브 타입 (primitive Type)
		double dVal1 = 123.4; //
		
		boolean isBool = true; // default = false
		
		int iVal5 =isBool? 1 : 0;
		// 삼항(조건:ternary) operator(연산자) 피연산자(operand)
		System.out.println(iVal5);
		
		
		/* 형변환 (Casting)
		* 묵시적(자동)
		* 명시적(표기)
		* 기본자료형에서만 제공.(Char, String 제외)
		*/
		
		String strT = "일본";
		// String 은 기본자료형 이지만, 원시(primitive) 자료형은 아니다.
		// 참조형 자료(reference Type) : 클래스(class)이면서 자료형이다.
		// C에서는 Char *, Char[] 를 이용 
		// C++ string
		
		char chVal1 = 'a';
		char chVal2 = 97;
		// char chVal3 = "a".charAt(0);
		// 문자열 a 의 0번째 문자를 추출 
		char chVal3 = "a".toUpperCase().charAt(0);
		// 대문자 변경 후 0번째 문자 추출 
		
		int iVal6 = 'a' - 10;
		int iVal7 = '뷁' - 20;
		// 띄워쓰기 포함 두글자는 character 자료형에 들어갈수 없다.
		//
		String strE = Integer.toString(iVal6);
		String strM = Integer.toString(iVal7);
		System.out.println(chVal1+", "+chVal2);
		System.out.println(chVal3);
		System.out.println(iVal6+", "+iVal7);
		System.out.println(iVal6+", "+iVal7);
		System.out.println(strE+", "+strM);
		
		String strP = "한글" + 1;
		// 연결(병합) 연산 : concatenation(concat)
		String strT1 = "한한한" + 123.4F;
	
		System.out.println(strP);
		System.out.println(strT1);
		System.out.println("TEST"+100+200);
		System.out.println("TEST"+(100+200));
		
		/*
		 * 클래스(참조형) 간의 형변환(casting)
		 * 상속관계가 있을경우만 가능!
		 */
		
		Object obj = new Object();
		obj = "asdf"; // == String "asdf";
		
		// String strVal4 = obj; | 불가
		
		String strVal4 = obj.toString();
		
		System.out.println(strVal4);
		
		/*
		 * 형변환 메소드 (Casting Method)
		 * 명명(naming)의 특징
		 * to~, parse~, value~
		 */
	}

}
