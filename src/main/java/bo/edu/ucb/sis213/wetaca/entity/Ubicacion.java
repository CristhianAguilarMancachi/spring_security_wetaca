package bo.edu.ucb.sis213.wetaca.entity;

public class Ubicacion {

    private Integer id_ubicacion; //id de la tabla ubicacion
    private Double latitud; //latitud de la tabla ubicacion
    private Double longitud; //longitud de la tabla ubicacion
    private String descripcion_ubicacion; //descripcion de la ubicacion de la tabla ubicacion
    private String txUsuario;
    private String txHost;
    private String txFecha;

 //constructor de la clase
    public Ubicacion() {
    }

    //constructor con parametros de la clase
    public Ubicacion(Integer id_ubicacion, Double latitud, Double longitud, String descripcion_ubicacion, String txUsuario, String txHost, String txFecha) {
        this.id_ubicacion = id_ubicacion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.descripcion_ubicacion = descripcion_ubicacion;
        this.txUsuario = txUsuario;
        this.txHost = txHost;
        this.txFecha = txFecha;
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

    public String getTxUsuario() {
        return txUsuario;
    }

    public void setTxUsuario(String txUsuario) {
        this.txUsuario = txUsuario;
    }

    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    public String getTxFecha() {
        return txFecha;
    }

    public void setTxFecha(String txFecha) {
        this.txFecha = txFecha;
    }

    @Override
    public String toString() {
        return "Ubicacion{" + "id_ubicacion=" + id_ubicacion + ", latitud=" + latitud + ", longitud=" + longitud + ", descripcion_ubicacion=" + descripcion_ubicacion + ", txUsuario=" + txUsuario + ", txHost=" + txHost + ", txFecha=" + txFecha + '}';
    }
    
    

    
}
