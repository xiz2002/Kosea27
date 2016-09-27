package com.ldh.tps;

/**
 * @Package : com.ldh.tps
 * @Class : Main.java
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
public class Main {
	
	public static void main(String[] args) {

		WareHouse ware = WareHouse.getInstance();
		ware.start();
	}
}
