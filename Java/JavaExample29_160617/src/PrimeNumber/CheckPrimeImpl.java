package PrimeNumber;

public class CheckPrimeImpl implements CheckPrime {

	@Override
	public boolean isPrimeNum(int num) {
		boolean rtn = false;
		if(num == 0 || num == 1) {
			System.out.println(num + "은 불가");
			return false;
		}
		
		for (int i = 2; i < num; i++) {
			rtn = (num % i == 0) ? true : false;
			if(rtn) {
				return false;
			}
		}
		return true;
	}
}
