package PrimeNumber;

public class Main {

	public static void main(String[] args) {
		CheckPrimeImpl cpi = new CheckPrimeImpl();
		if(cpi.isPrimeNum(Integer.parseInt(args[0])))
			System.out.println(args[0] + " : 소수");
		else
			System.out.println(args[0] + " : 소수아님");
	}
}
