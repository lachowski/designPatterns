package pl.mobigen.designpatterns;

public class SingletonPattern {
	public static void main(String[] args) {
		EnumDarkTower darkTower1 = EnumDarkTower.INSTANCE;
		EnumDarkTower darkTower2 = EnumDarkTower.INSTANCE;
		if(darkTower1 == darkTower2)
			System.out.println("Singleton, only one instance");
	}
}

enum EnumDarkTower {
	  INSTANCE;
}