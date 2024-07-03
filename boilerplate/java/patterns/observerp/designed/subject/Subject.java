package patterns.observerp.designed.subject;

import patterns.observerp.designed.observer.Observer;

public interface Subject {
    public void notifyObservers();
    public void addSubscription(Observer ob);
    public void removeSubscription(Observer ob);
}
