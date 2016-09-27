package com.ldh.tps;

import java.util.Scanner;

public class CommonImpl implements Common {
	
	Scanner sInput = new Scanner(System.in);
	
	@Override
	public void clearScreen() {
		for (int i = 0; i < 30; i++) {
			System.out.println();
		}
	}
	
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
	
	@Override
	public int getIntegerArrayValue() {
		int iInputValue;
		try {
			iInputValue = sInput.nextInt();
			if(iInputValue == 0) throw new Exception();
			iInputValue += -1;
		} catch (Exception e) {
			System.out.println("不適切な数");
			iInputValue = 0;
		}
		return Math.abs(iInputValue);
	}

	@Override
	public String getStringValue() {
		return sInput.next();
	}

	@Override
	public void displayNumOverErr() {
	}
	
}
