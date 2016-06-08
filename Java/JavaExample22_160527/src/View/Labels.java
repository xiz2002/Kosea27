package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

import jdbc.MemberVO;

public class Labels {
	private Label mLblIndex, mLblId, mLblPw, mLblName, mLblAddress, mLblPhone;
	private BorderPanel mPnlIndex, mPnlId, mPnlPw, mPnlName, mPnlAddress, mPnlPhone;
	private Panel mPnlTop, mPnlSub;

	// public Labels(String strIndex, String strId, String strPw,
	// String strName, String strAddress, String strPhone) {
	// public Labels(ArrayList<MemberVO> member) {

	Labels(int i, MemberVO memberVO) {
		
		mLblIndex= new Label("  "+Integer.toString((i+1))+"  ", Label.CENTER);
		mLblId = new Label(memberVO.getId(), Label.CENTER);
		mLblPw = new Label(memberVO.getPw().replaceAll("\\w", "*"), Label.CENTER);
		mLblName = new Label(memberVO.getName(), Label.CENTER);
		mLblAddress = new Label(memberVO.getAddress(), Label.CENTER);
		mLblPhone = new Label(memberVO.getPhone(), Label.CENTER);

		mPnlIndex = new BorderPanel(50, 50);
		mPnlId = new BorderPanel(100, 50);
		mPnlPw = new BorderPanel(100, 50);
		mPnlName = new BorderPanel(100, 50);
		mPnlAddress = new BorderPanel(550, 50);
		mPnlPhone = new BorderPanel(100, 50);

		mPnlIndex.add(mLblIndex);
		mPnlId.add(mLblId);
		mPnlPw.add(mLblPw);
		mPnlName.add(mLblName);
		mPnlAddress.add(mLblAddress);
		mPnlPhone.add(mLblPhone);

		mPnlSub = new Panel();
		mPnlSub.setSize(1000, 50);
		mPnlSub.setBackground(Color.WHITE);
		mPnlSub.setLayout(new GridLayout(1, 5));
		// titlePnl.add(indexPnl);
		mPnlSub.add(mPnlId);
		mPnlSub.add(mPnlPw);
		mPnlSub.add(mPnlName);
		mPnlSub.add(mPnlAddress);
		mPnlSub.add(mPnlPhone);

		mPnlTop = new BorderPanel();
		mPnlTop.setLayout(new BorderLayout());
		mPnlTop.setBackground(Color.WHITE);
		mPnlTop.add(mPnlIndex,"West");
		mPnlTop.add(mPnlSub,"Center");
	}

	public Panel getPanel() {
		return mPnlTop;
	}
}
