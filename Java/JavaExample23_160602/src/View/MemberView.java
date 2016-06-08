package View;

/**
 * @author 
 * Since 2016. 05. 24
 * Awt JDBC Update
 * 
 * - 05.24
 * 		메세지로 있는지 여부 출력
 * - 05.25
 * 		Result Panel 에 각각의 항목을 추가 및 변경 버튼 추가.
 * - 05.25
 * 		수정 및 취소 버튼 기능 추가 / KeyPress 이벤트 추가.
 *
 */

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.StringTokenizer;

import javax.swing.JLabel;

import jdbc.MemberDAOService;
import jdbc.MemberDAOServiceImpl;
import jdbc.MemberVO;

public class MemberView extends Frame {

	private static final long serialVersionUID = 1L;

	//// 화면 구성 컴포넌트들 -> 멤버 필드로 구성
	// 라벨, 텍스트필드, 버튼, 다이얼로그, 패널 등
	// 전체 화면은 BorderLayout으로 "북/중앙" 방식으로 구성
	// 관련 메시지는 팝업창으로 출력할 수 있도록 다이얼로그 컴포넌트를 사용
	// 화면 컴포넌트(멤버 필드) 구성 시작
	JLabel jlbMsg;
	Label lblSearch, lblMsg, lblId, lblPw, lblName, lblAddr, lblAddrDe, lblPhone;
	TextField tfSearch, tfId, tfPw, tfName, tfAddr, tfAddrDe, tfPhone;
	Panel pnlSearch, pnlResult, pnlId, pnlPw, pnlName, pnlAddr, pnlAddrDe, pnlPhone, pnlButton, pnlMsgLabel, pnlMsgButton;
	Button btnSearch, btnMsg;
	Dialog diaMsg;

	private MemberVO member = null;
	private MemberDAOServiceImpl dao = null;
	// 화면 컴포넌트(멤버 필드) 구성 끝

	public MemberView() {
		lblSearch = new Label("검색 아이디 : ");

		tfSearch = new TextField("검색 아이디를 입력하십시오", 30);

		pnlSearch = new Panel();
		pnlSearch.setBackground(Color.YELLOW);

		pnlResult = new Panel();
		pnlResult.setLayout(new GridLayout(8, 1)); // 6 X 1 (5R 1C)
		pnlResult.setBackground(Color.WHITE);

		btnSearch = new Button("검색");
		btnMsg = new Button("확인");

		diaMsg = new Dialog(this, "INFO.");
		diaMsg.setVisible(false);
	}

