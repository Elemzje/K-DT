
public class Place {
	String name;
	String location;
	String phoneNumber;
	Person owner;
	Item useFor;
	
	public Place() {
		// TODO Auto-generated constructor stub
	}

	public Place(String name, String location, String phoneNumber, Person owner, Item whereBuy) {
		super();
		this.name = name;
		this.location = location;
		this.phoneNumber = phoneNumber;
		this.owner = owner;
		this.useFor = whereBuy;
	}
	
	public void printInfo() {
		System.out.println(name);
		System.out.println(location);
		if (!(phoneNumber == null)) {
			System.out.println(phoneNumber);
		}
		if (!(owner == null)) {
			owner.printInfo();
		}
		if (!(useFor == null)) {
			useFor.printInfo();
		}
	}
}
