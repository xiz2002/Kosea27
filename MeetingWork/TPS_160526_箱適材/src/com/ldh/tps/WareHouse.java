package com.ldh.tps;

/**
 * @Package : com.ldh.tps
 * @Class : WareHouse.java
 * @Description : TPS_160526_ori
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2016. 8. 10.     ToyMac      최초생성
 *
 * @author ToyMac
 * @since 2016. 8. 10.
 * @version 1.0
 * @see
 *
 *  Copyright (C) by ToyBox All right reserved.
 */
public class WareHouse {

	private static WareHouse ware;
	private HakkoManager hakko;
	private Common common;
	private int iNum;
	private String strSome, iFlag;

	private WareHouse() {
		hakko = new HakkoManager();
		common = new CommonImpl();
	}

	/**
	 * @Method 설명 : Singleton
	 * @Method : getInstance
	 * @작성일 : 2016. 8. 9.
	 * @작성자 : ToyMac
	 * @변경이력 : 
	 * 수정일자 		작성자 		내용
	 * ---------------------------------------------------
	 * 2016. 8. 9.  ToyMac 		최초작성
	 * @return WareHouse ware
	 */
	public static WareHouse getInstance() {
		if (ware == null) {
			ware = new WareHouse();
		}
		return ware;
	}

	/**
	 * @Method 설명 : 박스 번호 입력
	 * @Method : displayBoxInfo
	 * @작성일 : 2016. 8. 9.
	 * @작성자 : ToyMac
	 * @변경이력 : 
	 * 수정일자 		작성자 		내용
	 * ---------------------------------------------------
	 * 2016. 8. 9.  ToyMac 		최초작성
	 * @throws Exception
	 */
	public void displayBoxInfo() throws Exception {
		System.out.println("箱の番号を入れてください。番号は　1　から　" + hakko.getHakkoMax() + "　まであります。");
		System.out.print("Box番号 : ");
		this.iNum = common.getIntegerArrayValue();
	}

	/**
	 * @Method 설명 : 물건 입력
	 * @Method : displaySomeInfo
	 * @작성일 : 2016. 8. 9.
	 * @작성자 : ToyMac
	 * @변경이력 : 
	 *   수정일자 		작성자 		내용
	 * ---------------------------------------------------
	 * 2016. 8. 9. 	ToyMac 		최초작성
	 */
	public void displaySomeInfo() {
		System.out.println("物を入力してください.");
		System.out.print("物名 : ");
		this.strSome = common.getStringValue();
	}

	/**
	  * @Method 설명 : 전체 흐름 관리
	  * @Method : start
	  * @작성일 : 2016. 8. 9.
	  * @작성자 : ToyMac
	  * @변경이력 : 
	  *   수정일자         작성자              내용
	  * ---------------------------------------------------
	  * 2016. 8. 9.     ToyMac       최초작성
	  * 2016. 8. 9.		ToyMac		 iFlag Type Change from Integer to String 
	  */
	public void start() {
		while (true) {
			try {
				System.out.println("番号を選んでください。");
				System.out.println("１：物を入れる。2　：物を取り出す。３：終了");
				System.out.print("入力 : ");
				iFlag = common.getStringValue();
	
				switch (iFlag) {
				case "1":
					this.displayBoxInfo();
					this.displaySomeInfo();
					hakko.setInHakko(iNum, strSome);
					System.out.println(hakko.getHakkoStatus(iNum));
					break;
	
				case "2":
					this.displayBoxInfo();
					this.displaySomeInfo();
					hakko.getInHakko(iNum, strSome);
					System.out.println(hakko.getHakkoStatus(iNum));
					break;
	
				case "3":
					System.out.println(hakko.getHakkoAllStatus());
					System.out.println("終了です。");
					System.exit(0);
					break;
	
				default:
					common.displayNumOverErr();
					break;
				}
			} catch(Exception e) {
				System.out.println("ERROR");
			}
		}
	}
}
