package bo.edu.ucb.sis213.wetaca.dto;

public class UbicacionDto {
    private Integer id_ubicacion; //id de la tabla ubicacion
    private Double latitud; //latitud de la tabla ubicacion
    private Double longitud; //longitud de la tabla ubicacion
    private String descripcion_ubicacion; //descripcion de la ubicacion de la tabla ubicacion
 
    //constructor de la clase
    public UbicacionDto() {
    }

    //constructor con parametros de la clase
    public UbicacionDto(Integer id_ubicacion, Double latitud, Double longitud, String descripcion_ubicacion) {
        this.id_ubicacion = id_ubicacion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.descripcion_ubicacion = descripcion_ubicacion;
    }

    //getters y setters de la clase

    public Integer getId_ubicacion() {
        return id_ubicacion;
    }

    public void setId_ubicacion(Integer id_ubicacion) {
        this.id_ubicacion = id_ubicacion;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public String getDescripcion_ubicacion() {
        return descripcion_ubicacion;
    }

    public void setDescripcion_ubicacion(String descripcion_ubicacion) {
        this.descripcion_ubicacion = descripcion_ubicacion;
    }

    //toString de la clase

    @Override
    public String toString() {
        return "Ubicacion{" + "id_ubicacion=" + id_ubicacion + ", latitud=" + latitud + ", longitud=" + longitud + ", descripcion_ubicacion=" + descripcion_ubicacion + '}';
    }
    
}
