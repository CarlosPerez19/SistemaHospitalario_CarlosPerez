import javax.swing.*;
import Hospital.Login;
import Hospital.Registro_pacientes;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setContentPane(new Login().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}