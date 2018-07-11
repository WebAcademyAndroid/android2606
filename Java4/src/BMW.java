
public class BMW extends BaseCar {

	@Override
	public void drive() {
		System.out.println("Brakes off");
		System.out.println("Gear 1");
		
		super.drive();
	}
	
}
