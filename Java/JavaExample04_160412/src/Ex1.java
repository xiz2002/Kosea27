/**
 * @author ToyMac
 * Run As -> Run Configure -> Argument -> Variable -> ${String_Prompt} 
 */
public class Ex1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int iVal1 = 12;
//		int iVal1 = -12;
//		int iVal1 = args[0]; // (X)
//		int iVal1 = Integer.parseInt(args[0]); // (O)

//		1.5 이후부터 지원
//		int iVal1 = new Integer(args[0]);

//		String -> Integer -> int
//		오보로딩된 생성자가 형변환 메소드 역할 !
//		Class(클래스) -> Origin(원시형) : 자동 형변환 (Auto-unBoxing)
//		box = class
//		Origin(원시형) -> Class(클래스) : 자동 형변환 (Auto-Boxing)

//		모든 JDK에서 호환됨.
//		int iVal1 = Integer.parseInt(args[0]); // (O)
		int iVal1 = Integer.valueOf(args[0]); // (O)
	
		String strMsg = "";
		if(iVal1 > 0) {
			strMsg = "양";
		} else if (iVal1 < 0) {
			strMsg = "음";
		} else {
			strMsg = "0 이다.";
		}
		
		p(strMsg);
		
	}
	
	public static void p(Object i) {
		String m = i.toString(); 
		System.out.println("Message : " + i);
	}
}
