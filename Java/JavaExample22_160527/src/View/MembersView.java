package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import jdbc.MemberDAOServiceImpl;
import jdbc.MemberVO;

public class MembersView extends Frame {

	private static final long serialVersionUID = 1L;
	Labels[] arrlbs;
	Label lblIndex, lblId, lblPw, nameLbl, addressLbl, phoneLbl;
	BorderPanel pnlIndex, pnlId, pnlPw, pnlName, pnlAddress, pnlPhone;
	Panel pnlTop, pnlTitle,pnlMain;

	public MembersView() {

		lblIndex = new Label("번호", Label.CENTER);
		lblId = new Label("아이디", Label.CENTER);
		lblPw = new Label("패쓰워드", Label.CENTER);
		nameLbl = new Label("이 름", Label.CENTER);
		addressLbl = new Label("주 소", Label.CENTER);
		phoneLbl = new Label("연락처", Label.CENTER);

		pnlIndex = new BorderPanel(50,50);
		pnlId = new BorderPanel(100, 50);
		pnlPw = new BorderPanel(100, 50);
		pnlName = new BorderPanel(100,50);
		pnlAddress = new BorderPanel(550, 50);
		pnlPhone = new BorderPanel(100, 50);

		pnlIndex.add(lblIndex);
		pnlId.add(lblId);
		pnlPw.add(lblPw);
		pnlName.add(nameLbl);
		pnlAddress.add(addressLbl);
		pnlPhone.add(phoneLbl);

		pnlTitle = new Panel();
		pnlTitle.setSize(1000, 50);
		pnlTitle.setBackground(Color.yellow);
		pnlTitle.setLayout(new GridLayout(1, 5));
		// titlePnl.add(indexPnl);
		pnlTitle.add(pnlId);
		pnlTitle.add(pnlPw);
		pnlTitle.add(pnlName);
		pnlTitle.add(pnlAddress);
		pnlTitle.add(pnlPhone);

		pnlTop = new BorderPanel();
		pnlTop.setLayout(new BorderLayout());
		pnlTop.setBackground(Color.yellow);
		pnlTop.add(pnlIndex,"West");
		pnlTop.add(pnlTitle,"Center");

		pnlMain = new Panel();
	}

	public void startFrame() {

		this.add(pnlTop, "North");
		this.add(pnlMain, "Center");
		this.setSize(1000, 500);
		this.setVisible(true);

		this.showAllMembers();

		// 이벤트 핸들러
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().setVisible(false);
				e.getWindow().dispose();
				System.exit(0);
			}
		});
	}

	// 전체 회원 보여주기 : 20160527
	private void showAllMembers() {
		ArrayList<MemberVO> arrLMember = null;
		MemberDAOServiceImpl mDAO = MemberDAOServiceImpl.getInstance();
		arrLMember = mDAO.getAllMember();
		arrlbs = new Labels[arrLMember.size()];
		
		pnlMain.setLayout(new GridLayout(arrLMember.size(),1));
		
		for(int i = 0; i < arrlbs.length; i++){
			arrlbs[i] = new Labels(i, arrLMember.get(i));
			pnlMain.add(arrlbs[i].getPanel());
		}
		super.setVisible(true);
		
	} //
}