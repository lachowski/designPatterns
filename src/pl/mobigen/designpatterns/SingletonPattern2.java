package pl.mobigen.designpatterns;

public class SingletonPattern2 {

	public static void main(String[] args) {
		Singleton instance = Singleton.getInstance();
	}
}

class Singleton {
	private static Singleton uniqueInstance = null;
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}
}
