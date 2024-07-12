package Hospital;

public class Pacientes {

    String cedula;
    int historial_clinico;
    String nombre;
    String apellido;
    String telefono;
    int edad;
    String descripcion;

    public Pacientes() {
    }

    public Pacientes(int historial_clinico, String nombre, String apellido, String telefono, int edad, String descripcion, String cedula) {
        this.historial_clinico = historial_clinico;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.edad = edad;
        this.descripcion = descripcion;
        this.cedula = cedula;
    }

    public int getHistorial_clinico() {
        return historial_clinico;
    }

    public void setHistorial_clinico(int historial_clinico) {
        this.historial_clinico = historial_clinico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}
