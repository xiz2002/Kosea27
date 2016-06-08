/**
 * 
 */

/**
 * @author ToyMac
 *
 */
public class Ex2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int iTotal = 0;
//		C 언어에서는 for문 내에 변수 선언 및 초기화 불가.
//		int iIndex;
//		for문 진입전 선언 후 사용.
//		for(int i = 0;....
//		for(int i = 1; i <= 10; i++)
//		for(int i = 0; i < 11; i++)
//		for(int i = 1; i <= 10; ++i) // for문 내에서 증감연산자의 ++i 전위나 i++ 후위차이가 없다.
//		for(int i = 0; i <= 10; i=i+2) == for(int i = 0; i <= 10; i+=2) // 짝수의 합. 
//		for(int i = 10; i > 0; i--) == for(int i = 10; i >= 1; --i) // 감소
//		for(int i = 10; i >= 0; i-=2) // 짝수의 합  
		for(int i = 0; i <= 10; i++) {
			iTotal += i;
		}
		System.out.println(iTotal);
	}
}