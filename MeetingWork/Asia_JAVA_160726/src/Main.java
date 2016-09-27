import java.util.Scanner;

public class Main {
	
	public static char[] strIn() {
		Scanner scanf = new Scanner(System.in);
		
		System.out.print("문자열 입력 : ");
		String m = scanf.next();
		
		char[] ch = new char[m.length()];
		
		for (int i = 0; i < m.length(); i++) {
			ch[i] = m.charAt(i);
		}
		return ch;
	}

	public static void main(String[] args) {
		char[] chX = null;
		char[] chY = null;
		char[] chZ = null;
		
		chX = strIn();
		chY = strIn();
		chZ = new char[chX.length+chY.length];
		for (int i = 0; i < chX.length; i++) {
			chZ[i] = chX[i];
		}

		for (int i = 0; i < chX.length; i++) {
			chZ[chX.length + i] = chY[i];
		}

		System.out.print(chZ);
	}

}
