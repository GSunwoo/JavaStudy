package ex11static;

class NoSingleTone {
	int instVar;
	public NoSingleTone() {}
}

class SingleTone {
	int shareVar;
	private static SingleTone single = new SingleTone();
	
	private SingleTone() {
		
	}
	public static SingleTone getInstance() {
		return single;
	}
	void print() {
		System.out.println(String.format("shareVar=%d", shareVar));
	}
}

public class E03SingleToneDesignPattern {

	public static void main(String[] args) {
		
		NoSingleTone nst1 = new NoSingleTone();
		nst1.instVar = 100;
		System.out.println("nst1="+ nst1);
		
		NoSingleTone nst2 = new NoSingleTone();
		nst2.instVar = 200;
		System.out.println("nst2="+ nst2);
		
		//SingleTone st1 = new SingleTone();
		
		SingleTone st2 = SingleTone.getInstance();
		st2.shareVar = 100;
		st2.print();
		
		SingleTone st3 = SingleTone.getInstance();
		st3.shareVar = 200;
		st3.print();
		
		System.out.println(String.format("st2의 주소:%s", st2));
		System.out.println(String.format("st3의 주소:%s", st3));
		
		System.out.println(String.format("st2의 shareVar:%d",st2.shareVar));
		System.out.println(String.format("st3의 shareVar:%d",st3.shareVar));
	}
}
