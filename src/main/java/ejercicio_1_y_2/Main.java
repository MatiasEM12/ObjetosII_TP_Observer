package ejercicio_1_y_2;

import java.util.ArrayList;

public class Main {

    static void main() {
        String urlService= "https://api.openweathermap.org/data/2.5/weather?q=Viedma,Argentina&units=metric&APPID" +
                "=4c59d93df32deacc02f7131d986c198e";
        ArrayList<Observer> observers = new ArrayList<>();
        observers.add(new RegistroTemperatura( "src/main/resources/temperaturas.txt"));
        observers.add(new NotificacionConsola());

        System.out.println(System.lineSeparator()+"Medidor Sin decorador"+System.lineSeparator());

        var medidor = new Medidor(new WeatherChannelService(urlService),observers);
        medidor.leerTemperatura();


        System.out.println(System.lineSeparator()+"Medidor usando Decorador"+System.lineSeparator());
        ClimaOnline clima = new DecoradorLog(new WeatherChannelService(urlService));
        var medidor2 = new Medidor(clima,observers);
        medidor2.leerTemperatura();
    }


}
