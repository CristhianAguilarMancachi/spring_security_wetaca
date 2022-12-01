package bo.edu.ucb.sis213.wetaca.entity;

public class PlatoPedido{
    private Integer idPlatoPedido;
    private Integer idPlato;
    private Integer idPedido;
    private String txUsuario;
    private String txHost;
    private String txFecha;

    public PlatoPedido() {
    }

    public PlatoPedido(Integer idPlatoPedido, Integer idPlato, Integer idPedido, String txUsuario, String txHost, String txFecha) {
        this.idPlatoPedido = idPlatoPedido;
        this.idPlato = idPlato;
        this.idPedido = idPedido;
        this.txUsuario = txUsuario;
        this.txHost = txHost;
        this.txFecha = txFecha;
    }

    public Integer getIdPlatoPedido() {
        return idPlatoPedido;
    }

    public void setIdPlatoPedido(Integer idPlatoPedido) {
        this.idPlatoPedido = idPlatoPedido;
    }

    public Integer getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(Integer idPlato) {
        this.idPlato = idPlato;
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
        return "WtcPlatoPedido{" + "idPlatoPedido=" + idPlatoPedido + ", idPlato=" + idPlato + ", idPedido=" + idPedido + ", txUsuario=" + txUsuario + ", txHost=" + txHost + ", txFecha=" + txFecha + '}';
    }
}