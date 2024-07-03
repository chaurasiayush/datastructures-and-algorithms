package patterns.observerp.undesiged;
class WeatherData {
    float temperature;
    float humidity;
    float pressure;

    public float getTemperature() {
        return temperature;
    }
    public float getHumidity() {
        return humidity;
    }
    public float getPressure() {
        return pressure;
    }

    // this will get called autometically whenever measurements changes
    public void measurementsChanged(){

        float temp = this.getTemperature();
        float humidity = this.getHumidity();
        float pressure = this.getPressure();

        // will update all three displays 
        // currentTemperatureDisplay.update(temp, humidity, pressure);
        // statisticsDisplay.update(temp, humidity, pressure);
        // forecaseDisplay.update(temp, humidity, pressure);

        // voilating design principles

    }
}