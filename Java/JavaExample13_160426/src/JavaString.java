/*
* 문자열(String) 처리 종합 예제
*/
public class JavaString {

	public static void main(String[] args) {
		String str1 = "Java 자바 "; // 마지막에 공백문자 있음에 주의할 것!
		String str2 = "Java 개발자"; // String str2 = new String("Java 개발자"); 와 동일한
									// 구문
		String str3;
		
		/*
		 * 문자열 비교(1) 주의사항) 영문일 경우는 대소문자 구분함 equals
		 */
		System.out.println("문자열 비교(1) : " + (str1.equals(str2)));
		System.out.println("문자열 비교(1) : " + ("Hello".equals("hello")));
		
		/*
		 * 문자열 비교(2) 주의사항) 영문일 경우는 대소문자 구분함 == 연산자
		 */
		System.out.println("문자열 비교(2) : " + (str1 == str2));
		System.out.println("문자열 비교(2) : " + ("Hello" == "hello"));
		
		/*
		 * 문자열 비교(영문자 대소 구분하지 않음) equalsIgnoreCase
		 */
		System.out.println("영문 문자열 대소문자 구분없이 비교 : " + "Hello".equalsIgnoreCase("hello"));
		// 참고로 == 연산자는 변수가 참조하는 "메모리 주소"로 비교하고
		// equals는 선언된 변수"값"으로 구분한다.
		
		/*
		 * 문자열을 constant pool에 등록한다. 이미 상수풀(constant pool)에 같은 내용의 문자열이 있을 경우 그
		 * 문자열의 메모리 주소값을 반환. intern()
		 */
		String s1 = new String("abcd");
		String s2 = new String("abcd");
		System.out.println(" == 연산자 : " + (s1 == s2)); // 값이 아닌 "주소값"으로 비교한다.
		System.out.println(" equals 메소드 : " + s1.equals(s2)); // "값"으로 비교한다.
		System.out.println(" intern 메소드 : " + (s1.intern() == s2.intern())); // 이
																				// 코드에서는
																				// "메모리
																				// 주소값"끼리
																				// 비교한다.

		// ※ 부가 설명 : http://blog.naver.com/hckind/20154925042

		// 문자열 병합(1)
		str3 = str1 + str2;
		System.out.println(str3);
		/*
		 * 문자열 병합(2) concat
		 */
		str3 = str1.concat(str2);
		System.out.println(str3);
		/*
		 * 문자열의 길이를 반환한다. 주의사항) 공백(" ")도 문자열의 길이에 포함됨. length
		 */
		System.out.println("문자열의 길이 : " + str3.length());
		/*
		 * 지정된 문자열로 끝나는지 여부 반환 endsWith
		 */
		System.out.println("개발자로 끝나는지 여부 : " + str3.endsWith("개발자"));
		/*
		 * 특정 위치에 있는 문자 반환 주의사항) 순서(index)는 배열처럼 0부터 시작함 charAt
		 */
		System.out.println("3번째 있는 문자 : " + str3.charAt(3));
		/*
		 * 특정 문자열 모두 교체(변경) 위에서 병합된 str3에서 공백(" ")을 ","로 변경 replaceAll
		 */
		str3 = str3.replaceAll(" ", ", ");
		System.out.println(str3);

		/*
		 * 다량의 문자열을 Token을 이용하여 빠르게 검색 가능. 인덱스번호를 사용할경 Split을 이용.
		 * StringTokenizer는 Delim을 따로 넣을수 있다.
		 *
		 * 문자열을 ","를 기준으로 각각 분리하여 배열에 할당(입력) split
		 */
		String[] arr = str3.split(",");
		for (int i = 0; i < arr.length; i++) {
			System.out.println("분리된 문자열: " + arr[i]);
		}

		/*
		 * 특정 문자열로 시작하는 지 검색 startWith
		 */
		boolean b = str3.startsWith("임");
		System.out.println(b);

		/*
		 * 특정 위치에 있는 문자열 추출(substract) 주의사항) 순서(index)는 배열처럼 0부터 시작한다. 그리고
		 * end(끝) 성분은 포함하지 않는다. substring
		 */
		System.out.println("3~9번째 까지의 문자열 : " + str3.substring(3, 10));

		/*
		 * 특정 문자/문자열 검색 찾지 못하면 -1 결과값 반환 indexOf
		 */
		System.out.println("찾을 문자열 : 개발자 : " + ((str3.lastIndexOf("개발자") == -1) ? "못찾았음" : "찾았음"));
		System.out.println("찾을 문자열 : 래 : " + ((str3.lastIndexOf("래") == -1) ? "못찾았음" : "찾았음"));

		/*
		 * 좌우 공백 제거 주의사항) 중간 공백은 없앨 수 없다. 다만 문자열 처음과 끝의 공백을 없앤다. trim
		 */
		str3 = " 자바 개발자 ";
		System.out.println("좌우 공백을 없앤 문자열 : " + str3.trim());

		/*
		 * 대소문자 상호 변환 toLowerCase / toUpperCase
		 */
		s1 = "abcde";
		s2 = "ABCDE";
		System.out.println("소문자를 대문자로 변환 : " + s1.toUpperCase());
		System.out.println("대문자를 소문자로 변환 : " + s2.toLowerCase());

	}
} // end of class
