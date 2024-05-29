
public class Company {
	String name;
	String place;
	int employee;
	
	public Company() {
		// TODO Auto-generated constructor stub
	}

	public Company(String name, String place, int employee) {
		super();
		this.name = name;
		this.place = place;
		this.employee = employee;
	}
	
	public void printInfo() {
		System.out.println(name);
		System.out.println(place);
		System.out.println(employee);
	}
}

