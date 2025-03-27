package ex12inheritance;

class Man{
	
	private String name;
	
	public Man() {
		System.out.println("Man클래스 디폴트 생성자 호출됨");
	}
	public Man(String name) {
		this.name = name;
		System.out.println("Man클래스 인자 생성자 호출됨");
	}
	public void tellYourName() {
		System.out.println("내 이름은 "+ name +" 입니다.");
	}
}

class BuinessMan extends Man {
	
	private String company;
	private String position;
	public BuinessMan(String name, String company){
		
	}
}

public class E01BusinessManMain {

}
