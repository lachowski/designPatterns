package pl.mobigen.designpatterns;

public class FactoryMethodPattern {
	public static void main(String[] args) {
		Blacksmith blacksmith = new ElfBlacksmith();
		blacksmith.manufactureWeapon(WeaponType.SPEAR);
		blacksmith.manufactureWeapon(WeaponType.AXE);
	}
}

enum WeaponType {
	SPEAR, AXE;
}

abstract class Weapon {
	String name;
	
	void attack() {
		System.out.println("Attacking with: " + name);
	}
}

class ElfWeapon extends Weapon {
	public ElfWeapon(WeaponType weaponType) {
		name = "Elvish " + weaponType;
	}
}

class OrcWeapon extends Weapon {
	public OrcWeapon(WeaponType weaponType) {
		name = "Orcish " + weaponType;
	}
}

interface Blacksmith {
	Weapon manufactureWeapon(WeaponType weaponType);
}

class ElfBlacksmith implements Blacksmith {
	public Weapon manufactureWeapon(WeaponType weaponType) {
		return new ElfWeapon(weaponType);
	}
}

class OrcBlacksmith implements Blacksmith {
	public Weapon manufactureWeapon(WeaponType weaponType) {
		return new OrcWeapon(weaponType);
	}
}
