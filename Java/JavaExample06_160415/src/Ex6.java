/**
 * 
 */

/**
 * @author ToyMac
 * 
        *
      *
    *
  *
*
  *
    *
      *
        *
 */
public class Ex6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int input = 5;
		for (int iLine = 1; iLine < input; iLine++) {
			for (int iSpace = 0; iSpace < input - iLine; iSpace++) {
				System.out.print("  ");
			}
			System.out.println("* ");
		}
		for (int iLine = 0; iLine < input; iLine++) {
			for (int iSpace = 1; iSpace <= iLine; iSpace++) {
				System.out.print("  ");
			}
			System.out.println("* ");
		}
		/* 강사의 답안 */
		for (int i = 1; i < 10; i++) {

			// int temp= 10-i*2;
			// temp= temp > 0 ? temp : -temp;
			int temp = Math.abs(10 - i * 2);

			for (int j = temp; j > 0; j--) {

				System.out.print(" ");
			}

			System.out.println("*");
		} // for
	}
}
