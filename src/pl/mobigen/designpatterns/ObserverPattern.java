package pl.mobigen.designpatterns;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
	
	public static void main(String[] args) {
		Subject subject = new Subject();
		Observer observer = new SomeObserver(subject);
		subject.changeData(42);	
	}
}

class Subject {
	List<Observer> observers = new ArrayList<>();
	int data;
	
	public void changeData(int newData) {
		data = newData;
		notifyObservers();
	}
	
	public void register(Observer newObserver) {observers.add(newObserver);}
	
	public void unregister(Observer toBeRemovedObserver) {
		int index = observers.indexOf(toBeRemovedObserver);
		if(index != -1) {
			observers.remove(index);
		}
	}
	
	public void notifyObservers() {
		for(Observer observer : observers) { observer.update(this.data);}
	}
}

interface Observer {
	void update(int data);
}

class SomeObserver implements Observer {
	int data;
	
	public SomeObserver(Subject subject) {
		subject.register(this);
	}
	
	public void update(int newData) {
		System.out.println("Observer recived new data: " + newData);
		data = newData;
	}
}
