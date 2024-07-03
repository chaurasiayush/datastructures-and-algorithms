package patterns.observerp.designed.observer;

import patterns.observerp.designed.subject.WeatherObject;

public class StatisiticsDisplay implements Observer, DisplayElement {
    float minTemp = 100;
    float maxTemp = 0;
    WeatherObject weatherObject;

    public StatisiticsDisplay(WeatherObject weatherObject){
        this.weatherObject = weatherObject;
        weatherObject.addSubscription(this);
    }

    @Override
    public void update(){
        this.minTemp = Math.min(this.minTemp, weatherObject.getTemperature());
        this.maxTemp = Math.max(this.maxTemp, weatherObject.getTemperature());
        display();
    }

    @Override
    public void display() {
        System.out.println("Statistics: Min / Max temperature "+this.minTemp +"C degrees / "+this.maxTemp+"C degrees");
    }
}
