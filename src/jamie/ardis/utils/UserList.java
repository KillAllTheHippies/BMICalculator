package jamie.ardis.utils;

import java.util.ArrayList;
import java.util.HashMap;

public class UserList {
	
	ArrayList<User> users;
	HashMap <String, User> lookup;//A hashmap works like a lookup table
	
	public UserList(){
		users= new ArrayList<User>();
		lookup = new HashMap<String, User>();
		//TODO hook into SqlLite database instead
		users.add(new User("Genghis Khan"));
		users.add(new User("Donnie Darko"));
		users.add(new User("Nosferatu"));
		
		createLookupTable();
	}

	private void createLookupTable() {
		
		for(User u : users)
			//get the name (a string), and make this name the key 
			//by which the user can be looked up
			lookup.put(u.getName(), u);
	}

	public ArrayList<User> getUsers() {
		return users;
	}
	
	public User getUser(String name){
		//get a User object from the dictionary, dictionary key = name
		User u = lookup.get(name);
		return u;
	}
		
}
