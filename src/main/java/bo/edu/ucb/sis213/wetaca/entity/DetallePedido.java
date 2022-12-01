package bo.edu.ucb.sis213.wetaca.entity;

public class DetallePedido{
    private Integer idDetallePedido;
    private Double totalPedido;
    private String tipoPago;
    private Integer idPedido;
    private String txUsuario;
    private String txHost;
    private String txFecha;

    public DetallePedido() {
    }

    public DetallePedido(Integer idDetallePedido, Double totalPedido, String tipoPago, Integer idPedido, String txUsuario, String txHost, String txFecha) {
        this.idDetallePedido = idDetallePedido;
        this.totalPedido = totalPedido;
        this.tipoPago = tipoPago;
        this.idPedido = idPedido;
        this.txUsuario = txUsuario;
        this.txHost = txHost;
        this.txFecha = txFecha;
    }

    public Integer getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(Integer idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public Double getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(Double totalPedido) {
        this.totalPedido = totalPedido;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
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
        return "WtcDetallePedido{" + "idDetallePedido=" + idDetallePedido + ", totalPedido=" + totalPedido + ", tipoPago=" + tipoPago + ", idPedido=" + idPedido + ", txUsuario=" + txUsuario + ", txHost=" + txHost + ", txFecha=" + txFecha + '}';
    }

}