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
public class Ex2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int cnt = 0; cnt <= 9; cnt++) {
			System.out.print(cnt);
		}
		System.out.println();
		int total = 10;
		for (int i = 1; i <= total; i++) {
			for (int j = 1; j <= total-i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("=========================================");
		for (int i = 1; i <= 10; i++) {
			for (int j = 10; j >= 1; j--) {
				if (j > i) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		System.out.println("=========================================");
		int i = 1, j = 10;
		String strT;
		while (i <= 10) {
			while (j >= 1) {
				strT = j > i ? " " : "*";
				System.out.print(strT);
				j--;
			}
			System.out.println();
			i++;
			j = 10;
		}
	}
}
