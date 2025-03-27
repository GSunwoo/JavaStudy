package ex12inheritance;

public class Dog extends Animal {
	String dogkind;
	String name;
	
	public Dog(String species, int age, String gender, String dogkind, String name) {
		super(species, age, gender);
		this.dogkind = dogkind;
		this.name = name;
	}
	
	public void bark() {
		System.out.println("이름이 "+ name +"이고 종("+ super.getSpecies() +")이 "+
					dogkind +"인 강아지가 짖는다 왈");
	}
	public void showDog() {
		super.showAnimal();
		System.out.println("종류 : "+ dogkind);
		System.out.println("이름 : "+ name);
		
	}
}
