package View;

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

import javax.swing.JLabel;

import jdbc.MemberDAOServiceImpl;
import jdbc.MemberVO;

public class MemberDelete extends Frame {

	private static final long serialVersionUID = 1L;

	JLabel jlbMsg;
	Label lblSearch, lblMsg, lblId, lblPw, lblName, lblAddr, lblAddrDe, lblPhone;
	TextField tfSearch, tfId, tfPw, tfName, tfAddr, tfAddrDe, tfPhone;
	Panel pnlSearch, pnlResult, pnlId, pnlPw, pnlName, pnlAddr, pnlAddrDe, pnlPhone, pnlButton, pnlMsgLabel, pnlMsgButton;
	Button btnSearch, btnMsg;
	Dialog diaMsg;

	private MemberVO member = null;
	private MemberDAOServiceImpl dao = null;
	// 화면 컴포넌트(멤버 필드) 구성 끝

	public MemberDelete() {
		lblSearch = new Label("검색 아이디 : ");

		tfSearch = new TextField("검색 아이디를 입력하십시오", 30);

		pnlSearch = new Panel();
		pnlSearch.setBackground(Color.YELLOW);

		pnlResult = new Panel();
		pnlResult.setBackground(Color.WHITE);

		btnSearch = new Button("검색");
		btnMsg = new Button("확인");

		diaMsg = new Dialog(this, "INFO.");
		diaMsg.setVisible(false);
	}

	public void startFrame() {
		this.setLayout(new BorderLayout());

		tfSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfSearch.setText("");
			}
		});

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
						removeMemberComponents(dao, member);
					} else {
						printMsgInfo("사용자가 존재하지 않습니다.");
					}
				}
			}
		});

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
						dao = MemberDAOServiceImpl.getInstance();
						member = null;
						try {
							member = dao.getMember(idFldVal);
							if (member != null) { // 아이디 존재시...
								removeMemberComponents(dao, member);
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

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				System.exit(0);
			}
		});

		pnlSearch.add(lblSearch);
		pnlSearch.add(tfSearch);
		pnlSearch.add(btnSearch);

		this.add(pnlSearch, BorderLayout.NORTH);

		this.setBackground(Color.WHITE);
		this.setSize(800, 480);
		this.setResizable(false);
		this.setVisible(true);
	}

	private void removeMemberComponents(MemberDAOServiceImpl dao, MemberVO member) {
		dao.deleteMember(member.getId().trim());
		printMsgInfo("<html><b>회원정보가 성공적으로 삭제 되었습니다.</b></html>");
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