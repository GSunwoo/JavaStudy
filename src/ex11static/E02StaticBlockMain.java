package ex11static;

public class E02StaticBlockMain {
	 
	int instanceVar;
	void instanceMethod() {}
 
	static int staticVar;
	static void staticMethod() {
		int localVar;
		System.out.println("정적메소드");
	}
 
	static {
 
		staticVar = 1000;		
 
		int localVar;
		localVar = 1000;
		System.out.println("localVar="+ localVar); 
		//System.out.println("instanceVar="+ instanceVar);  
		//instanceMethod();
 
		System.out.println("staticVar="+ staticVar);
		staticMethod();
		
		System.out.println("===static block 끝===");
	}
 
	public E02StaticBlockMain() {
 
		staticVar = -1;
		System.out.println("==StaticBlock의 생성자==");
	}
	public static void main(String[] args) {
		
		System.out.println("==메인메소드==");		
	 
		//System.out.println("localVar="+ localVar);
		 
		new E02StaticBlockMain();
	}
}

