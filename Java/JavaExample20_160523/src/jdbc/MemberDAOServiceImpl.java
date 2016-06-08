package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

/*
 * DAO(Data Access Object)
 * : DB Table / View Biz Logic 
 * : CRUD Tuple(record)
 * : MemberDAOService DAO = MemberServiceImpl.getInstance();
 * : SingleTon(독신) pattern ((design)GoF pattern)
 * : 보안(Security) -> 상속시킴(Subclass 불가) : 자료 유츌
 * 조건)
 * 1) 생성자 -> private
 * 2) 생성함수 -> getInstance()
 * 3) 정적(static) 멤버(메소드, 필드)
 */

public class MemberDAOServiceImpl implements MemberDAOService {

	private static MemberDAOServiceImpl instance = null;

	// JDBC Specs
	private final String m_url = "jdbc:oracle:thin:@10.0.2.2:1521:orcl";
	private final String m_user = "dev";
	private final String m_password = "dev";

	// Constructor
	public MemberDAOServiceImpl() {
	}

	// final을 사용하여 Overriding 불가. class 자체에 final 을 거는 경우도 있다.
	// Singleton
	public static final MemberDAOServiceImpl getInstance() {
		if (instance == null) {
			instance = new MemberDAOServiceImpl();
		}
		return instance;
	}

	// DB연결 (Connection)
	@Override
	public Connection getConnection() {
		// throws ClassNotFoundException, Exception {
		Connection conn = null;

		// JDBC Driver Load
		try {
			// Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(m_url, m_user, m_password);

		} catch (ClassNotFoundException e) {
			System.out.println("MemberDAOServiceImpl.get Connection CNFE\n"); // 표제
			e.printStackTrace();

		} catch (SQLException e) {
			System.out.println("MemberDAOServiceImpl.get Connection SQLE\n"); // 표제
			e.printStackTrace();

		} catch (Exception e) {
			System.out.println("MemberDAOServiceImpl.get Connection E\n"); // 표제
			e.printStackTrace();
		}

		return conn;
	}

