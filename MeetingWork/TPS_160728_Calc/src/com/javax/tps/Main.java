package com.javax.tps;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String strQ = new String();
		Scanner scanf = new Scanner(System.in);
		int iTemp;
		char cTemp;
		
		System.out.println("식을 입력하세요.(Ex:1+2+3=)");
		strQ = scanf.next().trim();
		if(!strQ.contains("=")) {
			System.out.println("입력 오류");
			System.exit(0);
		}
		
		for (int i = 0; i < strQ.length(); i++) {
			try {
				iTemp = Integer.parseInt(strQ.substring(i));
			} catch(Exception e) {
				cTemp = strQ.charAt(i);
			} finally {
				
			}
			
		}
	}
}
