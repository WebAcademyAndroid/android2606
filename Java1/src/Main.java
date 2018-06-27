
public class Main {

	static String mSss = "BBB";

	public static void main(String[] args) {

		/*
		 * int a = 5; System.out.println(a);
		 * 
		 * double d = 2.2; System.out.println(d);
		 * 
		 * String s = "TEXT"; System.out.println(s);
		 * 
		 * boolean b = true; System.out.println(b);
		 * 
		 * char c = '%'; System.out.println(c);
		 * 
		 * int bb; bb = 10; bb = 3; System.out.println(bb);
		 * 
		 * int cc = 4; int dd = 7; int ee = (cc + dd) / 4; System.out.println(ee + 10);
		 * 
		 * 
		 * float ff = 5/2.0f; System.out.println(ff);
		 */

		/*
		 * int gg = 5; int hh = 2; float ii = gg / (float) hh; System.out.println(ii);
		 * 
		 * System.out.println("Hello " + "World!" + (5 + 4));
		 */

		/*
		 * String s = " a b c a b c"; System.out.println(s.indexOf("b"));
		 * System.out.println(s.indexOf("b", -30));
		 * 
		 * //System.out.println(s.replace("a", "AA")); s = s.replace("a",
		 * "AA").replace("AA", "a").toUpperCase().trim().replace(" ", "");
		 * System.out.println(s);
		 */

		/*
		 * String s = "abcabc"; System.out.println(s.charAt(s.length() - 1));
		 * 
		 * System.out.println(s.substring(0, s.length()));
		 * System.out.println(s.substring(3));
		 */

		/*
		 * String email = "vasya@gmail.com";
		 * 
		 * email = email.trim(); int dog = email.indexOf("@"); String login =
		 * email.substring(0, dog);
		 * 
		 * System.out.println(login);
		 * 
		 * 
		 * //int dog = email.indexOf("@"); //int dot = email.indexOf(".", dog);
		 */

		// System.out.println(sss);
		//String sss = test("AAAAA", 1, true);
		//System.out.println(sss);
		
		
		/*int a = 5;
		float f = a;
		
		String s1 = Integer.toString(a);
		String s2 = String.valueOf(a);*/
		
		int i1 = Integer.valueOf("1");
		int i2 = Integer.parseInt("1 ".trim());
		
		Double.parseDouble("1,1".replace(",","."));
		
		int a = 1;
		System.out.println(a == 1);
	}

	public static String test(String ss, int ii, boolean bb) {
		// System.out.println("TEST");
		return ss + "TEST" + ii + bb;
	}
	
	public static String test(String ss, int ii) {
		// System.out.println("TEST");
		return ss + "TEST" + ii;
	}
	
}
