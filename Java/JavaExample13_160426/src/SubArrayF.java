// import java.util.Iterator;

public class SubArrayF {

	// int inVal = "c"; // 원형에 참조형을 대입할수 없다.
	private int iArr[] = { 1, 2, 3 };
	// 선언 + 값 할당(대입) -> 초기화
	// int []iArr = {1,2,3}
	// int[] iArr = {1,2,3}
	// int iArr[] = new int[] {1,2,3};
	// int iArr[] = new int[3] {1,2,3}; // 불가
	// int iArr[] = new int[]; // 불가 (초기화 값 미제공)
	// int iArr[] = new int[3]; // 가능
	// int iArr[];
	// iArr={1,2,3}; // 불가
	// 초기화 표현 -> 선언+할당 에서만 사용

	// int iArr[3] = {1,2,3}; C/C++ 가능 / JAVA불가

	// System.out.println("iArr[2] : " + iArr[3]);
	// ArrayIndexOutOfBoundsException 예외 발생 / 범위 초과
	// 실행시 에러 (RunTime Error)
	
	public void forprint() {
		// 배열요소 전체 출력
		// 색인(index) 사용 가능
		for(int i = 0;i<iArr.length;i++) {
			System.out.println("[" + i + "] : " + iArr[i]);
		}
	}

	public void foreach(){
		// 향상된(Enhanced) for loop
		// since JDK 1.5
		// 반복자(Iterator) 패턴으로 검색/인쇄
		// 색인(index) 없이 next/previous 검색
		// 검색 속도 측면에서 최적화
		for(int i:iArr) {
			System.out.println(i);
		}
	}
	
	/*public void foriterator() {
	 * 		ArrayList 와 같은 배열이 아닌이상 collection으로보기 힘들다. for (Iterator iterator =
	 * 		collection.iterator(); iterator.hasNext();) { type type = (type)
	 * 			iterator.next();
	 * 		}
	 * }
	 */
}
