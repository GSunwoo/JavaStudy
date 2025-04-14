package ex21jdbc.crud.shopping;

import java.sql.SQLException;

import ex21jdbc.crud.MyConnection;

public class InsertShop extends MyConnection {

	public InsertShop(String user, String pass) {
		super(user, pass);
	}
	
	String query; //쿼리문 작성
	int result; //쿼리 실행 후 결과 반환 
	
	@Override
	public void dbExecute() {
		try {
			query = "insert into sh_goods values"
					+ "(seq_total_idx.nextval,?,?,default,?)";
			
			psmt = con.prepareStatement(query);
			// 정보 입력받음
			psmt.setString(1, inputValue("상품명"));
			psmt.setString(2, inputValue("상품가격"));
			psmt.setString(3, inputValue("상품코드"));
			//쿼리문 실행 및 결과 반환 
			result = psmt.executeUpdate();
			System.out.println("[psmt]"+ result +"행 입력됨");
		
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new InsertShop("education", "1234").dbExecute();
	}
	
}
