package ejercicio_1_y_2;

public class DecoradorLog extends DecoradorClima{
    public DecoradorLog(ClimaOnline clima) {
        super(clima);
    }


    public void NotificarLog() {

        double temp = Double.parseDouble(this.temperatura().replace(" c", ""));

        if (temp < 12) {
            System.out.println("Hace frio, se encenderá la caldera");
        } else if (temp > 17) {
            System.out.println("Hace calor, se encenderá el aire acondicionado");
        } else {
            System.out.println("Temperatura agradable");
        }
    }
}
