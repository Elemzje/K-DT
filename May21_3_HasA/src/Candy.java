// Candy has a Company : 제조사
// Company has a Candy : 제품
public class Candy {
	String name;
	String taste;
	Company brand;
	
	public Candy() {
		// TODO Auto-generated constructor stub
	}

	public Candy(String name, String taste) {
		super();
		this.name = name;
		this.taste = taste;
	}
	
	public void printInfo() {
		System.out.println(name);
		System.out.println(taste);
	}
}
