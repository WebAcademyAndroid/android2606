import Univer.Dekan;
import Univer.Person;
import Univer.Student;
import Univer.Teacher;

public class Main {

	public static void main(String[] args) {
		// Circle c = new Circle(10);
		// print(c);

		// Square s = new Square(10);
		// print(s);

		// BMW bmw = new BMW();
		// bmw.drive();

		// X7 x7 = new X7();
		// x7.drive();

		Dekan d = new Dekan();
		// Teacher t = new Teacher();
		// Student s = new Student();

		System.out.println(sendEmail(null));
		// sendEmail(t);
		// sendEmail(s);

		// System.out.println(t.getSalary(100));
		// System.out.println(d.getSalary(100));
	}

	public static String sendEmail(Person person) {
		try {
			int a = Integer.parseInt("aaa");
			// person.Email = "";
		} catch (NullPointerException ex) {
			System.out.println("null person");
			//return "1";
		} catch (Exception ex) {
			System.out.println("Sorry");
			//return "2";
		} //finally {
			System.out.println("TEXT");
			//return "3";
		//}

		return "4";
	}

	public static void print(BaseShape shape) {
		System.out.println(shape.calculate());
		shape.printName();

		if (shape instanceof Circle) {
			Circle c = (Circle) shape;
			c.test();
		}
	}

}
