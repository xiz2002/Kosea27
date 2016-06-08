package Impl;

public class Main {

	public static void main(String[] args) throws ArithmeticException, Exception { // 함수단위 처리 

		int iNum = 2016;
		// double dResult = iNum / 0;
		boolean flag = true;

		try { // 시도.
			while (flag) {
				double dResult = iNum / Math.random(); // 0.0 ~ 1.0 사이의 난수 발생.
														// 잠재적 에러 유발.
				System.out.println("RESULT : " + dResult);
			}
		} catch (ArithmeticException e) {
			String a = "Aritemetic Exception!\n";
			a+=e;
			System.out.println(a);
		} catch (Exception e) { // 예외처리.
			flag = false;
			//ArithmeticException : 전문 예외처리 클래스
			//System.out.println("Error : " + e);
			//System.out.println("Error : " + e.getMessage());
			e.printStackTrace(); // complete msg(message) for developer
		} finally { // 예외처리 후 반드시 실행해야 하는 기능. 인수가 없다. Ex) Resource Return
			flag = false;
		}
	}

}
