package com.company;
import java.util.ArrayList;
import java.util.List;

// Interfejs Subject
interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();

    Object getState();
}

// Klasa ConcreteSubject
class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private Object state;

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
        notifyObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

// Interfejs Observer
interface Observer {
    void update();
}

// Klasa ConcreteObserver
class ConcreteObserver implements Observer {
    private Subject subject;

    public ConcreteObserver(Subject subject) {
        this.subject = subject;
    }

    public void update() {
        // Wykonaj odpowiednie akcje w przypadku zmiany stanu obiektu obserwowanego
        Object state = subject.getState();
        
    }
}

// Przykład użycia
public class Main {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        ConcreteObserver observer1 = new ConcreteObserver(subject);
        ConcreteObserver observer2 = new ConcreteObserver(subject);

        subject.attach(observer1);
        subject.attach(observer2);

        subject.setState("Nowy stan");
    }
}

