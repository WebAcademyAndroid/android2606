
public class Circle extends BaseShape {

	private int mRadius;

	public Circle(int radius) {
		mRadius = radius;
		type = ShapeType.Circle;
	}

	@Override
	public double calculate() {
		return 3.14 * mRadius * mRadius;
	}
	
	public void test() {
		
	}
}
