package std_observer;

import java.util.Observable;
import java.util.Observer;

public class WeatherBoard implements Observer,DisplayElement {

    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public void update(Observable o, Object arg){
        System.out.println("Updating");
        if (o instanceof WeatherData){
            this.temperature = ((WeatherData) o).getTemperature();
            this.humidity = ((WeatherData) o).getHumidity();

        }
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
        WeatherData subject = new WeatherData();
        WeatherBoard board = new WeatherBoard();
        subject.addObserver(board);
        subject.setMeasurements(1.0f,2.0f,3.0f);
        subject.notifyObservers();
    }
}
