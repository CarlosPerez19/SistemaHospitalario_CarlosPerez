package Hospital;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Buscar_pacientes {
    private JTextField cedula;
    private JButton buscar;
    public JPanel mainPanel;

    String url = "jdbc:mysql://localhost:3306/sistema_hospitalario";
    String user = "root";
    String password = "123456";
    String sql = "SELECT * FROM PACIENTE WHERE cedula = ?";

    public Buscar_pacientes() {
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (cedula.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Por favor, llene todos los campos.");
                    return;
                } else if (cedula.getText().length() != 10) {
                    JOptionPane.showMessageDialog(null, "Ingrese un numero de placa validos");
                    return;
                }

                try {
                    Connection conexion = DriverManager.getConnection(url, user, password);
                    PreparedStatement statement = conexion.prepareStatement(sql);
                    statement.setString(1, cedula.getText());
                    ResultSet rs = statement.executeQuery();

                    if (rs.next()) {
                        String historial = rs.getString("n_historial_clinico");
                        String nombre = rs.getString("nombre");
                        String apellido = rs.getString("apellido");
                        String telefono = rs.getString("telefono");
                        String edad = rs.getString("edad");
                        String descripcion = rs.getString("descripcion_enfermedad");



                        JOptionPane.showMessageDialog(null, "Paciente Encontrado \n" + "Historial: " + historial + "\n" + "Nombre: " + nombre + "\n" + "Apellido: " + apellido + "\n" + "Telefono: " + telefono + "\n" + "Edad: " + edad + "\n" + "Descripcion: " + descripcion);
                    } else {
                        JOptionPane.showMessageDialog(null, "Paciente no registrado");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
