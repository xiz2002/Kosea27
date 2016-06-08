package com.javax.tps;

import java.util.Random;
import java.util.Scanner;

public class Common {

	public static void clearScreen() { // ClearScreen();
		for (int i = 0; i < 30; i++) {
			System.out.println();
		}
	}

	public static int getIntegerValue() {
		@SuppressWarnings("resource")
		Scanner sInput = new Scanner(System.in);
		int iInputValue = 0;
		try {
			iInputValue = sInput.nextInt();
		} catch (Exception e) {
			System.out.println("���ڸ� �Է� �����մϴ�.");
		}
		return Math.abs(iInputValue);
	}

	public static int getRandValue(int n) { // get RandValue(int n) Overloadding
		Random iRand = new Random();
		return iRand.nextInt(n);
	}

	public static int getRandValue() { // get RandValue() Overloadding
		Random iRand = new Random();
		return iRand.nextInt(3);
	}
}
