package PrymidWord;

/**-----------------------------------------------------------------------------
<pre>
PackageName : PrymidWord
ClassName   : PrymidWord.java
Editor      : ToyMac
Update      : 2016. 6. 18. 오후 6:51:38
Logs        : 

Result 
      W
     Web
    Web D
   Web Dev
  Web Devel
 Web Develop
Web Developer
</pre>
-----------------------------------------------------------------------------*/
public class PrymidWord {

	public static void main(String[] args) {
		String strWord = "Web Developer";
		int iLimit = 7;
		for (int i = 1; i <= iLimit; i++) {
			for (int j = 0; j < Math.abs(i-iLimit); j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < (i*2)-1; j++) {
				System.out.print(strWord.charAt(j));
			}
			System.out.println("");
		}
	}

}
