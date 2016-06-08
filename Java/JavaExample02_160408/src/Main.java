/**
 * 
 */

/**
 * @author ToyMac
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int iResult = 0;
		float flResult = 0.0F;
		double dResult = 0;
		iResult = 2*3+4;
		flResult = 10/3;
		dResult = 10/3;
		p(iResult);
		p(flResult);
		System.out.println(dResult);
		
		iResult = Math.round(3.4f);
		flResult = Math.round(3.4f);
		
		p(iResult);
		p(flResult);
		
		iResult = (int)Math.floor(3.4f); // 내림 
		flResult = (float)Math.floor(3.4f);
		
		p(iResult);
		p(flResult);
		
		iResult = (int)Math.ceil(3.4); // 올림 
		flResult = (float)Math.floor(3.4);
		
		p(iResult);
		p(flResult);
		
		iResult = (int)Math.abs(3.4f); // 절대값
		flResult = (float)Math.abs(3.4f);
		
		p(iResult);
		p(flResult);
		
		iResult = (int)(Math.random()*10); // 난수 
		flResult = (float)Math.random();
		
		p(iResult);
		p(flResult);
		
		int iV1 = 1;
		int iV2 = 1;
		int iT = 0;
		// 연산자 진행 방향 (우->좌) -> 결과가 다름.
		//iResult = ++iV1;
		//iResult = iV2++;
		
		// ++iV1++ 불가 (단항 연산만 지원)
		// +iV1++ 가능(앞의 + 는 부호(양수)로써 기능)
		iResult = ++iV1 + iV2++ + iV1++ + ++iV2; 
		p(iResult);
		p(iResult);
		
		
		
		
	}
	
	
	public static void p(String args) {
		System.out.println(args);
	}
	
	public static void p(int args) {
		System.out.println(args);
	}
	
	public static void p(float args) {
		System.out.println(args);
	}
	
	public static void p(double args) {
		System.out.println(args);
	}

}
