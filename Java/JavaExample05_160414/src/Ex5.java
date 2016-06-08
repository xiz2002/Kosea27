/**
 * 
 */

/**
 * @author ToyMac while : ~ 하는 동안.
 */
public class Ex5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 2, j = 1;
		System.out.println("비둘기야 밥먹자~ 구구구구구구구구구구구구구구\n================================");
		while (i <= 9) {
			while (j <= 9) {
				System.out.println(i + " X " + j + " = " + (i * j));
				j++;
			}
			System.out.println("=================================");
			i++;
			j=1;//배수 초기화.
		}
		System.out.println("\nCongurachuration~ your Chicken CEO~");
	}
}
