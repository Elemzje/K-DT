
public class Person {
	String name;
	String gender;
	String phoneNumber;
	String job;
	Place lovePlace;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, String gender, String phoneNumber, String job, Place lovePlace) {
		super();
		this.name = name;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.job = job;
		this.lovePlace = lovePlace;
	}
	
	public void printInfo() {
		System.out.println(name);
		if (!(gender == null)) {
			System.out.println(gender);
		}
		if (!(phoneNumber == null)) {
			System.out.println(phoneNumber);
		}
		System.out.println(job);
		if (!(lovePlace == null)) {
			lovePlace.printInfo();
		}
		
	}
	
}
