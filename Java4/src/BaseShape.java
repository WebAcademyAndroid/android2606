
public abstract class BaseShape implements IShape {
	public ShapeType type;
	
	public static final int CIRCLE_ID = 0;
	public static final int SQUARE_ID = 1;

	protected void printName() {
		switch (type) {
		case Circle:
			System.out.println("I am circle");
			break;
		case Square:
			System.out.println("I am square");
			break;
		}
	}

	// public abstract void test();
}
