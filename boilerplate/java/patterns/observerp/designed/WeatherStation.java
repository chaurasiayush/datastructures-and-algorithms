package patterns.observerp.designed;

import patterns.observerp.designed.observer.CurrentConditionsDisplay;
import patterns.observerp.designed.observer.ForecaseDisplay;
import patterns.observerp.designed.observer.StatisiticsDisplay;
import patterns.observerp.designed.subject.WeatherObject;

public class WeatherStation {
    public static void main(String[] args) {
     
        WeatherObject weatherObject = new WeatherObject();

        // // create displays
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherObject);
        StatisiticsDisplay statisiticsDisplay = new StatisiticsDisplay(weatherObject);
        ForecaseDisplay forecaseDisplay = new ForecaseDisplay(weatherObject);
        // *
        // *
        // add as many displays as you want

        // simulate weather data update
        weatherObject.updateValues(30, 60, 29.2f);
        weatherObject.updateValues(29, 70, 29.2f);
        weatherObject.updateValues(34, 72, 29.2f);
        weatherObject.updateValues(32, 79, 29.2f);

        /*
         *  Output:
         *  current conditions: teperature 30.0C degrees and humidity 60.0%
            Statistics: Min / Max temperature 30.0C degrees / 30.0C degrees
            weather forecast: No rain is expected
            
            current conditions: teperature 29.0C degrees and humidity 70.0%
            Statistics: Min / Max temperature 29.0C degrees / 30.0C degrees
            weather forecast: Watchout for a rainy weather

            current conditions: teperature 34.0C degrees and humidity 72.0%
            Statistics: Min / Max temperature 29.0C degrees / 34.0C degrees
            weather forecast: Watchout for a rainy weather

            current conditions: teperature 32.0C degrees and humidity 79.0%
            Statistics: Min / Max temperature 29.0C degrees / 34.0C degrees
            weather forecast: Watchout for a rainy weather
         */
    }
}
