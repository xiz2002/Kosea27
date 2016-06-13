/**-----------------------------------------------------------------------------
<pre>
ProjectName  : JavaExample25_160613
PacakageName : 
FileName     : PrintStar.java
Editor       : ToyMac
E-Mail       : xiz2002@gmail.com
Update       : 2016. 6. 13. 오전 11:12:52
Log          : 
</pre>
-----------------------------------------------------------------------------*/

/**
 * -----------------------------------------------------------------------------
 * 
 * <pre>
PackageName : 
ClassName   : PrintStar.java
Editor      : ToyMac
Update      : 2016. 6. 13. 오전 11:12:52
Logs        :
 * </pre>
 * 
 * -----------------------------------------------------------------------------
 */
public class PrintStar {
	public static void main(String[] args) {

		int i = 1, j = 1;
		while (i <= 5) {
			while (j <= i) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
			j = 1;
		}
	}
}
