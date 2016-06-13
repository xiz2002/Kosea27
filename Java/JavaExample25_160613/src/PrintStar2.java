/**-----------------------------------------------------------------------------
<pre>
ProjectName  : JavaExample25_160613
PacakageName : 
FileName     : PrintStar2.java
Editor       : ToyMac
E-Mail       : xiz2002@gmail.com
Update       : 2016. 6. 13. 오전 11:14:39
Log          : 
</pre>
-----------------------------------------------------------------------------*/

/**
 * -----------------------------------------------------------------------------
 * 
 * <pre>
PackageName : 
ClassName   : PrintStar2.java
Editor      : ToyMac
Update      : 2016. 6. 13. 오전 11:14:39
Logs        :
 * </pre>
 * 
 * -----------------------------------------------------------------------------
 */
public class PrintStar2 {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			for (int j = 5 - i; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
