package ejercicio_1_2_3;

import ejercicio_4.modelo.Observers;

import java.util.ArrayList;
import java.util.List;

public class Medidor  implements Observado {

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
        notificar(temperatura);
    }


    @Override
    public void notificar(String data) {
        for(Observer observer : this.observers){
            observer.update(data);
        }
    }
}