	public void startFrame() {

		this.setLayout(new BorderLayout());
		// 이벤트 처리(핸들러)

		//// 검색 입력 필드 이벤트 처리
		// 검색 입력란을 클릭시
		// 기존 필드값(검색 아이디....하십시오) 삭제 -> 입력 가능 상태로 설정
		// 검색 입력 필드 이벤트 처리 시작
		tfSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfSearch.setText("");
			}
		});

		//// 검색 버튼 이벤트 처리
		// 검색어 유효성 검사(validation) : 공백 여부, 초기값(검색 아이디....) 존재 여부
		// DAO select 관련 메소드를 활용하여 입력 아이디 존재 여부 확인 -> 메시지창으로 출력
		// 검색 버튼 이벤트 처리 시작
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (0 > tfSearch.getText().length()) {
					printMsgInfo("검색할 ID 를 입력하세요.");
				} else {
					dao = MemberDAOServiceImpl.getInstance();
					member = dao.getMember(tfSearch.getText().trim());
					if (member != null) {
						printMsgInfo("사용자가 존재합니다.");
						showUpdateComponents(member);
					} else {
						printMsgInfo("사용자가 존재하지 않습니다.");
					}
				}
			}
		});
		//// 검색 필드 엔터(Enter)키 및 키입력 관련 이벤트 핸들러 추가 : 20160526
		tfSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (tfSearch.getText().equals("검색 아이디를 입력하십시오")) {
					tfSearch.setText(""); // 검색어(아이디) 입력 필드 초기화
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// Enter Key(LineFeed) : 개행(줄바꿈)
				if (e.getKeyCode() == 10) {
					String idFldVal = tfSearch.getText().trim();
					if (idFldVal.equals("") || idFldVal.equals("검색 아이디를 입력하십시오")) {
						printMsgInfo("검색어를 다시 입력하시오.");
					} else { // 유효한 검색어 입력시...
						MemberDAOService dao = MemberDAOServiceImpl.getInstance();
						MemberVO member = null;
						try {
							member = dao.getMember(idFldVal);
							if (member != null) { // 아이디 존재시...
								System.out.println(member);
								// 메시지 팝업창 출력
								printMsgInfo("검색한 아이디가 존재합니다.");
								// 수정할 회원 정보 컴포넌트들 배치 : 20160525
								showUpdateComponents(member);
							} else { // 아이디 존재하지 않을 경우...
								// 메시지 팝업창 출력
								printMsgInfo("검색한 아이디가 존재하지 않습니다");
							}
						} catch (Exception e1) {
							e1.printStackTrace();
						} // try...
					} // if...
				}
			}
		}); // 키(Key) 입력 감지 이벤트 핸들러

		//// 팝업창 확인 버튼 처리
		btnMsg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				diaMsg.setVisible(false);
			}
		});

		//// 팝업창 윈도우 핸들러 구성
		diaMsg.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				diaMsg.setVisible(false);
			}
		});
		//// 전체 화면 창닫기 버튼 이벤트 핸들러 구성 시작
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				// e.getWindow().
				System.exit(0);
			}
		});

		//// 화면 레이아웃 구성 패널 설정
		// 패널 구성(검색 패널(북) 및 메인 패널(중앙))
		// 패널 레이아웃 방식, 배경색, 크기 등등
		// 패널 구성 시작
		pnlSearch.add(lblSearch);
		pnlSearch.add(tfSearch);
		pnlSearch.add(btnSearch);

		//// 전체 화면 레이아웃(Layout) 설정
		// 패널 컴포넌트를 메인 Frame(전체화면)에 추가
		// 전체 화면 크기 설정 및 화면 보이기
		// 화면 레이아웃 설정 시작
		this.add(pnlSearch, BorderLayout.NORTH);

		this.setBackground(Color.WHITE);
		this.setSize(800, 480);
		this.setResizable(false);
		this.setVisible(true);
	}

	// 회원 정보 수정 컴포넌트들 양식 표현 : 20160525
	private void showUpdateComponents(final MemberVO member) {

		// 회원정보 수정 관련 컴포넌트들 배치
		lblId = new Label("ID : ");
		lblPw = new Label("Password : ");
		lblName = new Label("Name : ");
		lblAddr = new Label("Address : ");
		lblAddrDe = new Label("Address Detail : ");
		lblPhone = new Label("Phone");

		tfId = new TextField(20);
//		tfId.setEnabled(false);
		tfId.setEditable(false);
		tfPw = new TextField(20);
//		tfPw.setEnabled(false);
		tfPw.setEditable(false);
		tfName = new TextField(20);
//		tfName.setEnabled(false);
		tfName.setEditable(false);
		tfAddr = new TextField(50);
//		tfAddr.setEnabled(false);
		tfAddr.setEditable(false);
		tfAddrDe = new TextField(50);
//		tfAddrDe.setEnabled(false);
		tfAddrDe.setEditable(false);
		tfPhone = new TextField(14);
//		tfPhone.setEnabled(false);
		tfPhone.setEditable(false);

		pnlId = new Panel();
		pnlPw = new Panel();
		pnlName = new Panel();
		pnlAddr = new Panel();
		pnlAddrDe = new Panel();
		pnlPhone = new Panel();
		pnlButton = new Panel();

		// 필드 정보 보호 속성 설정 : 수정 불가 필드 설정
		tfId.setEditable(false);
		tfName.setEditable(false);

		// 기존 메인 패널 컴포넌트 정보들 삭제 : 중복 방지
		pnlId.removeAll();
		pnlPw.removeAll();
		pnlName.removeAll();
		pnlAddr.removeAll();
		pnlAddrDe.removeAll();
		pnlPhone.removeAll();
		pnlResult.removeAll();
		pnlButton.removeAll();

		// 수정 포커스 고정 : 신규 패쓰워드 필드
		// 기존 패쓰워드 필드에 고정하면 다음 필드인 신규 패쓰워드로 포커스 이동함.
		tfPw.setFocusable(true);

		// 기존 회원정보 출력
		tfId.setText(member.getId().trim());
		tfPw.setText("");
		tfName.setText(member.getName().trim());
		if (member.getAddress().trim() != null) {
			// 주소 성분 "조건" 분리 입력 : 기본 주소 * 상세주소
			// DB 주소 필드 성분에 "*" 여부에 따라 입력 차별화
			StringTokenizer strToken = new StringTokenizer(member.getAddress().trim(), "*");
			System.out.println(strToken.countTokens());
			while (strToken.hasMoreTokens()) {
				if (tfAddr.getText().isEmpty()) {
					tfAddr.setText(strToken.nextToken());
				} else {
					tfAddrDe.setText(strToken.nextToken());
				}
			}
		} else {
			tfAddr.setText("");
			tfAddrDe.setText("");
		}

		if (member.getPhone().trim() != null) {
			tfPhone.setText(member.getPhone().trim());
		} else {
			tfPhone.setText("");
		}

		//
		pnlId.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
		pnlPw.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
		pnlName.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
		pnlAddr.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
		pnlAddrDe.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
		pnlPhone.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
		pnlButton.setLayout(new FlowLayout(FlowLayout.CENTER));

		// 각 컴포넌트들을 해당 패널에 추가
		pnlId.add(lblId);
		pnlId.add(tfId);

		pnlPw.add(lblPw);
		pnlPw.add(tfPw);

		pnlName.add(lblName);
		pnlName.add(tfName);

		pnlAddr.add(lblAddr, tfAddr);
		pnlAddr.add(tfAddr);

		pnlAddrDe.add(lblAddrDe, tfAddrDe);
		pnlAddrDe.add(tfAddrDe);

		pnlPhone.add(lblPhone);
		pnlPhone.add(tfPhone);

		// 메인 패널 전체 레이아웃 설정
		pnlResult.setLayout(new GridLayout(9, 1)); // 8 X 1 (5R 1C)
		// 전체 레이아웃에 메뉴 패널 추가
		pnlResult.add(pnlId);
		pnlResult.add(pnlPw);
		pnlResult.add(pnlName);
		pnlResult.add(pnlAddr);
		pnlResult.add(pnlAddrDe);
		pnlResult.add(pnlPhone);
		pnlResult.add(pnlButton);
		pnlResult.setVisible(true);

		// Frame 재구성.
		super.add(pnlResult, BorderLayout.CENTER);
		super.setVisible(true);

	} //

	//// 팝업창 설정
	public void printMsgInfo(TextField tf, String s) {
		tf.setText("");
		printMsgInfo(s);
	}

	public void printMsgInfo(TextField tf, TextField tf2, String s) {
		tf.setText("");
		tf2.setText("");
		printMsgInfo(s);
	}

	public void printMsgInfo(String s) {
		if (jlbMsg == null)
			jlbMsg = new JLabel(s);
		else
			jlbMsg.setText(s);
		pnlMsgLabel = new Panel();
		pnlMsgButton = new Panel();
		pnlMsgLabel.removeAll();
		pnlMsgButton.removeAll();
		pnlMsgLabel.setLayout(new FlowLayout(FlowLayout.CENTER));
		pnlMsgButton.setLayout(new FlowLayout(FlowLayout.CENTER));
		pnlMsgLabel.add(jlbMsg);
		pnlMsgButton.add(btnMsg);

		diaMsg.removeAll();
		diaMsg.setLayout(new GridLayout(2, 1));
		diaMsg.setBackground(Color.LIGHT_GRAY);
		diaMsg.add(pnlMsgLabel);
		diaMsg.add(pnlMsgButton);
		diaMsg.setSize(400, 100);
		diaMsg.setResizable(true);
		diaMsg.setVisible(true);
		diaMsg.setLocation(100, 100);
	}
}