
public class Laptop extends Computer {
	double weight;
	int batteryLife;
	
	public Laptop() {
		// TODO Auto-generated constructor stub
	}

	public Laptop(String name, int price, String cpu, int ram, int hdd, double weight, int batteryLife) {
		super(name, price, cpu, ram, hdd);
		this.weight = weight;
		this.batteryLife = batteryLife;
	}
	
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println(weight);
		System.out.println(batteryLife);
	}
}
