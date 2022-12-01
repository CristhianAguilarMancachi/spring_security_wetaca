package bo.edu.ucb.sis213.wetaca.entity;

public class Plato {
    private Integer idPlato;
    private String nombre;
    private String descripcion;
    private String imagen;
    private Double precio;
    private String categoria;
    private String ingredientes;
    private boolean estado;
    private String txUsuario;
    private String txHost;
    private String txFecha;

    public Plato() {
    }

    public Plato(Integer idPlato, String nombre, String descripcion, String imagen, Double precio, String categoria, String ingredientes, boolean estado, String tx_username, String tx_host, String tx_date) {
        this.idPlato = idPlato;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
        this.categoria = categoria;
        this.ingredientes = ingredientes;
        this.estado = estado;
        this.txUsuario = tx_username;
        this.txHost = tx_host;
        this.txFecha = tx_date;
    }

    public Integer getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(Integer idPlato) {
        this.idPlato = idPlato;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getTx_username() {
        return txUsuario;
    }

    public void setTx_username(String tx_username) {
        this.txUsuario = tx_username;
    }

    public String getTx_host() {
        return txHost;
    }

    public void setTx_host(String tx_host) {
        this.txHost = tx_host;
    }

    public String getTx_date() {
        return txFecha;
    }

    public void setTx_date(String tx_date) {
        this.txFecha = tx_date;
    }

    @Override
    public String toString() {
        return "Plato{" + "idPlato=" + idPlato + ", nombre=" + nombre + ", descripcion=" + descripcion + ", imagen=" + imagen + ", precio=" + precio + ", categoria=" + categoria + ", ingredientes=" + ingredientes + ", estado=" + estado + ", tx_username=" + txUsuario + ", tx_host=" + txHost + ", tx_date=" + txFecha + '}';
    }
}