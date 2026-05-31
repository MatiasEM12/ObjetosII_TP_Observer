package ejercicio_1_y_2;

public class DecoradorLog extends DecoradorClima{
    public DecoradorLog(ClimaOnline clima) {
        super(clima);
    }

    @Override
    public String temperatura(){
        System.out.println("Consultando temperatura");
        return super.temperatura();
    }
}
