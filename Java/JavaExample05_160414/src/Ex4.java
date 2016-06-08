/**
 * 
 */

/**
 * @author ToyMac
 *
 */
public class Ex4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int sum = 0, i = 1;
		while (i < 11) {
			sum += i;
			i++;
		}
		System.out.println(sum);

		do {
			sum += i;
			++i;
		} while (i < 11);
		System.out.println(sum);
		
	}
}
