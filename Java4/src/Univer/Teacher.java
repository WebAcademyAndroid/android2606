package Univer;

public class Teacher extends Person {
	public int getSalaryPerHour() {
		return 100;
	}

	public double getSalary(int hours) {
		return getSalaryPerHour() * hours;
	}
}
