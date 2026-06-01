package ejercicio_4.modelo;


import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class GestorParticipante {

    private RegistroParticipante registroParticipante;
    public static final String origen = "test@mailtrap.io";
    public GestorParticipante(RegistroParticipante registro ) throws Exception {

        this.registroParticipante=registro;
    }

    public void guardarParticipante(String nombre, String telefono, String region,String email) throws Exception {

        var participante = new Participante(nombre, new Telefono(telefono), region,new Email(email),listarObservers());
        this.registroParticipante.guardar(participante);
    }

    private ArrayList<Observers> listarObservers(){
        List<Observers> observers = new ArrayList();
        observers.add(new NotificacionEmail(origen, new MailtrapSession()));

        return (ArrayList<Observers>) observers;
    }
}