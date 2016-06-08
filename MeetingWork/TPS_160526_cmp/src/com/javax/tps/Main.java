/**-----------------------------------------------------------------------------
Title  : 学生成績登録システム Main
Edit   : Da ho Lee (ToyBox)
E-Mail : xiz2002@gmail.com
Update : 2016-06-01 2016-06-01 오전 3:11
Log    : TPS
-----------------------------------------------------------------------------*/

package com.javax.tps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	final static int SIZE_MINUS = 1; // size 크기로 Array의 length를 알기위한 상수.

	// 학생등록
	private static void kakuseiRegister(ArrayList<Kamoku> arrlKamoku, Scanner scanf) {
		System.out.print("名前は : ");
		String strNamae = scanf.next();

		while (true) {
			System.out.println(strNamae + "さんの登録する科目は？　| ※終了は 0 番");
			System.out.print("入力　:　");
			String strKamokumei = scanf.next();

			// if(strKamokumei.equals("0")) break; // 0을 입력 받았을 경우. (단일('0')로 들어갈 시 인식. 반대로 복수('000')로 들어갈 경우 인식 불가.)
			// 트림을 통해 equals를 사용하시면 contains의 문제를 해결할수 있습니다.
			
			if (strKamokumei.contains("0"))
				break; // 0을 입력 받았을 경우. (무조건 '0' 이 포함되는 경우인식. Ex> 수업-00 도 인식한다.)

			System.out.print(strKamokumei + "点数は　: ");

			// ArrayList에 Kamoku 객체를 생성 및 속성 입력.
			arrlKamoku.add(new Kamoku());
			arrlKamoku.get(arrlKamoku.size() - SIZE_MINUS).setNamae(strNamae);
			arrlKamoku.get(arrlKamoku.size() - SIZE_MINUS).setKamokumei(strKamokumei);
			arrlKamoku.get(arrlKamoku.size() - SIZE_MINUS).setKamokuTennsuu(getIntegerValue(scanf.next()));
		}
	}

	// 등록된 학생 출력
	private static void kakuseiDisplay(ArrayList<Kamoku> arrlKamoku) {
		List<String> arrlNamae = new ArrayList<String>();
		System.out.println("\n登録内容");
		for (int i = 0; i < arrlKamoku.size(); i++) {
			System.out.println(arrlKamoku.get(i).getNamae() + "さん," + arrlKamoku.get(i).getKamokumei() + "の点数" + arrlKamoku.get(i).getKamokuTennsuu());
			arrlNamae.add(arrlKamoku.get(i).getNamae());
		}

		arrlNamae = uniqueList(arrlNamae);

		for (int i = 0; i < arrlNamae.size(); i++) {
			String strResult = "";
			for (int j = 0; j < arrlKamoku.size(); j++) {
				if (arrlNamae.get(i).hashCode() == (arrlKamoku.get(j).getNamae().toString().hashCode()))
					strResult += ", " + arrlKamoku.get(j).getKamokumei();
			}
			System.out.println(arrlNamae.get(i) + "さんが受けている科目は" + strResult + "　です。");
		}
	}

	// 중복제거를 위한 메소드
	private static List<String> uniqueList(List<String> items) {
		List<String> uniqueItems = new ArrayList<String>();
		if (items != null) {
			for (int i = 0; i < items.size(); i++) {
				if (!uniqueItems.contains(items.get(i))) {
					uniqueItems.add(items.get(i));
				}
			}
		}
		return uniqueItems;
	}

	// 숫자를 입력 받았는지 확인
	private static int getIntegerValue(String strTemp) {
		int iInputValue = 0;
		try {
			iInputValue = Integer.parseInt(strTemp);
		} catch (Exception e) {
			System.out.println("数字だけ入力できます。"); // 예외 발생시
		}
		return iInputValue;
	}

	public static void main(String[] args) {

		ArrayList<Kamoku> arrlKamoku = new ArrayList<Kamoku>();

		Scanner scanf = new Scanner(System.in);

		while (true) {

			System.out.println("学生成績登録システム");
			System.out.println("1　:　登録　2　:　終了");
			System.out.print("入力　:　");

			switch (getIntegerValue(scanf.next())) {
			case 1:
				kakuseiRegister(arrlKamoku, scanf);
				break;

			case 2:
				kakuseiDisplay(arrlKamoku);
				scanf.close();
				System.exit(0);
				break;

			default:
				System.out.println("もう一度入力して下さい。");
				break;
			}
		}
	}
}