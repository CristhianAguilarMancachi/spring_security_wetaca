package bo.edu.ucb.sis213.wetaca.entity;

public class Pedido{
    private Integer idPedido;
    private String fechaPedido;
    private Double subtotal;
    private Integer cantidad;
    private Boolean estado;
    private String ciUsuario;
    private String fechaEntrega;
    private Integer idUsuario;
    private String txUsuario;
    private String txHost;
    private String txFecha;

    public Pedido() {
    }

    public Pedido(Integer idPedido, String fechaPedido, Double subtotal, Integer cantidad, Boolean estado, String ciUsuario, String fechaEntrega, Integer idUsuario, String txUsuario, String txHost, String txFecha) {
        this.idPedido = idPedido;
        this.fechaPedido = fechaPedido;
        this.subtotal = subtotal;
        this.cantidad = cantidad;
        this.estado = estado;
        this.ciUsuario = ciUsuario;
        this.fechaEntrega = fechaEntrega;
        this.idUsuario = idUsuario;
        this.txUsuario = txUsuario;
        this.txHost = txHost;
        this.txFecha = txFecha;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getCiUsuario() {
        return ciUsuario;
    }

    public void setCiUsuario(String ciUsuario) {
        this.ciUsuario = ciUsuario;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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
        return "Pedido{" + "idPedido=" + idPedido + ", fechaPedido=" + fechaPedido + ", subtotal=" + subtotal + ", cantidad=" + cantidad + ", estado=" + estado + ", ciUsuario=" + ciUsuario + ", fechaEntrega=" + fechaEntrega + ", idUsuario=" + idUsuario + ", txUsuario=" + txUsuario + ", txHost=" + txHost + ", txFecha=" + txFecha + '}';
    }

    


}