package com.ldh.tps;

public class ErrorImpl implements Common {

	private String ERROR_NUMBER_OVER = "正しい番を入力して下さい。";
	
	public void displayNumOverErr() {
		System.out.println(ERROR_NUMBER_OVER);
	}

	@Override
	public void clearScreen() {
	}

	@Override
	public int getIntegerAbsValue() {
		return 0;
	}

	@Override
	public String getStringValue() {
		return null;
	}

	@Override
	public int getIntegerArrayValue() {
		return 0;
	}
}
