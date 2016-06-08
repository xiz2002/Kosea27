
public class SubArrayS {
	// int iArr[][] = new int[][]; // 불가
	// int iArr[][] = new int[2][3]; // 가능
	// int[][] iArr = new int[2][3]; // 가능
	// int[] iArr[] = new int[2][3]; // 가능
	// int[]iArr[] = new int[2][3]; // 가능
	/*
	 * JAVA 의 경우
	 *  int iArr[][] = new int[2][]; // 가능
	 *  int iArr[][] = new int[][3]; // 불가
	 *
	 * C 의 경우
	 *  int iArr[2][] = {}; // 불가
	 *  int iArr[][3] = {}; // 가능
	 */

	// int iArr[][] = {{1,2},{3,4},{5}};
	// int iArr[][] = new int[3][]{{1,2},{3,4},{5}}; // 불가
	// int iArr[][] = new int[][2]{{1,2},{3,4},{5}}; // 불가
	// int iArr[][] = new int[3][2]{{1,2},{3,4},{5}}; // 불가

	private int iArr[][] = { { 1, 2 }, { 3, 4 }, { 5 } };

	public void forprint() {
		for (int i = 0; i < iArr.length; i++) {
			for (int j = 0; j < iArr[i].length; j++) {
				System.out.println("[" + i + "]:[" + j + "] = " + iArr[i][j]);
			}
		}
	}
	
	public void foreach() {
		for (int[] is : iArr) {
			for (int i : is) {
				System.out.println(i);
			}
		}
	}
}
