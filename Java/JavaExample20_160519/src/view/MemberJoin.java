/**
 * 회원가입 프로그램 (view)
 * 
 * @author ToyMac
 * @version 1.0
 */
package view;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MemberJoin extends Frame implements ActionListener {

	// 화면 구성 컴포넌트
	private Label lblId, lblPw, lblName, lblAddr, lblPhone; // 각 표제
	private Label lblIdVal, lblPwVal, lblNameVal, lblPhoneVal; // 각 폼 검증용
	private TextField tfId, tfPw, tfName, tfAddr, tfAddrDet, tfPhone; // 각 필드
	private Button btnJoin, btnReset; // 각 버튼
	private Panel pnlInput, pnlMenu, pnlId, pnlPw, pnlName, pnlAddr, pnlAddrDet, pnlPhone; // input, Menu를 큰 틀로 만들고 나머지 요소가 구성.

	// MassageWindow(대화상자)
	Dialog msgPopup;
	Label lblMsg;
	Button btnClosePopup;

	// 생성자 -> 화면 구성 초기화
	public MemberJoin() {
		// Component/Container Initialize
		lblId = new Label("ID : ");
		lblPw = new Label("Password : ");
		lblName = new Label("Name : ");
		lblAddr = new Label("Address : ");
		lblPhone = new Label("Phone : ");
		
		lblIdVal = new Label("------");
		lblPwVal = new Label("------");
		lblNameVal = new Label("------");
		lblPhoneVal = new Label("------");

		tfId = new TextField(20); // 인자로 글자 수
		tfPw = new TextField(20);
		tfName = new TextField(50);
		tfAddr = new TextField(50);
		tfAddrDet = new TextField(50);
		tfPhone = new TextField(13);

		btnJoin = new Button("등록");
		btnReset = new Button("Reset");

		pnlInput = new Panel();
		pnlMenu = new Panel();
		pnlId = new Panel();
		pnlPw = new Panel();
		pnlName = new Panel();
		pnlAddr = new Panel();
		pnlAddrDet = new Panel();
		pnlPhone = new Panel();

		// Input Panel(Center) + Menu Panel(South)
		// pnlId.setLayout(new FlowLayout()); // 좌 ->우 / 상 -> 하
		pnlId.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
		pnlId.add(lblId);
		pnlId.add(tfId);
		pnlId.add(lblIdVal);

		// pw Field
		// pnlPw.setLayout(new FlowLayout());
		pnlPw.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
		pnlPw.add(lblPw);
		pnlPw.add(tfPw);
		pnlPw.add(lblPwVal);

		// Name Field
		// pnlName.setLayout(new FlowLayout());
		pnlName.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
		pnlName.add(lblName);
		pnlName.add(tfName);
		pnlName.add(lblNameVal);

		// Addr Field
		// pnlAddr.setLayout(new FlowLayout());
		pnlAddr.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
		pnlAddr.add(lblAddr);
		pnlAddr.add(tfAddr);

		// Addr Detail Field
		// pnlAddrDet.setLayout(new FlowLayout());
		pnlAddrDet.setLayout(new FlowLayout(FlowLayout.LEFT, 110, 10)); // Layout 위치변경
		// pnlAddrDet.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
		// pnlAddrDet.add(new Label(" ")); // 공백 넣기
		// pnlAddrDet.add(new Label(String.format("%11s", " "))); // 포맷을 이용하여 공백 넣기.
		pnlAddrDet.add(tfAddrDet);

		// Phone Field
		// pnlPhone.setLayout(new FlowLayout());
		pnlPhone.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
		pnlPhone.add(lblPhone);
		pnlPhone.add(tfPhone);
		pnlPhone.add(lblPhoneVal);

		// Input Panel set / 6 X 1
		pnlInput.setLayout(new GridLayout(6, 1)); // 6 X 1 (5R 1C)
		pnlInput.add(pnlId);
		pnlInput.add(pnlPw);
		pnlInput.add(pnlName);
		pnlInput.add(pnlAddr);
		pnlInput.add(pnlAddrDet);
		pnlInput.add(pnlPhone);

		// Menu Panel set
		pnlMenu.setLayout(new FlowLayout());
		pnlMenu.add(btnJoin);
		pnlMenu.add(btnReset);
		pnlMenu.setBackground(Color.YELLOW);

		// Frame set
		this.setLayout(new BorderLayout()); // Default Borderlayout
		this.add(pnlInput, "Center");
		this.add(pnlMenu, "South");

		this.setSize(800, 300); // FrameSize 400 X 400 (px)
		this.setVisible(true);

		// PassWord Field : 은닉 문자(echo char)
		tfPw.setEchoChar('*');

		// msgPopUp
		lblMsg = new Label("");
		btnClosePopup = new Button("창닫기");

		msgPopup = new Dialog(this, "폼점검 메세지"); // MemberJoin(Child) : Frame(Parent)
		msgPopup.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 1));
		msgPopup.setBackground(Color.LIGHT_GRAY);
		msgPopup.setSize(200, 80);
		msgPopup.setResizable(false);
		msgPopup.setVisible(false);
		msgPopup.setLocation(100,100);
		msgPopup.add(lblMsg); // 가변 정보
		msgPopup.add(btnClosePopup); // 고정 정보

		// Form Validation
		// 이름 ~ 상세 주소 폼 점검
		// 이름 : 2 ~ 50
		// 주소 : 1 ~ 200 (상제 주소) 1~100

		// id Field From 점검 / 유횽성 검사 (Form Validation)
		// 8 ~ 20자 허용
		// 익명 클래스형식
		tfId.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				int iLen = tfId.getText().length(); // Id 필드에 입력된 값의 길이.
				if (iLen > 20 || iLen < 8) {
					lblIdVal.setText("000000");
				}
			}
		});

		// Windows Close Event
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				e.getWindow().setVisible(false); // 화면에서 내린다. Graphic Memory free
				e.getWindow().dispose(); // dispose : 메모리에서 삭제.
				System.exit(0); // 0 : 정상 종료
			}
		});

		// Registry Event
		btnJoin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PrintErrMsg(tfId, "TEST");
				// VO(DTO)/DAO
				// Singleton 객체 작성
				// memberVo 객체 작성 -> 컴포넌트 입력
				// member.setId(idFld.getText.tri())
				// 주소 성분 = 기본 주소 + "*" + 상세 주소 
				// insertMember : 예외 처리 -> try ~ catch
			}
		});
		
		// PopupMassage Event
		msgPopup.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				msgPopup.setVisible(false);
			}
		});
		
		// PopupButton Event
		btnClosePopup.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				msgPopup.setVisible(false);
			}
		});
	}

	/**
	 * @javadoc
	 * Since 2016. 05. 23
	 * 
	 * @param tf
	 *            입력 컴포넌트
	 * @param s
	 *            표시할 에러 메세지.
	 */

	private void PrintErrMsg(TextField tf, String s) {
		PrintErrMsg(tf, s, 300, 70);
	}

	private void PrintErrMsg(TextField tf, String s, int x, int y) {
		msgPopup.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 1));
		msgPopup.setBackground(Color.LIGHT_GRAY);
		msgPopup.setSize(200, 80);
		msgPopup.setResizable(false);
		msgPopup.setVisible(true);
		msgPopup.setLocation(100, 100);
		msgPopup.add(lblMsg);
		msgPopup.add(btnClosePopup);
		this.lblMsg.setText(s);

		tf.setText("");
	}

	private void isTfErr(TextField tf, Label lbl, String strErr) {
		if (tf.getText().length() > 20 || tf.getText().length() < 8) {
			lbl.setText(strErr);
			// PrinteErrMsg(tf, strErr);
		} else
			lblIdVal.setText("                ");
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// this.
	}

	public static void main(String[] args) {
		new MemberJoin(); // 무명인스턴스,NoName Instance;

	}
}
