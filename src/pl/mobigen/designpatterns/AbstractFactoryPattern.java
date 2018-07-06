/**
 * Description: A factory of factories; a factory that groups the individual but related/dependent factories together without
 * specifying their concrete classes.
 * 
 * Example: To create a kingdom we need objects with common theme. Elven kingdom needs an Elven king, 
 * Elven castle and Elven army whereas Orcish kingdom needs an Orcish king, 
 * Orcish castle and Orcish army. There is a dependency between the objects in the kingdom.
 */

package pl.mobigen.designpatterns;

public class AbstractFactoryPattern {
	public static void main(String[] args) {
		KingdomFactory elfKingdomFactory = FactoryMaker.makeFactory(KingdomType.ELF);
		// creating kingdom based on factory implementation
		Castle castle = elfKingdomFactory.createCastle();
		King king = elfKingdomFactory.createKing();
		Army army = elfKingdomFactory.createArmy();
		System.out.println(castle.getDescription() + " " + king.getDescription() + " " + army.getDescription());
		
		// and create orc kingdom factory to creates kingdom elements related to orcs
		KingdomFactory orcKingdomFactory = FactoryMaker.makeFactory(KingdomType.ORC);
		// ...
	}
}

enum KingdomType {ELF, ORC}

//Creating factory for different kingdom factories, ... factory that creates factories
class FactoryMaker {
	static KingdomFactory makeFactory(KingdomType kingdomType) {
		if(kingdomType == KingdomType.ELF) {
			return new ElfKingdomFactory();
		} else if(kingdomType == KingdomType.ORC) {
			throw new UnsupportedOperationException();
		} else {
			throw new IllegalArgumentException("KingdomType not supported.");
		}
	}
}

interface Castle {
	String getDescription();
}

interface King {
	String getDescription();
}
interface Army {
	String getDescription();
}

// Elven implementation
class ElfCastle implements Castle {
	public String getDescription() {
		return "This is Elven castle";
	}
}

class ElfKing implements King {
	public String getDescription() {
		return "This is Elven king";
	}
}

class ElfArmy implements Army {
	public String getDescription() {
		return "This is Elven Army"; 
	}
}

// The same with Orcs ...

interface KingdomFactory {
	Castle createCastle();
	King createKing();
	Army createArmy();
}

class ElfKingdomFactory implements KingdomFactory {
	public Castle createCastle() {
		return new ElfCastle();
	}

	public King createKing() {
		return new ElfKing();
	}

	public Army createArmy() {
		return new ElfArmy();
	}
}

// The same with OrcKingdomFactory ...
