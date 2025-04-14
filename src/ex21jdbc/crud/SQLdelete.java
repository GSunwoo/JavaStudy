package ex21jdbc.crud;

import java.sql.SQLException;

public class SQLdelete extends MyConnection {
	
	public SQLdelete(String user, String pass) {
		super(user, pass);
	}
	
	String query;
	int result;
	
	@Override
	public void dbExecute() {
		try {
			
			stmt = con.createStatement();
			query = "DELETE FROM member WHERE id = 'test1'";
			result = stmt.executeUpdate(query);
			System.out.println("[stmt] " + result + " 행 삭제됨");
			
			//////////////////////////////////////////////////////////////
			
			// 인파라미터가 있는 동적 쿼리문 작성
			query = "DELETE FROM member WHERE id = ?";
			psmt = con.prepareStatement(query);
			// 쿼리문의 인파라미터를 입력값을 통해 설정함.
			psmt.setString(1, inputValue("삭제할 아이디"));
			result = psmt.executeUpdate();
			System.out.println("[psmt] " + result + " 행 삭제됨");
		} catch (SQLException e) {
			System.out.println("쿼리실행 중 예외발생");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new SQLdelete("education","1234").dbExecute();
	}

}
