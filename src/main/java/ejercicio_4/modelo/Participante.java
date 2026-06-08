package ejercicio_4.modelo;


import java.util.ArrayList;
import java.util.List;

public class Participante extends Observado {
    private String nombre;
    private Telefono telefono;
    private String region;
    private Email email;


    public Participante(String nombre, Telefono telefono, String region, Email email, List<Observers> observers) {
        super(observers);
        validarNombre(nombre);
        validarRegion(region);

        this.email=email;
        this.nombre = nombre;
        this.telefono = telefono;
        this.region = region;


        notificar(this.email.email());
    }
    private void validarNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new RuntimeException("Debe cargar un nombre");
        }
    }



    private void validarRegion(String region) {
        if (!region.equals("China") && !region.equals("US") && !region.equals("Europa")) {
            throw new RuntimeException("Region desconocida");
        }
    }

    public String nombre() { return nombre; }
    public String telefono() { return telefono.numero(); }
    public String region() { return region; }
    public String email(){return email.email();}

}