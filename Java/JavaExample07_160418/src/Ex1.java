
public class Ex1 {

	public static void main(String args[]) {
		for (int i = 0; i <= 100; i++) {
			if (i == 50)
				continue; // volatile
			else if (i > 60)
				break;
			else
				System.out.println(i);
		}
	}
}
