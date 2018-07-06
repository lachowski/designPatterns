package pl.mobigen.designpatterns;

public class StrategyPattern2 {
	
	public static void main(String[] args) {
		DragonSlayer dragonSlayer = new DragonSlayer(new MeleeStrategy());
		dragonSlayer.goToBattle();
		
		dragonSlayer.changeStrategy(new SpellStrategy());
		dragonSlayer.goToBattle();
	}

}

class DragonSlayer {
	
	DragonSlayingStrategy dragonSlayingStrategy;
	
	public DragonSlayer(DragonSlayingStrategy newDragonSlayingStrategy) {
		dragonSlayingStrategy = newDragonSlayingStrategy;
	}
	
	void changeStrategy(DragonSlayingStrategy newDragonSlayingStrategy) {
		dragonSlayingStrategy = newDragonSlayingStrategy;
	}
	
	void goToBattle() {
		dragonSlayingStrategy.execute();
	}
}

interface DragonSlayingStrategy {
	void execute();
}

class MeleeStrategy implements DragonSlayingStrategy {

	public void execute() {
		System.out.println("Melee attack!");
	}
}

class SpellStrategy implements DragonSlayingStrategy {

	public void execute() {
		System.out.println("Spell attack!");
	}
}
