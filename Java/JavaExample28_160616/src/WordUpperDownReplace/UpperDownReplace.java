package WordUpperDownReplace;

/**-----------------------------------------------------------------------------
<pre>
PackageName : WordUpperDownReplace
ClassName   : UpperDownReplace.java
Editor      : ToyMac
Update      : 2016. 6. 18. 오후 6:48:33
Logs        :

 Before : Design is not just what it looks like and feels like. Design is how it works.
  After : Design Is Not Just What It Looks Like And Feels Like. 
 	 	  Design Is How It Works.
</pre>
-----------------------------------------------------------------------------*/
public class UpperDownReplace {

	public static void main(String[] args) {
		String str = "Design is not just what it looks like and feels like. Design is how it works.";
		String strTemp = "";
		String strAfter = "";
		int iCnt = 0;
		
		strTemp = str.substring(iCnt, iCnt+1);
		while (true) {

			if (iCnt >= str.length())
				break;
			
			if(iCnt != 0)
				strTemp = str.substring(iCnt-1, iCnt);

			if (strTemp.equals(" ")) {
				strTemp = str.substring(iCnt, iCnt+1);
				strAfter += strTemp.toUpperCase();
			} else if (strTemp.equals(".")) {
				strAfter += "\n";
			} else {
				strAfter += str.charAt(iCnt);
			}
			
			iCnt++;
		}
		
		System.out.println(strAfter);
	}

}
