import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Main {

	public static void main(String[] args) {

		/*
		 * if (salary < 500 || salary > 2000) { System.out.println("NO!"); } else {
		 * System.out.println("YES!"); }
		 * 
		 * if (salary >= 500 && salary < 2000) { System.out.println("YES!"); } else {
		 * System.out.println("NO!"); }
		 * 
		 * int time = 3; boolean agree = (salary >= 500 && salary < 2000) || time < 10;
		 * if (agree) { System.out.println("YES!"); } else { System.out.println("NO!");
		 * }
		 */

		/*
		 * int salary = 1000;
		 * 
		 * if (!(salary < 500 || salary > 2000)) { System.out.println("NO!"); }
		 * System.out.println("NO!");
		 * 
		 * System.out.println(salary < 500 ? "NO" : salary > 2000 ? "NO" : "YES");
		 * 
		 * int a = salary < 4 ? 33 : 22; if (salary < 4) { a = 33; } else { a = 22; }
		 */

		/*
		 * int salary = 1000; switch (salary) { case 100: case 2000:
		 * System.out.println("NO!"); break; case 1000: System.out.println("YES!");
		 * break; default: System.out.println("I DONT KNOW!"); break; } if (salary ==
		 * 100 || salary == 2000) { System.out.println("NO!"); } else if (salary ==
		 * 1000) { System.out.println("YES!"); } else {
		 * System.out.println("I DONT KNOW!"); }
		 */

		// System.out.println(check(1000));

		/*
		 * int salary = 1000; int money = 0; for (int i = 0; i < 3; i++) { money +=
		 * salary; } System.out.println(money);
		 * 
		 * 
		 * int a = 0; int b = 0;
		 * 
		 * System.out.println(a++); System.out.println(++b); System.out.println(a);
		 * System.out.println(--b);
		 */

		/*
		 * int salary = 100; int count = 0; while(salary < 1000) { salary = 100;
		 * 
		 * count++; if(count > 9999999) { break; } } System.out.println(salary);
		 */

		/*
		 * int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }; for (int i = 0; i <
		 * arr.length; i++) { arr[i] = new Random().nextInt(100); } for (int i = 0; i <
		 * arr.length; i++) { System.out.print(arr[i]);
		 * 
		 * if (i < arr.length - 1) { System.out.print("-"); } }
		 */

		/*
		 * ArrayList<String> arr = new ArrayList<>(); arr.add("AAA"); arr.add(0, "BBB");
		 * arr.add("DDD"); arr.add("EEE"); arr.add("FFF");
		 * 
		 * arr.remove(1);
		 * 
		 * arr.set(0, "CCC");
		 * 
		 * System.out.println(arr.get(0)); System.out.println(arr.size());
		 * 
		 * for (int i = 0; i < arr.size(); i++) { System.out.println(arr.get(i)); }
		 * 
		 * for(String str: arr) { System.out.println(str); }
		 */

		/*
		 * ArrayList<String> arr = new ArrayList<>(); arr.add("AAA"); arr.add("BBB");
		 * arr.add("BBB"); arr.add("DDD"); arr.add("EEE"); arr.add("BBB");
		 * arr.add("FFF"); arr.add("BBB"); arr.add("GGG");
		 */

		/*
		 * for (int i = arr.size() - 1; i >=0; i--) { if(arr.get(i) == "BBB") {
		 * arr.remove(i); } }
		 */
		/*
		 * int position = test(arr); while(position >= 0) { arr.remove(position);
		 * position = test(arr); } for(String str: arr) { System.out.println(str); }
		 * 
		 * System.out.println(arr);
		 */

		/*HashMap<String, Integer> arr = new HashMap<>();
		arr.put("G", 0);
		arr.put("B", 10);
		arr.put("C", 5);
		arr.put("D", 2222);
		
		if(arr.containsKey("C")) {
			System.out.println(arr.get("C"));
		}
		for(String key: arr.keySet()) {
			System.out.println(key + ": " + arr.get(key));
		}*/
		
		String str = "q,w,e,r,t,y,u,i,o,p";
		String[] arr = str.split(",");
		
		for(String item: arr) {
			System.out.println(item);
		}
		
		String email = "vasya@mail.com";
		String[] items = email.split("@");
		if(items.length == 2) {
			System.out.println(items[0].trim());
		}
	}

	public static int test(ArrayList<String> arr) {
		for (int i = arr.size() - 1; i >= 0; i--) {
			if (arr.get(i) == "BBB") {
				return i;
			}
		}
		return -1;
	}

	/*
	 * public static String check(int salary, int[] arr) {
	 * 
	 * if (salary > 500 && salary < 2000) { return "YES"; } return "NO";
	 * 
	 * switch (salary) { case 100: return "NO"; case 1000: return "YES"; default:
	 * return "HZ"; } }
	 */

}
