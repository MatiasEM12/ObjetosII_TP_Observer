package ejercicio_4.modelo;

import jakarta.mail.Session;

import java.util.Properties;

public class MailtrapSession implements SessionEmail{

    final String username = "7745afec1e364b";
    final String password = "58c1826c0780a7";

    public MailtrapSession() {
    }

    @Override
    public Session crearSession() {

        Properties prop = new Properties();

        prop.put("mail.smtp.host", "sandbox.smtp.mailtrap.io");
        prop.put("mail.smtp.port", "2525");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        return Session.getInstance(prop,
                new jakarta.mail.Authenticator() {
                    @Override
                    protected jakarta.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new jakarta.mail.PasswordAuthentication("username", "password");
                    }
                });
    }
}
