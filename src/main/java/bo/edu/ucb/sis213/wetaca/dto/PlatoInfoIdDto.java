package bo.edu.ucb.sis213.wetaca.dto;

public class PlatoInfoIdDto {
    private String nombre;
    private String descripcion;
    private String imagen;
    private Double precio;

    public PlatoInfoIdDto() {
    }

    public PlatoInfoIdDto(String nombre, String descripcion, String imagen, Double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "PlatoInfoIdDto{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", imagen=" + imagen + ", precio=" + precio + '}';
    }
}


