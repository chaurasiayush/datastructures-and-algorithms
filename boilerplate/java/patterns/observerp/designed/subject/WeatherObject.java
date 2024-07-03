package patterns.observerp.designed.subject;

import java.util.ArrayList;
import java.util.List;

import patterns.observerp.designed.observer.Observer;

public class WeatherObject implements Subject{

    float temperature;
    float humidity;
    float pressure;
    List<Observer> observers;

    

    public WeatherObject() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void addSubscription(Observer ob) {
        this.observers.add(ob);
    }

    @Override
    public void notifyObservers() {
        this.observers.forEach(ob -> ob.update());
    }
    
    @Override
    public void removeSubscription(Observer ob) {
        this.observers.remove(ob);
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    // will get called autometically when data is updated from sensors
    public void measurementsChanged(){
        this.notifyObservers();
    }

    // test method to simulate weater data update from sensors
    public void updateValues(float temp, float humid, float press){
        this.humidity = humid;
        this.temperature = temp;
        this.pressure = press;

        this.measurementsChanged();
    }
    
}
