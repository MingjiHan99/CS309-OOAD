public class WeatherBoard implements DisplayElement, Observer{
    private float temperature;
    private float humidity;
    private float pressure;
    private Subject weatherData;

    public WeatherBoard(Subject weatherData){
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    public void update(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.display();
    }

    @Override
    public void display(){
        System.out.println("Current weather : \n" + 
                            "Temperature : " + this.temperature + "\n" + 
                            "Pressure : " + this.pressure + "\n" +
                            "Humidity : " + this.humidity + " \n");
    }


    public static void main(String []args){
        WeatherData weather = new WeatherData();
        Observer observer = new WeatherBoard(weather);
        Observer anotherObserver = new WeatherBoard(weather);
        weather.setMeasurements(114115.0f,114115.0f,115114.0f);
        weather.setMeasurements(2333.0f,2333.0f,2333.0f);
    }
}