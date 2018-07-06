
public class Student {
	private String name;
	private int age;

	public static String nickName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age < 200 && age > 10) {
			this.age = age;
		}
	}

	public Student() {

	}

	public Student(String name) {
		this.name = name;

		test();
	}

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Student(int age) {
		this.age = age;
	}

	private void test() {
		name = "";
	}

	private static void test1() {
		nickName = "";
	}
}
