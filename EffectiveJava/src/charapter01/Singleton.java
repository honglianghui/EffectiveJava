package charapter01;

import java.io.Serializable;

public class Singleton implements Serializable {
	private transient int i;
	public static final Singleton Elvis = new Singleton();

	private Singleton() {
		i = 5;
	}

	private Object readResolve() {
		return Elvis;
	}

	public void levelTheBuilding() {
	}

	public static void main(String[] args) {
		// Singleton.Elvis
	}
}

enum Elvis {
	INSTANCE;

	public void leaveTheBuilding() {
	}
}

final class UtilityClass{
	private UtilityClass(){
		// suppress default constructor for noninstantiability
		throw new AssertionError();
	}
	//这种习惯用法也有副作用, 它使得一个类不能被子类化
}