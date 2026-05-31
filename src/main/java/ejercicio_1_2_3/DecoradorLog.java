package ejercicio_1_2_3;

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
