package jamie.ardis.utils;

public class Bmi {

	private double weight = 0;
	private double cms = 0;

	public Bmi(double weight, double height) {

		this.weight = weight;
		this.cms = height;
	}

	public double getBmi(Measure system) {

		double height = cms; // default 
		if (system == Measure.Metric)	// if metric set units to meters
			height /= 100; // cm to M

		double bmi = weight / (height * height);

		if (system == Measure.Imperial)
			bmi *= 703; // Conversion ratio

		return bmi;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return cms;
	}

	public void setHeight(double height) {
		this.cms = height;
	}

}
