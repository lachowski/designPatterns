package pl.mobigen.designpatterns;

public class SimpleFactoryPattern {
	public static void main(String[] args) {
		int weak = 0;
		int strong = 1;		
		EnemyShip enemyShip = EnemyShipFactory.makeEnemyShip(weak);
		System.out.println(enemyShip);
		enemyShip = EnemyShipFactory.makeEnemyShip(strong);
		System.out.println(enemyShip);
	}
}

class EnemyShipFactory {
	static EnemyShip makeEnemyShip(int strength) {
		if(strength == 1) {
			return new UfoEnemyShip();
		} else {
			return new RocketEnemyShip();
		}
	}
}

abstract class EnemyShip {
	String name;
	int damage;
	
	public String toString() {
		return "Ship type: " + name + ", making damage: " + damage;
	}
}

class UfoEnemyShip extends EnemyShip {
	public UfoEnemyShip() {
		name = "UfoEnemyShip";
		damage = 20;
	}
}

class RocketEnemyShip extends EnemyShip {
	public RocketEnemyShip() {
		name = "RocketEnemyShip";
		damage = 5;
	}
}
