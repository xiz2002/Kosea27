/**
 * 
 */

/**
 * @author Administrator
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// boolean flag = false;
		// boolean flag = true;
		 int flag = 1;
		
		// 조건문(Condition Statement(Sentence))
		// ( ) : Result true /  false
		// if(flag == true)
		// int 형은 단항조건 불가.
		// if(flag != 1)
		// if(flag > 0) { // 초과 (Greater than : gt)
		// if(flag >= 0) { // 이상 (Greater than & equals : gte)
		// if(flag < 0) { // 미만 (less than : lt)
		// if(flag <= 0) { // 이하 (less than & equals : lte)
		// if(!flag) { // 부정 (not / negative)

		// 2016/4/11 2교시 ~
		// if (flag != true) { // 위와 동일
		// if (!!flag)  이중부정 = 긍정(postive)
		//if (!flag == false) //
		//if !(!flag == false) // 불가 (x)
		//if (!(!flag == false)) //

//		if(flag >= 1 && flag <=3) { // && 일반 논리 (AND)
//		if (!(flag >= 1 && flag <=3)) { // 위와 반대 // 전체 부정
//		if (!(flag < 1 || flag > 3)) { // || 일반 논리 (OR)
//		if (!(flag >= 1 || flag <= 3)) { // 위와 반대
		if(flag >=1 & flag <=3) { // & 비트 논리 ( AND )
		// 문법적 오류 (X) -> Bit Logic AND
		// 10/8/16 진수 -> 2진수 (변환) 하여 논리 비교 
		 	System.out.println("True!");
		} else {
			System.out.println("False!");
		}

	}

}
