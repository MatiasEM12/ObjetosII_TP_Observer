package ejercicio_4.vista;



import ejercicio_4.modelo.GestorParticipante;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;



public class AgregarParticipante extends JFrame {

    private JTextField nombre;
    private JTextField telefono;
    private JTextField region;
    private JTextField email;
    GestorParticipante gestorParticipante;

    public AgregarParticipante(GestorParticipante gestorParticipante) throws SQLException {
        setupUIComponents();
        this.gestorParticipante=gestorParticipante;
    }

    private void setupUIComponents() {
        setTitle("Add Participant");
        setSize(700, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.nombre = new JTextField(15);
        this.telefono = new JTextField(15);
        this.region = new JTextField(15);
        this.email=new JTextField(15);
        this.nombre.setText("");
        this.telefono.setText("");
        this.region.setText("China");
        this.email.setText("test@mailtrap.io");
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new FlowLayout());
        contentPane.add(new JLabel("Nombre: "));
        contentPane.add(nombre);
        contentPane.add(new JLabel("Telefono: "));
        contentPane.add(telefono);
        contentPane.add(new JLabel("Region: "));
        contentPane.add(region);
        contentPane.add(new JLabel("Email: "));
        contentPane.add(email);
        JButton botonCargar = new JButton("Cargar");
        botonCargar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onBotonCargar();
            }
        });
        contentPane.add(botonCargar);
        setContentPane(contentPane);
        contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pack();
        setVisible(true);
    }

    private void onBotonCargar() {
        try {


            gestorParticipante.guardarParticipante( nombre.getText(), telefono.getText(), region.getText(),email.getText());
            dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

}
