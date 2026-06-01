package ejercicio_4.modelo;


public class GestorParticipante {

    RegistroParticipante registroParticipante;

    public GestorParticipante(RegistroParticipante registro ) throws Exception {

        this.registroParticipante=registro;
    }

    public void guardarParticipante(String nombre, String telefono, String region,String email) throws Exception {
        var participante = new Participante(nombre, new Telefono(telefono), region,new Email(email));
        this.registroParticipante.guardar(participante);
    }
}