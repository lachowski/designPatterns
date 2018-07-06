package pl.mobigen.designpatterns;

public class DecoratorPattern {
	public static void main(String[] args) {
		Pizza pizza = new Mozarella(new PlainPizza());
		System.out.println(pizza.getDescription() + " price: " + pizza.getCost());
	}
}

interface Pizza {
	int getCost();
	String getDescription();
}

class PlainPizza implements Pizza {
	public int getCost() {
		return 1;
	}

	public String getDescription() {
		return "Plain pizza";
	}
}

abstract class ToppingDecorator implements Pizza {
	protected Pizza base;
	public ToppingDecorator(Pizza base) {
		this.base = base;
	}
}

class Mozarella extends ToppingDecorator {
	public Mozarella(Pizza base) {
		super(base);
	}

	@Override
	public int getCost() {
		return base.getCost() + 2;
	}

	@Override
	public String getDescription() {
		return base.getDescription() + ", with Mozarella";
	}
}