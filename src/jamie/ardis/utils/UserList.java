package jamie.ardis.utils;

import java.util.ArrayList;
import java.util.HashMap;

public class UserList {
	
	ArrayList<User> users= new ArrayList<User>();
	HashMap <String, User> dictionary = new HashMap<String, User>();
	
	public UserList(){
		//TODO hook into SqlLite database instead
		users.add(new User("Genghis Khan"));
		users.add(new User("Donnie Darko"));
		users.add(new User("Nosferatu"));
		
		createDictionary();
	}

	private void createDictionary() {
		for(User u : users)
			dictionary.put(u.getName(), u);
	}

	public ArrayList<User> getUsers() {
		return users;
	}
	
	public User getUser(String name){
		User u = dictionary.get(name);
		return u;
	}
		
}
