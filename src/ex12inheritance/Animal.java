package ex12inheritance;

public class Animal {
	private String species;
	int age;
	String gender;
	public String getSpecies() {
		return species;
	}
	
	
	public Animal(String species, int age, String gender) {
		this.species = species;
		this.age = age;
		this.gender = gender;
	}
	public void showAnimal() {
		System.out.println("종류 : "+ species);
		System.out.println("나이 : "+ age);
		System.out.println("성별 : "+ gender);
	}
}



