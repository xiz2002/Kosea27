package BubleSort;

public class BubbleSort {
	/*
	 * public static void upperSort(int[] arrNum) { for (int i = 0; i <
	 * arrNum.length; i++) { for (int s = 1; s < arrNum.length; s++) { if
	 * (arrNum[s - 1] > arrNum[s]) { int iTemp = arrNum[s]; arrNum[s] = arrNum[s
	 * - 1]; arrNum[s - 1] = iTemp; } } } for(int i = 0; i < arrNum.length; i++)
	 * { System.out.print(arrNum[i] + ", "); } }
	 * 
	 * public static void downSort(int[] arrNum) { for(int i = 0; i <
	 * arrNum.length; i++) { for(int s = 1; s < arrNum.length; s++) {
	 * if(arrNum[s - 1] < arrNum[s]) { int iTemp = arrNum[s-1]; arrNum[s-1] =
	 * arrNum[s]; arrNum[s] = iTemp; } } } for(int i = 0; i < arrNum.length;
	 * i++) { System.out.print(arrNum[i] + ", "); } } }
	 * 
	 * package etc3;
	 * 
	 * public class BubbleSort {
	 */
	public int[] bubbleSort(int[] arrNum, String ascFlag) {
		int n = arrNum.length;
		if (n <= 0) {
			return new int[0];
		}
		// 시작
		for (int i = 0; i < arrNum.length; i++) {
			for (int s = 1; s < arrNum.length; s++) {
				if (ascFlag.equals("asc")) {
					if (arrNum[s - 1] > arrNum[s]) {
						int iTemp = arrNum[s];
						arrNum[s] = arrNum[s - 1];
						arrNum[s - 1] = iTemp;
					}
				} else {
					if (arrNum[s - 1] < arrNum[s]) {
						int iTemp = arrNum[s];
						arrNum[s] = arrNum[s - 1];
						arrNum[s - 1] = iTemp;
					}
				}
			}
		}
		// 끝
		return arrNum;
	}

	public static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (i != a.length - 1)
				System.out.printf("%d, ", a[i]);
			else
				System.out.printf("%d", a[i]);
		}
		System.out.println();
	} //
}
