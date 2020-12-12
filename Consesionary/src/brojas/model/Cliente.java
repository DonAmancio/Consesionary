package brojas.model;
public class Cliente {
    //PK
    private String nit;
    private String nombre;
    private String ciudad;
    private String direccion;
    private int telefono;

    public Cliente(){

    }

    public Cliente(String nit, String nombre, String ciudad, String direccion, int telefono) {
        this.setNit(nit);
        this.setNombre(nombre);
        this.setCiudad(ciudad);
        this.setDireccion(direccion);
        this.setTelefono(telefono);
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nit: '" + nit + '\'' +
                ", nombre: '" + nombre + '\'' +
                ", ciudad: '" + ciudad + '\'' +
                ", direccion: '" + direccion + '\'' +
                ", telefono: " + telefono +
                '}';
    }
}
