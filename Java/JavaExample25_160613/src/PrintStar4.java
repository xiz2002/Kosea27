/**-----------------------------------------------------------------------------
<pre>
ProjectName  : JavaExample25_160613
PacakageName : 
FileName     : PrintStar4.java
Editor       : ToyMac
E-Mail       : xiz2002@gmail.com
Update       : 2016. 6. 13. 오후 12:07:59
Log          : 
</pre>
-----------------------------------------------------------------------------*/

public class PrintStar4 {

	public static void main(String[] args) {
		int iNum = 5;
		int k = 1;
		for (int i = 0; i < iNum; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = (iNum*2) - k; j > 0; j--) {
				System.out.print("*");
			}
			k+=2;
			System.out.println();
		}
	}
}
