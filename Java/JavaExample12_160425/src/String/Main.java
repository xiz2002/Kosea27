package String;

public class Main {

	public static void main(String[] args) {
		String str = "abcd";
		// String str1 = 'a'; // Chracter -> String 변환 불가. (원시자료형 -> 참조 자료형)
		// Wrapper
		String str1 = '1' + ""; // 문자열 + 타 자료형 변수 => 문자열 값으로 변환.
		String str2 = Character.toString('a'); // Casting Method =
												// ~to,~parse,~value
		String str3 = new String("abcd");
		String str4 = "a";
		String str5 = new String("abcd");

		boolean flag = (str == str3) ? true : false; // Value (자료 값)
		System.out.println("결과 : " + flag); // false;

		flag = (str.equals(str3)) ? true : false; // Address (자료 주소)
		System.out.println("결과 : " + flag); // true;

		flag = (str3 == str5) ? true : false; // Address (자료 값) // 객체로 비교함. 일반
												// 자료형일경우에만 값으로 비교(직접대입 : String
												// s = "abc")
		System.out.println("결과 : " + flag); // true;

		flag = (str3.equals(str5)) ? true : false; // Address (자료 주소)
		System.out.println("결과 : " + flag); // true;

//		주의)Visual C++ 의 경우는 맨 마지막
//		문자(Null 문자, \0)를 배열에 포함시켜야 된다.
//		Ex) C: char charArr2[5] = "abcd"; // 가능
//			C: char charArr2[4] = "abcd"l // 불가
//			C: Char -> 1Byte / ASCII
//			Java : Char -> 2Byte / 26 개의 언어 표현 / UTF8
		char[] chArr = { 'a', 'b', 'c', 'd' }; // 문자의 배열
//		char chArr[] = { 'a', 'b', 'c', 'd' }; // 문자의 배열
//		char chArr[4] = { 'a', 'b', 'c', 'd' }; // 문자의 배열 / 불가
		char chArr2[] = new char[4];
		chArr2[0] = 65; // 0141 97 0x61
		chArr2[1] = 66;
		chArr2[2] = 67;
		chArr2[3] = 68;

		for (int i = 0; i < chArr.length; i++) {
			System.out.println(chArr[i] + "," + chArr2[i]);

		}
		
		String str6 = new String(chArr2);
		System.out.println(str6);

	}

}
