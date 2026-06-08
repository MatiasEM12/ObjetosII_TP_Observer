package ejercicio_1_2;

import java.util.ArrayList;
import java.util.List;

public abstract class Observado {

    private List<Observer>observers = new ArrayList<>();


    public Observado (List<Observer>observers){
        this.observers = observers;
    }
    public void notificar(String data){
        for(Observer observer : this.observers){
            observer.update(data);
        }
    }
}
