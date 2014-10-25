package jamie.ardis.utils;

public class Bmi {

	private double weight = 0;
	private double cms = 0;

	public Bmi(double weight, double height) {

		this.weight = weight;
		this.cms = height;
	}

	public double getBmi(Measurement measure) {

		double height = cms; // default 
		if (measure == Measurement.Metric)	// if metric set units to meters
			height /= 100; // cm to M

		double bmi = weight / (height * height);

		if (measure == Measurement.Imperial)
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
public String getSeverity(Measurement measure)
{
	double bmi = getBmi(measure);
	if (bmi < 15) return "Severely Underweight";
	if (bmi < 16) return "Moderately Underweight";
	if (bmi < 18) return "Mildly Underweight";
	if (bmi < 25) return "Normal Weight";
	if (bmi < 30) return "Mildly Overweight";
	if (bmi < 35) return "Moderately Overweight";
	if (bmi < 40) return "Severely Overweight";
	return "Danger Will Robinson.. Ere be dragons!";
	
}

}
