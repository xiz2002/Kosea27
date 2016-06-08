package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface MemberDAOService {
	
	// DB 연결 (Connection)
	Connection getConnection() throws ClassNotFoundException, Exception;
	
	// Create A Record (Tuple)
	void insertMember(MemberVO member) throws SQLException, Exception; // VO 자체를 대입한다.
	
	// Update A Record (전체업데이트)
	void updateMember(MemberVO member) throws SQLException, Exception; 
	
	// 부분 업데이트
	//void updateMember(MemberVO member) throws SQLException, Exception;
	
	// Read All Records
	// MemberVO[] getAllMember();
	ArrayList<MemberVO> getAllMember() throws SQLException, Exception;
	
	// Read A Record
	MemberVO getMember(String id) throws SQLException, Exception;
	
	// Delete A Record
	void deleteMember(String id) throws SQLException, Exception;
}
