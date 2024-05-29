
public class Soldier extends Person {
	String military;
	String rank;
	
	public Soldier() {
		// TODO Auto-generated constructor stub
	}

	public Soldier(String name, int age, String military, String rank) {
		super(name, age);
		this.military = military;
		this.rank = rank;
	}
	
	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
		System.out.println(military);
		System.out.println(rank);
	}
}
