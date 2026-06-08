package ejercicio_4.modelo;



import java.util.ArrayList;
import java.util.List;

public abstract class Observado {

    private List<Observers> observers = new ArrayList<>();


    public Observado (List<Observers>observers){
        this.observers = observers;
    }
    public void notificar(String data){
        for(Observers observer : this.observers){
            observer.update(data);
        }
    }
}
