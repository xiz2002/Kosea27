/**
 * @author ToyMac
 * Run As -> Run Configure -> Argument -> Variable -> ${String_Prompt} *
 */
public class Ex2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int iScore = Integer.parseInt(args[1]);
		char chResult = 'F';
		
		if(iScore>=90 && iScore <= 100){
			chResult = 'A';
		} else if(iScore>=80 && iScore <= 89) {
			chResult = 'B';
		} else if(iScore>=70 && iScore <= 79) {
			chResult = 'C';
		} else if(iScore>=60 && iScore <= 69) {
			chResult = 'D';
		}
		p(args[0],chResult);
	}
	
	public static void p(Object n, Object a) {
		
		String m = n.toString() + "의 학점은 "+ a.toString() + "입니다.";
		
		System.out.println(m);
	}
}
