package ejercicio_4.modelo;

public class Email {

    private String email;

    public Email(String email) {
        validarEmail(email);
        this.email = email;
    }

    public String email(){
        return email;
    }

    private void validarEmail(String email){
        if (email == null || email.isEmpty()) {
            throw new RuntimeException("Debe cargar un email");
        }

        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (!email.matches(regex)) {
            throw new RuntimeException("Formato de email inválido");
        }
    }
}
