package Average;

import java.util.Scanner;

/**-----------------------------------------------------------------------------
<pre>
PackageName : Average
ClassName   : AverageJumsu.java
Editor      : ToyMac
Update      : 2016. 6. 18. 오후 6:50:19
Logs        : 

Result 
	국어 점수 입력 : 85.5
	영어 점수 입력 : 90.2
	수학 점수 입력 : 75.1
	총점 : 250.80
	평균 : 83.70
</pre>
-----------------------------------------------------------------------------*/
public class AverageJumsu {

	public static void main(String[] args) {
		
		double[] dJumsu = new double[3];
		Scanner scanf = new Scanner(System.in);
		
		System.out.print("국어 점수 입력 : ");
		dJumsu[0] = scanf.nextDouble();
		System.out.print("영어 점수 입력 : ");
		dJumsu[1] = scanf.nextDouble();
		System.out.print("수학 점수 입력 : ");
		dJumsu[2] = scanf.nextDouble();
		System.out.printf("총점 : %.2f\n",(dJumsu[0] + dJumsu[1] + dJumsu[2]));
		System.out.printf("평균 : %.2f\n",(dJumsu[0] + dJumsu[1] + dJumsu[2])/dJumsu.length);
		
	}

}
