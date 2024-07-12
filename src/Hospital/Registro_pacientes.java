package Hospital;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registro_pacientes extends Pacientes {
    private JTextField historial;
    private JTextField nombre;
    private JTextField apellido;
    private JTextField telefono;
    private JTextField edad;
    private JTextField descripcion;
    private JButton registrar;
    private JButton buscar;
    private JTextField cedula;
    public JPanel mainPanel;

    String url = "jdbc:mysql://localhost:3306/sistema_hospitalario";
    String user = "root";
    String password = "123456";
    String sql = "INSERT INTO PACIENTE (cedula, n_historial_clinico, nombre, apellido, telefono, edad, descripcion_enfermedad) VALUES (?, ?, ?, ?, ?, ?, ?)";


    public Registro_pacientes() {


        registrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Pacientes paciente = new Pacientes();

                if (historial.getText().isEmpty() || nombre.getText().isEmpty() || apellido.getText().isEmpty() || telefono.getText().isEmpty() || edad.getText().isEmpty() || descripcion.getText().isEmpty() || cedula.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Llenar todos los campos");
                    return;
                } else if (cedula.getText().length() != 10) {
                    JOptionPane.showMessageDialog(null, "Cedula no valida");
                    return;
                }

                paciente.setHistorial_clinico(Integer.parseInt(historial.getText()));
                paciente.setNombre(nombre.getText());
                paciente.setApellido(apellido.getText());
                paciente.setTelefono(telefono.getText());
                paciente.setEdad(Integer.parseInt(edad.getText()));
                paciente.setDescripcion(descripcion.getText());
                paciente.setCedula(cedula.getText());

                try {
                    Connection conexion = DriverManager.getConnection(url, user, password);
                    PreparedStatement declarar = conexion.prepareStatement(sql);
                    declarar.setString (1, paciente.getCedula());
                    declarar.setInt (2, paciente.getHistorial_clinico());
                    declarar.setString (3, paciente.getNombre());
                    declarar.setString (4, paciente.getApellido());
                    declarar.setString (5, paciente.getTelefono());
                    declarar.setInt(6, paciente.getEdad());
                    declarar.setString(7, paciente.getDescripcion());
                    declarar.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Paciente registrado correctamente.");
                    conexion.close();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al registrar el Paciente." + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new Buscar_pacientes().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
