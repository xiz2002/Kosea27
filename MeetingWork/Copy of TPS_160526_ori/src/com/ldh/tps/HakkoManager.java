package com.ldh.tps;

public class HakkoManager {

	private int _BOXMAX = 10;
	private int _SOMEMAX = 100;
	private String[][] box;
	private Common common;

	HakkoManager() {
		common = new CommonImpl();
		box = new String[_BOXMAX][_SOMEMAX];
	}
	//
	// HakkoManager(int bMax, int sMax) {
	// common = new CommonImpl();
	// this._BOXMAX = bMax;
	// this._SOMEMAX = sMax;
	// box = new String[_BOXMAX][_SOMEMAX];
	// }

	public int hakkoMax() {
		return _BOXMAX;
	}

	public int someMax() {
		return _SOMEMAX;
	}

	public void setInHakko(int iNum, String strSome) {
		try {
			for (int i = 0; i < box[iNum].length; i++) {
				if (box[iNum][i] == null) {
					box[iNum][i] = strSome;
					break;
				}
			}
			System.out.println("箱" + (iNum + 1) + "番に物を入れました。"); // 적재 끝.
		} catch (IndexOutOfBoundsException e) {
			common.displayNumOverErr();
			common.clearScreen();
		}
	}

	public void getHakkoAllStatus() {
		for (int i = 0; i < _BOXMAX; i++) {
			this.getHakkoStatus(i);
		}
	}

	public String getHakkoStatus(int iNum) {
		String strResult = "";
		if (box[iNum][0] == null) {
			strResult += iNum + "箱は　空いています。\n";
		} else {
			strResult += "中には [";
			for (int i = 0; i < box[iNum].length; i++) {
				if (box[iNum][i] == null)
					break;
				strResult += (i == 0) ? box[iNum][i] : ", " + box[iNum][i];
			}
			strResult += "]が あります。\n";
		}
		return strResult;
	}

	public void getInHakko(int iNum, String strSome) {
		int i = 0;
		int z = 0;
		for (int j = 0; j < i; j++) {
			if (box[iNum][j].equals(strSome)) {
				System.out.println("取られました。");
				z = j;
				for (int c = z; c < i; c++)
					box[iNum][c] = box[iNum][c + 1];
				i -= 1;
			}
		}
	}
}