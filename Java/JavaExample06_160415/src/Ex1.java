/**
 * 
 */

/**
 * @author ToyMac
 *
 **
 ***
 ****
 *****
 ******
 *******
 ********
 *********
 **********
 */
public class Ex1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("=========================================");
		int i = 1, j = 1;
		while (i <= 10) {
			while (j <= i) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
			j=1;
		}
	}
}
