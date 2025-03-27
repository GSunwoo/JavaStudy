package common;

public class Teacher extends Person{
	private String subject;

	public Teacher(String name, int age, String subject) {
		super(name, age);
		this.subject = subject;
	}
	
	@Override
	public String toString() {
		return super.toString()+", 과목:"+subject;
	}
}
