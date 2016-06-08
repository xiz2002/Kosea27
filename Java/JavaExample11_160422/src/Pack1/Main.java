package Pack1;

import Pack0.SubVO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubVO subVo = new SubVO();
		// member1.id = "commander"; // (x)
		// 객체 필드 초기화 (대입)
		subVo.setId("commander");
		subVo.setPw("12345");
		subVo.setName("TEST");
		subVo.setAddress("Seoul");
		
		SubVO subVo1 = new SubVO("nurse","12345","TEST2","Seoul");
		
		// id 필드(속성)의 내용 확인
		System.out.println("subVo id : " + subVo.getId());
		System.out.println("subVo1 id : " + subVo1.getId());
		
		System.out.println("subVo : " + subVo);
		System.out.println("subVo1 : " + subVo1.toString());
		
		// 비교
		System.out.println("subVo, be tween subVo1 Field Value : " + subVo.equals(subVo1));
	}
}
