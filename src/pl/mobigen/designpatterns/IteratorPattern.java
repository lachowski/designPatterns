package pl.mobigen.designpatterns;

public class IteratorPattern {
	
	public static void main(String[] args) {
		String[] myItemsArray = new String[] {"item1", "item2", "item3"};
		MyIterator myIterator = new MyItemsIterator(myItemsArray);
		
		while(myIterator.hasNext()) {
			System.out.println(myIterator.next());
		}	
	}
}

interface MyIterator {
	
	boolean hasNext();
	
	String next();
}

class MyItemsIterator implements MyIterator {
	String[] myItemsArray;
	int position = 0;
	
	@Override
	public String next() {
		String obj = myItemsArray[position];
		position++;
		return obj;
	}
	
	public MyItemsIterator(String[] myItemsArray) {
		this.myItemsArray = myItemsArray;
	}
	
	@Override
	public boolean hasNext() {
		if(position < myItemsArray.length) {
			return true;
		} else {
			return false;
		}
	}


}