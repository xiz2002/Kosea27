/**
 * 
 */

/**
 * @author ToyMac
 *
          * 
        * * * 
      * * * * * 
    * * * * * * * 
  * * * * * * * * * 
* * * * * * * * * * * 

 */
public class Ex5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int input = 6;
		int iLine = 1;
		int iVal = 0;
		int iStarMAX;
		int iSpaceMAX;
		while (iLine <= input) {
			
			iStarMAX = iLine + iVal;
			iSpaceMAX = (input - iLine);
			
			for (int iSpace = 0; iSpace < iSpaceMAX; iSpace++) {
				System.out.print("  ");
			}
			
			for (int iStarCnt = 0; iStarCnt < iStarMAX; iStarCnt++) {
				System.out.print("* ");
			}
			System.out.println("");
		
			iVal++;
			iLine++;
			
		}
	}
}