	@Override
	public void insertMember(MemberVO member) { // throws SQLException,
												// Exception {
		Connection conn = null; // DB 연결
		PreparedStatement pstmt = null; // SQL 처리
		ResultSet rs = null; // 결과 집합
		String sql = "INSERT INTO MEMBER VALUES (?,?,?,?,?)"; // 주의) 와일드카드와
																// 구분자(,)사이에 공백
																// 금지.

		conn = this.getConnection(); // DB Connect

		try {
			// pstmt = conn.createStatement(); // Prepare 의 상위 객체이나 속도가 상대적으로
			// 느리며, 와일드카드 사용 불가.
			pstmt = conn.prepareStatement(sql);// prepare : 예비,준비 | Statement =
												// sql을 의미. : SQL 적재/해석
			// 와일드 카드 사용 가능, 미리 적재(속도중시). Statement를 상속받는 객체.

			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getPhone());

			// pstmt.executeUpdate(sql); // Statement의 경우 사용.
			if (pstmt.executeUpdate() > 0)
				System.out.println("성공적으로 쿼리가 수행되었습니다.");
			else
				System.out.println("쿼리 수행에 실패하였습니다.");

		} catch (SQLException e) {
			System.out.println("MemberDAOServiceImpl.insertMember SQLE\n"); // 표제
			e.printStackTrace();

		} catch (Exception e) {
			System.out.println("MemberDAOServiceImpl.insertMember E\n"); // 표제
			e.printStackTrace();

		} finally {
			this.resourceRtn(rs, pstmt, conn);
		}
	}

	@Override
	public void updateMember(MemberVO member) throws SQLException, Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "UPDATE MEMBER SET " + "PW=?," + "NAME=?," + "ADDRESS=?," + "PHONE=?" + "WHERE ID=?";

		conn = this.getConnection(); // DB Connect
		conn.setAutoCommit(false);
		// conn.setSavepoint("Before");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, member.getPw());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getAddress());
			pstmt.setString(4, member.getPhone());
			pstmt.setString(5, member.getId());

			if (pstmt.executeUpdate() > 0)
				System.out.println("성공적으로 쿼리가 수행되었습니다.");
			else
				System.out.println("쿼리 수행에 실패하였습니다.");

			conn.commit();

		} catch (SQLException e) {
			conn.rollback();
			System.out.println("MemberDAOServiceImpl.updateMember SQLE\n"); // 표제
			e.printStackTrace();

		} catch (Exception e) {
			conn.rollback();
			System.out.println("MemberDAOServiceImpl.updateMember E\n"); // 표제
			e.printStackTrace();

		} finally {
			this.resourceRtn(rs, pstmt, conn);
		}
	}

	@Override
	public ArrayList<MemberVO> getAllMember() {// throws SQLException, Exception
												// {
		ArrayList<MemberVO> arrL = new ArrayList<MemberVO>();

		Connection conn = this.getConnection();

		PreparedStatement pstmt = null;

		StringBuffer sql = new StringBuffer("SELECT * FROM MEMBER");

		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql.toString());

			rs = pstmt.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					arrL.add(new MemberVO(rs.getString("ID"), rs.getString("PW"), rs.getString("NAME"),
							rs.getString("ADDRESS"), rs.getString("PHONE")));
				}
			}
			/*
			 * // * Index while(rs.next()) { for(int i = 1; i <= 5; i++) {
			 * System.out.println(rs.getString(i)); } }
			 * 
			 * // * KeyWord while (rs.next()) { String strA = ""; strA +=
			 * rs.getString("ID") + " | "; strA += rs.getString("PW") + " | ";
			 * strA += rs.getString("NAME") + " | "; strA +=
			 * rs.getString("ADDRESS") + " | "; strA += rs.getString("PHONE") +
			 * "\n"; System.out.println(strA); }
			 */

		} catch (SQLException e) {
			System.out.println("MemberDAOServiceImpl.getAllMember SQLE\n"); // 표제
			e.printStackTrace();

		} catch (Exception e) {
			System.out.println("MemberDAOServiceImpl.getAllMember E\n"); // 표제
			e.printStackTrace();

		} finally {
			this.resourceRtn(rs, pstmt, conn);
		}

		return arrL;
	}

	@Override
	public MemberVO getMember(String id) { // throws SQLException, Exception {
		MemberVO member = null;

		Connection conn = this.getConnection();
		PreparedStatement pstmt = null;
		StringBuffer sql = new StringBuffer();
		ResultSet rs = null;

		sql.append("SELECT * FROM MEMBER ");
		sql.append("WHERE ID=?");

		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					member = new MemberVO(rs.getString("ID"), 
										  rs.getString("PW"), 
										  rs.getString("NAME"),
										  rs.getString("ADDRESS"), 
										  rs.getString("PHONE"));
				}
			}

		} catch (SQLException e) {
			System.out.println("MemberDAOServiceImpl.getMember SQLE\n"); // 표제
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("MemberDAOServiceImpl.getMember E\n"); // 표제
			e.printStackTrace();
		} finally {
			this.resourceRtn(rs, pstmt, conn);
		}
		return member;
	}

	@Override
	public void deleteMember(String id) { // throws SQLException, Exception {
		Connection conn = this.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM MEMBER ");
		sql.append("WHERE ID=?");
		// sql.append("WHERE ID='"+id+"'");

		try {
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, id);

			if (pstmt.executeUpdate() > 0)
				System.out.println("쿼리를 성공적으로 실행했습니다.");
			else
				System.out.println("쿼리 실행을 실패하였습니다.");

		} catch (SQLException e) {
			System.out.println("MemberDAOServiceImpl.deleteMember SQLE\n"); // 표제
			e.printStackTrace();

		} catch (Exception e) {
			System.out.println("MemberDAOServiceImpl.deleteMember E\n"); // 표제
			e.printStackTrace();

		} finally {
			this.resourceRtn(rs, pstmt, conn);
		}

	}

	private void resourceRtn(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (!pstmt.isClosed())
				pstmt.close();
			if (!conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			System.out.println("MemberDAOServiceImpl.get ResourceRtn SQLE\n"); // 표제
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("MemberDAOServiceImpl.get ResourceRtn E\n"); // 표제
			e.printStackTrace();
		}
	}
}
