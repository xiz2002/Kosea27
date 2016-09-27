package com.ldh.tps;

/**
 * @Package : com.ldh.tps
 * @Class : HakkoManager.java
 * @Description : TPS_160526_ori
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2016. 8. 9.     ToyMac      최초생성
 *
 * @author ToyMac
 * @since 2016. 8. 9.
 * @version 1.0
 * @see
 *
 *  Copyright (C) by ToyBox All right reserved.
 */
public class HakkoManager {

	private int _BOXMAX = 10;
	private int _SOMEMAX = 100;
	private String[][] box;
	private Common common;

	
	HakkoManager() {
		common = new CommonImpl();
		box = new String[_BOXMAX][_SOMEMAX];
	}

	/**
	  * @Method 설명 : 상수 BOXNUM을 반환
	  * @작성일 : 2016. 8. 9.
	  * @작성자 : ToyMac
	  * @변경이력 : 
	  *   수정일자         작성자              내용
	  * ---------------------------------------------------
	  * 2016. 8. 9.     ToyMac       최초작성
	  * @Method : getHakkoMax
	  * @return Integer _BOXNUM
	  */
	public int getHakkoMax() {
		return _BOXMAX;
	}

	/**
 	  * @Method 설명 : 상수 SOMEMAX을 반환
	  * @작성일 : 2016. 8. 9.
	  * @작성자 : ToyMac
	  * @변경이력 : 
	  *   수정일자         작성자              내용
	  * ---------------------------------------------------
	  * 2016. 8. 9.     ToyMac       최초작성
	  * @Method : getSomeMax
	  * @return Integer _SOMEMAX
	  */
	public int getSomeMax() {
		return _SOMEMAX;
	}

	/**
	  * @Method 설명 : 상자 번호를 입력 받음.
	  * @작성일 : 2016. 8. 9.
	  * @작성자 : ToyMac
	  * @변경이력 : 
	  *   수정일자         작성자              내용
	  * ---------------------------------------------------
	  * 2016. 8. 9.     ToyMac       최초작성
	  * @Method : setInHakko
	  * @param iNum
	  * @param strSome
	  */
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

	/**
	  * @Method 설명 : 전체 상자에 들어있는것을 표시.
	  * @작성일 : 2016. 8. 9.
	  * @작성자 : ToyMac
	  * @변경이력 : 
	  *   수정일자         작성자              내용
	  * ---------------------------------------------------
	  * 2016. 8. 9.     ToyMac       최초작성
	  * @Method : getHakkoAllStatus
	  * @Return String strResult
	  */
	public String getHakkoAllStatus() {
		String strResult = "";
		for (int i = 0; i < _BOXMAX; i++) {
			strResult += this.getHakkoStatus(i);
		}
		return strResult;
	}

	/**
	  * @Method 설명 : 선택한 상자에 들어있는 것을 표시.
	  * @작성일 : 2016. 8. 9.
	  * @작성자 : ToyMac
	  * @변경이력 : 
	  *   수정일자         작성자              내용
	  * ---------------------------------------------------
	  * 2016. 8. 9.     ToyMac       최초작성
	  * @Method : getHakkoStatus
	  * @param iNum
	  * @return String strResult
	  */
	public String getHakkoStatus(int iNum) {
		String strResult = "";
		if (box[iNum][0] == null) {
			strResult += (iNum+1) + "箱は　空いています。\n";
		} else {
			strResult += (iNum+1) + "箱の　中には [";
			for (int i = 0; i < box[iNum].length; i++) {
				if (box[iNum][i] == null)
					break;
				strResult += (i == 0) ? box[iNum][i] : ", " + box[iNum][i];
			}
			strResult += "]が あります。\n";
		}
		return strResult;
	}

	/** 여자 1.도서관 / 남자 3.데파토1
	  * @Method 설명 : 상자에 물건을 반환.
	  * @작성일 : 2016. 8. 9.
	  * @작성자 : ToyMac
	  * @변경이력 : 
	  *   수정일자         작성자              내용
	  * ---------------------------------------------------
	  * 2016. 8. 9.     ToyMac       최초작성
	  * @Method : getInHakko
	  * @param iNum
	  * @param strSome
	  */
	public void getInHakko(int iNum, String strSome) {
		int z = 0;
		for (int j = 0; j < box[iNum].length; j++) {
			if (box[iNum][j].equals(strSome)) {
				System.out.println("\n" + box[iNum][j] + "取れました。");
				box[iNum][j] = null;
				z = j;
				break;
			}
		}	
		for (int c = z; c < box[iNum].length; c++){
			if(box[iNum][c + 1] != null) {
				box[iNum][c] = box[iNum][c + 1];
				box[iNum][c+1] = null;
			} else {
				break;
			}
		}
	}
}