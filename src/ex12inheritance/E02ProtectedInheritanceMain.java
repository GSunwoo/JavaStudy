package ex12inheritance;

import ex12inheritance.map.Korea;

//자식클래스에서 Korea를 상속한다.
class Seoul extends Korea {
	private String city;
	public Seoul(String name, String city) {
		//부모클래스의 생성자 호출
		super(name);
		this.city = city;
	}
	
	/*
	4개의 접근지정자를 통해 정의한 메서드를 호출. 
	단 부모클래스가 다른 패키지에 선언되었으므로
	default, private멤버는 호출할 수 없다. */
	public void callMethod() {
		super.publicMethod("callMethod->");
		super.protectedMethod("callMethod->");
		//super.defaultMethod();
		//super.privateMethod();
		/*
		이와 같이 직접 접근할 수 없는 메서드는 접근 가능한 메서드를
		통해 간접 호출해야한다. 울랄라끠리리략꺆휴뵹*/
	}
}

public class E02ProtectedInheritanceMain {

	public static void main(String[] args) {
		Seoul seoul = new Seoul("대한민국", "서울");
		seoul.callMethod();
	}
}
