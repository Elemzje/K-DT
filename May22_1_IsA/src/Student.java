
public class Student extends Person {
	String school;
	int grade;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int age, String school, int grade) {
		super(name, age);
		this.school = school;
		this.grade = grade;
	}
	
	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
		System.out.println(school);
		System.out.println(grade);
	}
	
	
}
