package ex21jdbc.crud.shopping;

import java.sql.SQLException;
import java.sql.Types;

import ex21jdbc.crud.MyConnection;

public class DeleteShop extends MyConnection {
	
	public DeleteShop() {
		super("education", "1234");
	}
	
	@Override
	public void dbExecute() {
		try {
			
			csmt = con.prepareCall("{call ShopDeleteGoods(?,?)}");
			//인파라미터 설정 : 사용자로부터 입력받은 값을 세팅 
			csmt.setString(1, inputValue("삭제할 상품일련번호"));

			//아웃파라미터 설정 : 반환값에 대한 자료형만 설정하면 된다. 
			csmt.registerOutParameter(2, Types.NUMERIC);
			//프로시저 실행
			csmt.execute();
			//out파라미터에 할당된 값을 읽어 결과를 출력한다. 
			int affected = csmt.getInt(2);
			if(affected==0) 
				System.out.println("오류발생:삭제실패");
			else 
				System.out.println(affected +"행 입력성공");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			dbClose();
		}
	}
 
	public static void main(String[] args) {
		new DeleteShop().dbExecute();
	}
}
