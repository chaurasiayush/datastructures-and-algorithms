package patterns.observerp.designed.observer;

import patterns.observerp.designed.subject.WeatherObject;

public class CurrentConditionsDisplay implements Observer, DisplayElement{
    float temperature;
    float humidity;
    WeatherObject weatherObject;

    public CurrentConditionsDisplay(WeatherObject weatherObject) {
        this.weatherObject = weatherObject;
        weatherObject.addSubscription(this);
    }

    @Override
    public void update(){
        this.temperature = weatherObject.getTemperature();
        this.humidity = weatherObject.getHumidity();
        display();
    }

    @Override
    public void display() {
        System.out.println("current conditions: teperature "+this.temperature+"C degrees and humidity "+this.humidity+"%");
    }
}
