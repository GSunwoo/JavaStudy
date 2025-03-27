package ex11static;

class MyStatic {
	
	int instanceVar;
	static int staticVar;
	
	void instanceMethod() {
		System.out.println("instanceVar="+ instanceVar);
		System.out.println("staticVar="+ staticVar);
		staticMethod();
	}
	static void staticMethod() {
		//System.out.println("instanceVat="+ instanceVar);
		System.out.println("staticVar="+ staticVar);
		//instanceMethod();
	}
}

public class E01StaticModifier {

	public static void main(String[] args) {
		
		MyStatic myStatic = new MyStatic();
		myStatic.instanceVar = 100;
		System.out.println("mystatic.instanceVar="+ myStatic.instanceVar);
		
		myStatic.staticVar = 200;
		System.out.println("Mystatic.staticVar="+ MyStatic.staticVar);
		
		myStatic.staticVar = 300;
		System.out.println("mystatic.staticVar="+ myStatic.staticVar);
		
		////////////////////////////////////////////////////////
		
		MyStatic ms1 = new MyStatic();
		MyStatic ms2 = new MyStatic();
		
		ms1.instanceVar = 100;
		ms2.instanceVar = 1000;
		System.out.println("ms1.instanceVar="+ ms1.instanceVar);//100
		System.out.println("ms1.instanceVar="+ ms2.instanceVar);//1000
		
		ms1.staticVar = 800;
		ms2.staticVar = 900;
		System.out.println("ms1.staticVar="+ ms1.staticVar);//900
		System.out.println("ms1.staticVar="+ ms2.staticVar);//900
		
		myStatic.instanceMethod();
		myStatic.staticMethod();
		
		//MyStatic.instanceMethod();
		MyStatic.staticMethod();
	}
}
