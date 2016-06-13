/**-----------------------------------------------------------------------------
<pre>
ProjectName  : JavaExample25_160613
PacakageName : 
FileName     : PrintStar3.java
Editor       : ToyMac
E-Mail       : xiz2002@gmail.com
Update       : 2016. 6. 13. 오전 11:40:43
Log          : 
</pre>
-----------------------------------------------------------------------------*/

/**
 * -----------------------------------------------------------------------------
 * 
 * <pre>
PackageName : 
ClassName   : PrintStar3.java
Editor      : ToyMac
Update      : 2016. 6. 13. 오전 11:40:43
Logs        :
 * </pre>
 * 
 * -----------------------------------------------------------------------------
 */
public class PrintStar3 {

	public static void main(String[] args) {
		int iNum = 5;
		int k = 0;
		for (int i = 1; i <= iNum; i++) {
			for (int j = 0; j < iNum - i; j++) {
				System.out.print(" ");
			}
			for (int j = i + k; j > 0; j--) {
				System.out.print("*");
			}
			k++;
			System.out.println();
		}
	}
}
