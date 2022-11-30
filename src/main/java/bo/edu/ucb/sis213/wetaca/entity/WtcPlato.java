package bo.edu.ucb.sis213.wetaca.entity;

public class WtcPlato {
    private Integer id_plato;
    private String nombre_plato;
    private String descripcion_plato;
    private String imagen_plato;
    private Integer precio_plato;
    private Integer categoria_plato;
    private boolean estado_plato;
    private String tx_username;
    private String tx_host;
    private String tx_date;

    public WtcPlato() {
    }

    public WtcPlato(Integer id_plato, String nombre_plato, String descripcion_plato, String imagen_plato, Integer precio_plato, Integer categoria_plato, boolean estado_plato, String tx_username, String tx_host, String tx_date) {
        this.id_plato = id_plato;
        this.nombre_plato = nombre_plato;
        this.descripcion_plato = descripcion_plato;
        this.imagen_plato = imagen_plato;
        this.precio_plato = precio_plato;
        this.categoria_plato = categoria_plato;
        this.estado_plato = estado_plato;
        this.tx_username = tx_username;
        this.tx_host = tx_host;
        this.tx_date = tx_date;
    }

    public Integer getId_plato() {
        return id_plato;
    }

    public void setId_plato(Integer id_plato) {
        this.id_plato = id_plato;
    }

    public String getNombre_plato() {
        return nombre_plato;
    }

    public void setNombre_plato(String nombre_plato) {
        this.nombre_plato = nombre_plato;
    }

    public String getDescripcion_plato() {
        return descripcion_plato;
    }

    public void setDescripcion_plato(String descripcion_plato) {
        this.descripcion_plato = descripcion_plato;
    }

    public String getImagen_plato() {
        return imagen_plato;
    }

    public void setImagen_plato(String imagen_plato) {
        this.imagen_plato = imagen_plato;
    }

    public Integer getPrecio_plato() {
        return precio_plato;
    }

    public void setPrecio_plato(Integer precio_plato) {
        this.precio_plato = precio_plato;
    }

    public Integer getCategoria_plato() {
        return categoria_plato;
    }

    public void setCategoria_plato(Integer categoria_plato) {
        this.categoria_plato = categoria_plato;
    }

    public boolean isEstado_plato() {
        return estado_plato;
    }

    public void setEstado_plato(boolean estado_plato) {
        this.estado_plato = estado_plato;
    }

    public String getTx_username() {
        return tx_username;
    }

    public void setTx_username(String tx_username) {
        this.tx_username = tx_username;
    }

    public String getTx_host() {
        return tx_host;
    }

    public void setTx_host(String tx_host) {
        this.tx_host = tx_host;
    }

    public String getTx_date() {
        return tx_date;
    }

    public void setTx_date(String tx_date) {
        this.tx_date = tx_date;
    }

    @Override
    public String toString() {
        return "WetacaPlato{" +
                "id_plato=" + id_plato +
                ", nombre_plato='" + nombre_plato + '\'' +
                ", descripcion_plato='" + descripcion_plato + '\'' +
                ", imagen_plato='" + imagen_plato + '\'' +
                ", precio_plato=" + precio_plato +
                ", categoria_plato=" + categoria_plato +
                ", estado_plato=" + estado_plato +
                ", tx_username='" + tx_username + '\'' +
                ", tx_host='" + tx_host + '\'' +
                ", tx_date='" + tx_date + '\'' +
                '}';
    }




    

    
}
