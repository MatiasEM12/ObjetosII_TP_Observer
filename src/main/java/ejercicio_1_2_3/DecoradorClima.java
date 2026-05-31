package ejercicio_1_2_3;

public abstract class DecoradorClima  implements ClimaOnline{

    protected ClimaOnline clima;

    public  DecoradorClima (ClimaOnline clima) {
        this.clima = clima;
    }

    public String temperatura(){
        return clima.temperatura();
    }

}
