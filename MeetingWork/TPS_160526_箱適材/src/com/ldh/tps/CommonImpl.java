package com.ldh.tps;

import java.util.Scanner;

/**
 * @Package : com.ldh.tps
 * @Class : CommonImpl.java
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
public class CommonImpl implements Common {
	
	Scanner sInput = new Scanner(System.in);
	
	/**
	  * (non-Javadoc)
	  * @see com.ldh.tps.Common#clearScreen()
	  * @Method : clearScreen
	  * @작성일 : 2016. 8. 9.
	  * @작성자 : ToyMac
	  * @변경이력 : 
	  *   수정일자         작성자              내용
	  * ---------------------------------------------------
	  * 2016. 8. 9.     ToyMac      최초작성
	  * @Method 설명 : 화면 갱신
	  */
	@Override
	public void clearScreen() {
		for (int i = 0; i < 30; i++) {
			System.out.println();
		}
	}
	
	/**
	  * @see com.ldh.tps.Common#getIntegerAbsValue()
	  * @Method : getIntegerAbsValue
	  * @작성일 : 2016. 8. 9.
	  * @작성자 : ToyMac
	  * @변경이력 : 
	  *   수정일자         작성자              내용
	  * ---------------------------------------------------
	  * 2016. 8. 9.     ToyMac       최초작성
	  * @Method 설명 :
	  * @return
	  */
	@Override
	public int getIntegerAbsValue() {
		int iInputValue = 0;
		try {
			iInputValue = sInput.nextInt();
		} catch (Exception e) {
			System.out.println("不適切な数");
			iInputValue = 0;
		}
		return Math.abs(iInputValue);
	}

	/**
	  * @Method 설명 : 배열 관련 값을 받는 함수
	  * @see com.ldh.tps.Common#getIntegerArrayValue()
	  * @Method : getIntegerArrayValue
	  * @작성일 : 2016. 8. 9.
	  * @작성자 : ToyMac
	  * @변경이력 : 
	  *   수정일자         작성자              내용
	  * ---------------------------------------------------
	  * 2016. 8. 9.     ToyMac       최초작성
	  * @return Integer iInputValue
	  */
	@Override
	public int getIntegerArrayValue() throws Exception {
		int iInputValue;
		try {
			iInputValue = sInput.nextInt();
			if(iInputValue == 0) throw new Exception();
			iInputValue += -1;
		} catch (Exception e) {
			throw new Exception();
		}
		return Math.abs(iInputValue);
	}

	/**
	  * (non-Javadoc)
	  * @see com.ldh.tps.Common#getStringValue()
	  * @Method : getStringValue
	  * @작성일 : 2016. 8. 9.
	  * @작성자 : ToyMac
	  * @변경이력 : 
	  *   수정일자         작성자              내용
	  * ---------------------------------------------------
	  * 2016. 8. 9.     ToyMac       최초작성
	  * @Method 설명 :
	  * @return String
	  */
	@Override
	public String getStringValue() {
		return sInput.next();
	}

	@Override
	public void displayNumOverErr() {
	}
	
}
