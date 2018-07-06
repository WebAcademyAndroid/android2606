
public class Main {

	public static void main(String[] args) {
		
		Student.nickName = "ASD";
		
		Student s = new Student("Ivan", 22);
		System.out.println(s.nickName);
		s.nickName = "123";
		System.out.println(Student.nickName);

		test(s);
		System.out.println(s.getName());
		//s.test();
		
		int a = 4;
		System.out.println(a);
		test(a);
		System.out.println(a);
		
		Student[] arr = new Student[10];
		arr[0] = s;
		arr[1] = s;
		arr[2] = s;
		arr[3] = s;
		
	    int aa = 1;
	    int bb = 1;
	    if(aa == bb) {
	    	
	    }
	    
	    Student ss1 = new Student(22);
	    Student ss2 = new Student(22);
	    if(ss1.equals(ss2)) {
	    	
	    }
	    
	    String str1 = "123";
	    String str2 = "123";
	    if(str1.equals(str2)) {
	    	
	    }
	    
	    DataBase.getInstace().save();
	    DataBase.getInstace().save();
	    DataBase.getInstace().save();
	    DataBase.getInstace().save();
	}

	public static void test(Student s) {
		if (s != null) {
			s = new Student();
			s.setName("QQQQ");
		}
	}

	public static void test(int a) {
		a = 10;
	}

	

}
