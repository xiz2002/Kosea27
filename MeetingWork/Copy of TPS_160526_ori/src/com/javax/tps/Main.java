package com.javax.tps;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		// 상수

		int boxnumber = 9;
		int thingsMax = 100;

		String[][] box = new String[boxnumber][thingsMax];
		int flag;
		int boxNum;
		String things;

		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println(" 番号を選んでください。");
			System.out.println("１：物を入れる。2　：物を取り出す。３：終了");
			System.out.print("入力: ");
			flag = scan.nextInt(); // 초기화 과정이 일어남.

			if (flag == 1) {
				try {
					System.out.println("引き出しの番号を入れてください。番号は０から" + (boxnumber - 1) + "まであります。");
					System.out.print("Box番号 : ");
					boxNum = scan.nextInt();
					System.out.println("物はなんですか？");
					System.out.print("이름 : ");
					things = scan.next();

					for (int i = 0, m = box[boxNum].length; i < m; i++) {
						if (box[boxNum][i] == null) {
							box[boxNum][i] = things;
							break;
						}
					}

					System.out.println("Box" + boxNum + "番に物を入れました。");
					// 적재 끝.
					if (box[boxNum][0] == null) { // 박스의 첫 칸에 아무것도 없을경우.
						System.out.println("中には何もありません。");
					} else {
						System.out.print("中には [" + box[boxNum][0]);
						for (int i = 1; i < box[boxNum].length; i++) {
							if (box[boxNum][i] == null)
								break;
							else
								System.out.print(", " + box[boxNum][i]);
						}
						System.out.println("]が あります。");
					}

				} catch (IndexOutOfBoundsException e) {
					System.out.println("올바른 상자를 선택해 주세요.");
				}
			}

			else if (flag == 2) {
				int i = 0;
				int z = 0;
				System.out.println("引き出しの番号を入れてください。番号は０から" + (boxnumber - 1) + "まであります。");
				System.out.print("Box番号 : ");
				boxNum = scan.nextInt();

				if (box[boxNum][0] == null) {
					System.out.println("中には何もありません。");
				} else {
					System.out.print("中には [" + box[boxNum][0]);

					for (i = 1; i < box[boxNum].length; i++) {
						if (box[boxNum][i] == null)
							break;
						else
							System.out.print(", " + box[boxNum][i]);
					}
					System.out.println("]が あります。");
					// 목록 출력
					System.out.println("取り出したい物を入力してください。");
					System.out.println("물건 이름 : ");
					things = scan.next();

					// for (int i = 0; i < box[boxNum].length; i++) {
					// if (box[boxNum][i] == things) {
					// box[boxNum][i] = null;
					//
					// for (int j = i + 1; j < box[boxNum].length; j++) // 전체를
					// 앞으로 땡기는 문
					// box[boxNum][j - i] = box[boxNum][j];
					// } else {
					// System.out.println("존재하지 않는 물건입니다.");
					// break;
					// }
					// }

					for (int j = 0; j < i; j++) {
						if (box[boxNum][j].equals(things)) {
							System.out.println("取られました。");
							z = j;
							for (int c = z; c < i; c++)
								box[boxNum][c] = box[boxNum][c + 1];
							i -= 1;
						}

					}
				}
			}

			else if (flag == 3) {
				// System.out.println("flag == 3");
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < box[i].length - 1; j++) {
						if (box[i][j] != null) {
							System.out.print(i + "서랍에는 " + box[i][0]);
							for (j = 1; j < box[i].length; j++) {
								if (box[i][j] == null)
									break;
								else
									System.out.print(", " + box[i][j]);
							}
							System.out.println("이 있습니다.");
						} else
							System.out.println(i + "서랍은 비어있음");
						break;
					}
				}
				System.out.println("종료");
				break;
			} else {
				System.out.println("올바른 번호를 입력해 주세요.");
			}

		}
	}
}
