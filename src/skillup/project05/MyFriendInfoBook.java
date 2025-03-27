package skillup.project05;

import java.util.Scanner;

public class MyFriendInfoBook {
	
	public static Scanner scan = new Scanner(System.in);
	
	//[ibloc classdasoodr]
	
	/*
	메뉴출력용 메서드로 main에서 직접 호출해야 하므로
	static으로 선언되어있다. */
	public static void menuShow() {
		System.out.println("######## 메뉴를 입력하세요(ver03) #########");
		System.out.print("1. 고딩친구 입력 ");
		System.out.println("2. 대딩친구 입력 ");
		System.out.print("3. 전체정보 출력 ");
		System.out.println("4. 간략정보 출력 ");
		System.out.print("5. 검색 ");
		System.out.print("6. 삭제 ");
		System.out.println("7. 프로그램 종료 ");
		System.out.print("메뉴선택>>>");
	}
	
	public static void main(String[] args) {
		//입력을 위한 인스턴스 생성
		/*
		주소록 관리 프로그램에서 전반적인 기능을 구현하기 위한 클래스.
		이런 클래스를 보통 핸들러 혹은 매니져 클래스라고 한다. */
		FriendInfoHandler handler = new FriendInfoHandler(100);
		
		
		/*
		무한루프로 while문 작성. 프로그램을 종료할때까지 무한히
		반복하며 친구의 정보를 입력, 수정, 삭제, 검색을 하게된다. */
		while(true) {
			//제일 먼저 메뉴를 출력한다.
			menuShow();
			//메뉴 입력
			try {
				int choice = scan.nextInt();
				//입력을 위한 버퍼(Buffer) 제거
				scan.nextLine();
				//입력받은 정수에 따라 분리해서 각 기능을 실행한다.
				switch(choice) {
				case 1: case 2:
					//친구의 정보 입력(고딩 or 대딩)
					handler.addFriend(choice);
					break;
				case 3:
					//정보 전체(4가지) 출력
					handler.showAllData();
					break;
				case 4:
					//정보 간략(2가지) 출력
					handler.showSimpleData();
					break;
				case 5:
					//정보 검색
					handler.searchInfo();
					break;
				case 6:
					//정보 삭제
					handler.deleteInfo();
					break;
				case 7:
					System.out.println("프로그램 종료");
					return;
				}////switch 끝
			} catch (Exception e) {
				System.out.println("[예외발생]메뉴선택은 숫자만 입력해주세요.");
				/*
				nextInt() 사용시 문자를 입력하면 즉시 예외가 발생된다.
				이때 입력을 위한 Enter키가 버퍼에 남아 무한루프에 빠지는 경우가 있는데
				이를 제거하기 위해 nextLine()을 한번 호출해야 한다.
				 */
				scan.nextLine();
			}
		}////while 끝
	}////main 끝
}////class 끝
