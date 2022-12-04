package bo.edu.ucb.sis213.wetaca.dto;

public class CreatePlatoDto {
    private String nombre;
    private String descripcion;
    private String ingredientes;
    private Double precio;
    private String categoria;

    public CreatePlatoDto() {
    }

    public CreatePlatoDto(String nombrePlato, String descripcionPlato, String ingredientes, Double precioPlato, String categoriaPlato) {
        this.nombre = nombrePlato;
        this.descripcion = descripcionPlato;
        this.ingredientes = ingredientes;
        this.precio = precioPlato;
        this.categoria = categoriaPlato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombrePlato) {
        this.nombre = nombrePlato;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcionPlato) {
        this.descripcion = descripcionPlato;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precioPlato) {
        this.precio = precioPlato;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoriaPlato) {
        this.categoria = categoriaPlato;
    }

    @Override
    public String toString() {
        return "CreatePlatoDto{" +
                "nombrePlato='" + nombre + '\'' +
                ", descripcionPlato='" + descripcion + '\'' +
                ", ingredientes='" + ingredientes + '\'' +
                ", precioPlato=" + precio +
                ", categoriaPlato='" + categoria + '\'' +
                '}';
    }


    public boolean validate () {
        if (this.nombre == null || this.nombre.isEmpty()) {
            return false;
        }
        if (this.descripcion == null || this.descripcion.isEmpty()) {
            return false;
        }
        if (this.ingredientes == null || this.ingredientes.isEmpty()) {
            return false;
        }
        if (this.precio == null || this.precio < 0) {
            return false;
        }
        if (this.categoria == null || this.categoria.isEmpty()) {
            return false;
        }
        return true;
    }
}
