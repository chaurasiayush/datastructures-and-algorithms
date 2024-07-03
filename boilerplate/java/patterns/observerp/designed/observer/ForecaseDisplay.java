package patterns.observerp.designed.observer;

import patterns.observerp.designed.subject.WeatherObject;

public class ForecaseDisplay implements Observer, DisplayElement{
    
    float humidity;
    float pressure;
    String forecast;
    WeatherObject weatherObject;

    public ForecaseDisplay(WeatherObject weatherObject){
        this.weatherObject = weatherObject;
        this.weatherObject.addSubscription(this);
    }

    @Override
    public void update(){
        this.humidity = weatherObject.getHumidity();
        this.pressure = weatherObject.getPressure();
        if(this.humidity - this.pressure > 40){
            this.forecast = "Watchout for a rainy weather";
        } else {
            this.forecast = "No rain is expected";
        }
        display();
    }

    @Override
    public void display() {
        System.out.println("weather forecast: " + this.forecast);
    }
}
