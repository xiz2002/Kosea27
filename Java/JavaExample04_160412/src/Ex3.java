/**
 * @author ToyMac
 * Run As -> Run Configure -> Argument -> Variable -> ${String_Prompt} *
 */
public class Ex3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int iScore = Integer.parseInt(args[1]);
		char chResult;	
/*	What the ....
 *  메모리가 넉넉하고 연산장치가 느릴경우 하는 방법(?)
 *               
               switch (score) {
               case 90:case 91:case 92:
               case 93:case 94:case 95:
               case 96:case 97:case 98:
               case 99:case 100: result='A'; break;
 
               case 80:case 81:case 82:
               case 83:case 84:case 85:
               case 86:case 87:case 88:
               case 89:result='B'; break;
 
               case 70:case 71:case 72:
               case 73:case 74:case 75:
               case 76:case 77:case 78:
               case 79:result='C'; break;
 
               case 60:case 61:case 62:
               case 63:case 64:case 65:
               case 66:case 67:case 68:
               case 69:result='D'; break;
 
               default : result = 'F'; break;
               }
              		
 */
/*
 * 	메모리가 부족할경우 연산으로 때우기.
 */
		switch(iScore/10) {
		case 10:
		case 9 :
			chResult = 'A';
			break;
		case 8 :
			chResult = 'B';
			break;
		case 7 :
			chResult = 'C';
			break;
		case 6 :
			chResult = 'D';
			break;
		default :
			chResult = 'F';
			break;
		}
		p(args[0],chResult);
	}
	
	public static void p(Object n, Object a) {
		
		String m = n.toString() + "의 학점은 "+ a.toString() + "입니다.";
		
		System.out.println(m);
	}
}
