/**-----------------------------------------------------------------------------
<pre>
ProjectName  : JavaExample25_160613
PacakageName : 
FileName     : DiamondNumber.java
Editor       : ToyMac
E-Mail       : xiz2002@gmail.com
Update       : 2016. 6. 13. 오후 12:21:47
Log          : 
</pre>
-----------------------------------------------------------------------------*/

public class DiamondNumber {

	public static void main(String[] args) {
		int arrNum[][] = new int[5][5];
		int k = 0, s = 2, e = 2;

		for (int i = 0; i < arrNum.length; i++) {
			for(int j = e; j <= s; j++) {
				k = k + 1;
				arrNum[i][j] = k;
			}
			if(i < 2) {
				s += 1;
				e -= 1;
			} else {
				s-= 1;
				e+= 1;
			}
		}
		for(int i = 0; i < arrNum.length; i++) {
			for(int j = 0; j < arrNum.length; j++ ) {
				System.out.print(" | " + arrNum[i][j] + " | ");
			}
			System.out.println();
		}
	}
}
