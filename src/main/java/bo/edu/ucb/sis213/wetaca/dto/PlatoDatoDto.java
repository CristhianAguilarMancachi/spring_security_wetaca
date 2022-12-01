package bo.edu.ucb.sis213.wetaca.dto;
public class PlatoDatoDto {
    private String nombre;
    private String descripcion;
    private String ingredientes;
    private String categoria;
    private Double precio;

    public PlatoDatoDto() {
    }

    public PlatoDatoDto(String nombre, String descripcion, String ingredientes, String categoria, Double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ingredientes = ingredientes;
        this.categoria = categoria;
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

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "PlatoDatoDto{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", ingredientes=" + ingredientes + ", categoria=" + categoria + ", precio=" + precio + '}';
    }

}