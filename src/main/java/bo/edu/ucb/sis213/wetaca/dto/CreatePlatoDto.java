package bo.edu.ucb.sis213.wetaca.dto;

public class CreatePlatoDto {
    private String nombrePlato;
    private String descripcionPlato;
    private String ingredientes;
    private Double precioPlato;

    public CreatePlatoDto() {
    }

    public CreatePlatoDto(String nombrePlato, String descripcionPlato, String ingredientes, Double precioPlato) {
        this.nombrePlato = nombrePlato;
        this.descripcionPlato = descripcionPlato;
        this.ingredientes = ingredientes;
        this.precioPlato = precioPlato;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public String getDescripcionPlato() {
        return descripcionPlato;
    }

    public void setDescripcionPlato(String descripcionPlato) {
        this.descripcionPlato = descripcionPlato;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Double getPrecioPlato() {
        return precioPlato;
    }

    public void setPrecioPlato(Double precioPlato) {
        this.precioPlato = precioPlato;
    }

    @Override
    public String toString() {
        return "CreatePlatoDto{" +
                "nombrePlato='" + nombrePlato + '\'' +
                ", descripcionPlato='" + descripcionPlato + '\'' +
                ", ingredientes='" + ingredientes + '\'' +
                ", precioPlato=" + precioPlato +
                '}';
    }

    public boolean validate () {
        if (this.nombrePlato == null || this.nombrePlato.isEmpty()) {
            return false;
        }

        if (this.descripcionPlato == null || this.descripcionPlato.isEmpty()) {
            return false;
        }

        if (this.ingredientes == null || this.ingredientes.isEmpty()) {
            return false;
        }

        if (this.precioPlato == null || this.precioPlato <= 0) {
            return false;
        }

        return true;

    }
    
}
