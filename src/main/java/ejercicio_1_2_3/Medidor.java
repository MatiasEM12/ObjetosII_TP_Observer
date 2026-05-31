package ejercicio_1_2_3;

import java.util.ArrayList;
import java.util.List;

public class Medidor {

    private List<Observer>observers = new ArrayList<>();
    private String temperatura;
    private ClimaOnline clima;

    public Medidor(ClimaOnline clima,ArrayList<Observer> observers) {
        this.clima = clima;
        this.observers=observers;
    }

    public void cargarObserver(Observer observer){
        this.observers.add(observer);
    }

    public void  leerTemperatura() {

        this.temperatura = this.clima.temperatura();
        notificarObservar(temperatura);
    }

    private void notificarObservar(String data){
        for(Observer observer : this.observers){
            observer.update(data);
        }
    }

}
