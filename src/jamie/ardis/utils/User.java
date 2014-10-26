package jamie.ardis.utils;

public class User {
	
	private String name;
	private Measurement measurement = Measurement.Metric;
	
	public User(String name) {
		super(); // boilerplate code. Calling super() on Object is unnecessary 
		this.name = name;
	}

	public Measurement getMeasurement() {
		return measurement;
	}

	public void setMeasurement(Measurement measurement) {
		this.measurement = measurement;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
