package pl.mobigen.designpatterns;

public class StrategyPattern {
	
	public static void main(String[] args) {
		Animal dog = new Dog();
		dog.tryToFly();
		
		Animal bird = new Bird();
		bird.tryToFly();
		
		dog.setFlyingType(new ItFlys());
		dog.tryToFly();
	}

}

abstract class Animal {
	Flys flyingType;
	void tryToFly() {flyingType.fly();}
	void setFlyingType(Flys newFlyingType) {flyingType = newFlyingType;}
}

interface Flys {
	void fly();
}

class CantFly implements Flys {
	public void fly() {System.out.println("It can't fly");}
}

class ItFlys implements Flys {
	public void fly() {System.out.println("It can fly");}
}

class Dog extends Animal {
	public Dog() {setFlyingType(new CantFly());}
}

class Bird extends Animal {
	public Bird() {setFlyingType(new ItFlys());}
}