package ejercicio_1_2_3;

import ejercicio_4.modelo.Observers;

import java.util.ArrayList;
import java.util.List;
//extends
public class Medidor  extends  Observado {


    private String temperatura;
    private ClimaOnline clima;

    public Medidor(ClimaOnline clima,ArrayList<Observer> observers) {
        super(observers);
        this.clima = clima;
    }



    public void  leerTemperatura() {

        this.temperatura = this.clima.temperatura();
        notificar(temperatura);
    }

}
