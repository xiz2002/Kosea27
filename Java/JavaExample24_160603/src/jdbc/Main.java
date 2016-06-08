/*
package jdbc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		MemberDAOService dao = MemberDAOServiceImpl.getInstance();
		Scanner scanf = new Scanner(System.in);
		int sel = 0;

		while (true) {

			System.out.println("=======================================================");
			System.out.println("                        T E S T");
			System.out.println("=======================================================");

			System.out.println("Menu");
			System.out.println("1.등록	2.갱신	3.삭제	4.출력	5.단일출력");
			System.out.print("입력 : ");
			sel = scanf.nextInt();

			switch (sel) {
			case 1: {
				String id, pw, na, adr, ph;
				System.out.println("등록 정보를 입력하세요");
				System.out.print("ID : ");
				id = scanf.next();
				System.out.print("Pw : ");
				pw = scanf.next();
				System.out.print("Name : ");
				na = scanf.next();
				System.out.print("Address : ");
				adr = scanf.next();
				System.out.print("Phone : ");
				ph = scanf.next();
				MemberVO member = new MemberVO(id, pw, na, adr, ph);
				dao.insertMember(member);
			}
				break;
			case 2: {
				String id, pw, na, adr, ph;
				System.out.println("정보를 변경하려는 ID를 입력하세요.");
				System.out.println("ID : ");
				id = scanf.next();
				System.out.println("변경할 정보를 입력하세요");
				System.out.println("Pw : ");
				pw = scanf.next();
				System.out.println("Name : ");
				na = scanf.next();
				System.out.println("Address : ");
				adr = scanf.next();
				System.out.println("Phone : ");
				ph = scanf.next();
				MemberVO member = new MemberVO(id, pw, na, adr, ph);
				dao.updateMember(member);
			}
				break;
			case 3:
				System.out.println("삭제할 유저의 ID 를 입력하세요.");
				System.out.println("입력 : ");
				dao.deleteMember(scanf.next());
				break;
			case 4:
				ArrayList<MemberVO> member;
				member = dao.getAllMember();
				Iterator<MemberVO> itr = member.iterator();
				while(itr.hasNext()) {
					System.out.println(itr.next());
				}
				break;
			case 5 :
				System.out.println("찾을 유저의 ID를 입력하세요");
				System.out.print("입력 : ");
				MemberVO m = dao.getMember(scanf.next());
				System.out.println(m.getId() + " | " +  m.getPw() +" | " + m.getName() +" | " + m.getAddress() +" | " + m.getPhone());
				break;
			default:
				System.out.println("잘못입력하였습니다.");
					
			}
		}
	}
}
*/
