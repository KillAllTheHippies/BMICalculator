package jamie.ardis.utils;

public class User {
	public User(String name) {
		super(); // boilerplate code. Calling super() on Object is unnecessary 
		this.name = name;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
