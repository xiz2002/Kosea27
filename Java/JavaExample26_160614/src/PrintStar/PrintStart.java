package PrintStar;

/**-----------------------------------------------------------------------------
<pre>
PackageName : PrintStar
ClassName   : PrintStart.java
Editor      : ToyMac
Update      : 2016. 6. 18. 오후 6:51:16
Logs        : 

Result 
        *
      *
    *
  *
*
  *
    *
      *
        *
</pre>
-----------------------------------------------------------------------------*/
public class PrintStart {

	public static void main(String[] args) {
		int iLimit = 10;
		for(int i = 1; i < iLimit; i++) {
			for(int j = 0; j < Math.abs((i*2)-iLimit); j++) {
				System.out.print(" ");
				//System.out.print(i);
			}
			System.out.println("*");
		}
	}
}
