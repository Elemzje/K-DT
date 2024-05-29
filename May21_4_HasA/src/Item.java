
public class Item {
	String name;
	int price;
	Menu useFor;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Item(String name, int price, Menu useFor) {
		super();
		this.name = name;
		this.price = price;
		this.useFor = useFor;
	}
	
	public void printInfo() {
		System.out.println(name);
		System.out.println(price + "원");
	}
}
