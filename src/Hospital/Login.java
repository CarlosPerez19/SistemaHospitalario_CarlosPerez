package Hospital;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login {
    private JTextField usuario;
    private JPasswordField contrasenia;
    private JButton iniciarSesion;
    public JPanel mainPanel;

    String url = "jdbc:mysql://localhost:3306/sistema_hospitalario";
    String user = "root";
    String password = "123456";
    String sql = "SELECT * FROM USUARIO WHERE password = ?";

    public Login() {
        iniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (usuario.getText().isEmpty() || contrasenia.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(null, "Porfavor llenar los campos");
                    return;
                }

                try {
                    Connection conexion = DriverManager.getConnection(url, user, password);
                    PreparedStatement ps = conexion.prepareStatement(sql);
                    ps.setString(1, contrasenia.getText());
                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        String usuario =rs.getString("username");
                        String contrasenia = rs.getString("password");

                        JOptionPane.showMessageDialog(null, "Usuario Encontrado");

                        // Crear Frame
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario no encontrado");
                        JOptionPane.showMessageDialog(null, "Ingrese credenciales validas");

                    }


                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.out.println("Error de conexion");
                }
            }
        });
    }
}
