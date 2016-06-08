/**
 * 
 */

/**
 * @author ToyMac
 *
 */
public class Ex3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("구구단 시작");
		System.out.println("---------------------------------------");
		for (int i=2; i<=9; i++){
			for(int j=1;j<=9; j++){
				System.out.println(i +" X "+ j + " = " + i*j);
			}
			System.out.println("---------------------------------------");
		}
	}
}
