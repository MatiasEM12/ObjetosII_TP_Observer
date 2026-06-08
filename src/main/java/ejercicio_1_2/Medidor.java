package ejercicio_1_2;

import java.util.ArrayList;

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
