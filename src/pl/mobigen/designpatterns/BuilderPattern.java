package pl.mobigen.designpatterns;

public class BuilderPattern {
	public static void main(String[] args) {
		Hero hero = new Hero.Builder("Some profession", "Warrior123")
			.withHairColor("white")
			.withArmor("Mega set")
			.withWeapon("Cool sword")
			.build();
		
		System.out.println(hero);
	}
}

class Hero {
	private String profession;
	private String name;
	private String hairColor;
	private String armor;
	private String weapon;
	
	private Hero(Builder builder) {
		this.profession = builder.profession;
		this.name = builder.name;
		this.hairColor = builder.hairColor;
		this.armor = builder.armor;
		this.weapon = builder.weapon;
	}
	
	public String toString() {
		return "Hero [profession=" + profession + ", name=" + name + ", hairColor=" + hairColor + ", armor=" + armor
				+ ", weapon=" + weapon + "]";
	}

	static class Builder {
		private String profession;
		private String name;
		private String hairColor;
		private String armor;
		private String weapon;
		
		public Builder(String profession, String name) {
			this.profession = profession;
			this.name = name;
		}

		public Builder withHairColor(String hairColor) {
			this.hairColor = hairColor;
			return this;
		}
		
		public Builder withArmor(String armor) {
			this.armor = armor;
			return this;
		}
		
		public Builder withWeapon(String weapon) {
			this.weapon = weapon;
			return this;
		}
		
		public Hero build() {
			return new Hero(this);
		}
	}
}
