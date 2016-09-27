package com.ldh.tps;

public class WareHouse {

	private static WareHouse ware;
	private HakkoManager hakko;
	private Common common;
	private int iNum, iFlag;
	private String strSome;

	private WareHouse() {
		hakko = new HakkoManager();
		common = new CommonImpl();
	}

	public static WareHouse getInstance() {
		if (ware == null) {
			ware = new WareHouse();
		}
		return ware;
	}

	public void displayBoxInfo() {
		System.out.println("箱の番号を入れてください。番号は　1　から　" + hakko.hakkoMax() + "　まであります。");
		System.out.print("Box番号 : ");
		this.iNum = common.getIntegerArrayValue();
	}

	public void displaySomeInfo() {
		System.out.println("物を入力してください.");
		System.out.print("物名 : ");
		this.strSome = common.getStringValue();
	}

	public void start() {
		while (true) {
			System.out.println("番号を選んでください。");
			System.out.println("１：物を入れる。2　：物を取り出す。３：終了");
			System.out.print("入力: ");
			iFlag = common.getIntegerAbsValue();

			switch (iFlag) {
			case 1:
				this.displayBoxInfo();
				this.displaySomeInfo();
				hakko.setInHakko(iNum, strSome);
				hakko.getHakkoStatus(iNum);
				break;

			case 2:
				this.displayBoxInfo();
				hakko.getHakkoStatus(iNum);
				this.displaySomeInfo();
				hakko.getInHakko(iNum, strSome);
				hakko.getHakkoStatus(iNum);
				break;

			case 3:
				hakko.getHakkoAllStatus();
				System.out.println("終了です。");
				System.exit(0);
				break;

			default:
				common.displayNumOverErr();
				common.clearScreen();
				break;
			}
		}
	}
}
