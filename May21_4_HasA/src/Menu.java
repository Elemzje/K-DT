
public class Menu {
	String name;
	int price;
	Place restaurant;
	
	public Menu() {
		// TODO Auto-generated constructor stub
	}

	public Menu(String name, int price, Place restaurant) {
		super();
		this.name = name;
		this.price = price;
		this.restaurant = restaurant;
	}
	
	public void printInfo() {
		System.out.println(name);
		System.out.println(price + "원");
		restaurant.printInfo();
	}
	
}
