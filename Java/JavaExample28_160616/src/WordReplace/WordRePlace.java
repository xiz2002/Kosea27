package WordReplace;

/**-----------------------------------------------------------------------------
<pre>
PackageName : WordReplace
ClassName   : WordRePlace.java
Editor      : ToyMac
Update      : 2016. 6. 18. 오후 6:49:18
Logs        : 

Before : "객체화된 기본 자료형 대신 기본 자료형을 이용하라"
After : "객체화된 프리미티브 자료형 대신 프리미티브 자료형을 이용하라"
</pre>
-----------------------------------------------------------------------------*/
public class WordRePlace {

	public static void main(String[] args) {
		String str = "객체화된 기본 자료형 대신 기본 자료형을 이용하라";
		System.out.println(" Before Repalce : " + str);
		str = str.replaceAll("기본","프리미티브");
		System.out.println(" After Repalce : " + str);
		
	}

}
