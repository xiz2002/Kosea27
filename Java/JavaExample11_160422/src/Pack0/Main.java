package Pack0;


public class Main {

	public static void main(String args[]) {
		Object obj = new Object();
		System.out.println("hascode : " + obj.hashCode());
		System.out.println("toStinrg : " + obj.toString());
		// reflection : Class 내부 정보를 비춰주는것 
		System.out.println("getClass : "  + obj.getClass());
	}
}
