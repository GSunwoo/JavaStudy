package skillup.project02;

import java.util.Scanner; 

public class FriendInfoHandler {
	/*
	멤버변수 : 상속관계에 있어 최상위 클래스인  Friend로 배열을
	생성한다. 클래스가 상속관계에 있다면 상위클래스 배열에
	하위클래스의 인스턴스를 저장할 수 있다. */
	private Friend[] myFriends;
	//정보 카운트용 변수 생성
	private int numOfFriend;
	
	//생성자
	public FriendInfoHandler(int num) {
		/*
		핸들러 클래스의 인스턴스를 생성할 때 데이터 저장을 위한
		Freind 타입의 배열의 인스턴스도 함께 생성한다.
		크기는 num으로 저장한다.
		 */
		myFriends = new Friend[num];
		//카운트용 변수는 0으로 초기화
		numOfFriend	= 0;
	}
	
	//연락처 정보 추가를 위한 메서드
	public void addFriend(int choice) {
		//System.out.println("addFriend 호출됨");
		//Scanner scan = new Scanner(System.in);
		//공통정보 3가지를 먼저 입력받는다.
		String iName,iPhone,iAddr,iNickname,iMajor;
		System.out.print("이름:");iName = MyFriendInfoBook.scan.nextLine();
		System.out.print("전화번호:");iPhone = MyFriendInfoBook.scan.nextLine();
		System.out.print("주소:");iAddr = MyFriendInfoBook.scan.nextLine();
		
		/*
		1,2번을 구분해서 각 인스턴스를 생성한 후저장은 부모 타입인
		Friend 배열에 저장한다. 즉 상속을 통해 타입이 다른 자식 인스턴스를
		통합적으로 관리할 수 있다. */
		if(choice==1) {
			System.out.print("별명:"); iNickname = MyFriendInfoBook.scan.nextLine();
			HighFriend high = new HighFriend(iName, iPhone, iAddr, iNickname);
			myFriends[numOfFriend++] = high;
		}
		else if(choice==2) {
			System.out.print("전공:"); iMajor = MyFriendInfoBook.scan.nextLine();
			myFriends[numOfFriend++] =
					new UnivFriend(iName, iPhone, iAddr, iMajor);
		}
		/*
		High, Univ타입의 인스턴스를 Friend타입의 배열에 추가할 때에는
		자동형변환이 일어난다. 정수를 실수타입의 변수에 저장할 대
		자동형변환이 되는것과 동일한 현상이라 생각하면 된다.
		즉High, Univ 인스턴스는 Friend 타입의 인스턴스로 
		자동형변환되어 저장된다.
		 */
		System.out.println("##친구정보 입력이 완료되었습니다##"); 
	}
	 //전체 정보 출력
	public void showAllData() {
		//
		//배열에 저장된 정보의 갯수만큼 반복
		for(int i=0 ; i<numOfFriend ; i++) {
			/*
			instanceof 연산자 : 클래스와 인스턴스 간에 상속관계가
			있는지 확인하여 true/false를 반환해주는 연산자.
			클래스간의 형변환이 가능한지 확인할 때 사용한다. 率*/
			//저장된 인스턴스가 원래 어떤 타입이었는지 확인 후 형변환
			if(myFriends[i] instanceof UnivFriend) {
				((UnivFriend)myFriends[i]).showAllData();
			}
			else if (myFriends[i] instanceof HighFriend) {
				((HighFriend)myFriends[i]).showAllData();
			}
		}
		System.out.println("##전체 정보가 출력되었습니다##");
	}
	//간략 정보 출력
	public void showSimpleData() {
		//
		/*
		저장된 인스턴스의 갯수만큼 반복해서 각 인스턴스가 원래 어떤
		타입이었는지 확인한 후 원래의 타입으로 형변환한다.
		 */
		for(int i=0 ; i<numOfFriend ; i++) {
			if(myFriends[i] instanceof UnivFriend) {
				((UnivFriend)myFriends[i]).showBasicInfo();
			}
			else if (myFriends[i] instanceof HighFriend) {
				((HighFriend)myFriends[i]).showBasicInfo();
			}
		}
		System.out.println("##간략정보가 출력되었습니다##");
	}
	public void searchInfo() {
		//
		//검색결과 저장용 변수
		boolean isFind = false;
		System.out.print("검색할 이름을 입력하세요:");
		String searchName = MyFriendInfoBook.scan.nextLine();
		
		for(int i=0 ; i<numOfFriend ; i++) {
			if(searchName.compareTo(myFriends[i].name)==0) {
				/*
				일치하는 정보를 찾았따면 자식클래스로 형변환 후
				 */
				if(myFriends[i] instanceof UnivFriend) {
					((UnivFriend)myFriends[i]).showAllData();
				}
				else if (myFriends[i] instanceof HighFriend) {
					((HighFriend)myFriends[i]).showAllData();
				}
				System.out.println("## 귀하가 요청하는 정보를 찾았습니다. ##");
				//정보를 찾았다면 true로 변경
				isFind = true;
			}
		}
		
		if(isFind==false)
			System.out.println("## 없는디?;; ##");
	}
	
	public void deleteInfo() {
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();
		//삭제할 인스턴스이 인덱스 저장용 변수
		int deleteIndex = -1;
		
		//갯수만큼 반복
		for(int i=0 ; i<numOfFriend ; i++) {
			//일치하는 이름 검색
			if(deleteName.equals(myFriends[i].name)) {
				//일치하는 정보가 있다면 null로 변경해서 삭제
				myFriends[i] = null;
				//인덱스 저장
				deleteIndex = i;
				//전체카운트 1감소
				numOfFriend--;
				//반복문 탈출
				break;
			}
		}
		
		if(deleteIndex==-1) {
			//-1을 유지한다면 삭제된 인스턴스가 없는것으로 간주
			System.out.println("##삭제된 데이터가 없습니다.##");
		}
		else {
			//삭제되었다면 해당 인덱스부터 마지막까지 반복해
			for(int i=deleteIndex ; i<numOfFriend ; i++) {
				//한 칸씩 앞으로 인스턴스를 이동시킨다.7
				myFriends[i] = myFriends[i+1];
			}
			System.out.println("##데이터("+ deleteIndex
					+"번)가 삭제되었습니다##");
		}
	}
}
