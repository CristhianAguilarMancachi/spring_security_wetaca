package bo.edu.ucb.sis213.wetaca.entity;

public class Cargo {

    private Integer id_cargo; //id de la tabla cargo
    private String descripcion_cargo; //descripcion del cargo de la tabla cargo
    private Integer id_wtc_usuario; //id del usuario de la tabla wtc_usuario
    private String txUsuario;
    private String txHost;
    private String txFecha;

    //constructor de la clase
    public Cargo() {
    }

    //constructor con parametros de la clase
    public Cargo(Integer id_cargo, String descripcion_cargo, Integer id_wtc_usuario, String txUsuario, String txHost, String txFecha) {
        this.id_cargo = id_cargo;
        this.descripcion_cargo = descripcion_cargo;
        this.id_wtc_usuario = id_wtc_usuario;
        this.txUsuario = txUsuario;
        this.txHost = txHost;
        this.txFecha = txFecha;
    }

    //getters y setters de la clase

    public Integer getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(Integer id_cargo) {
        this.id_cargo = id_cargo;
    }

    public String getDescripcion_cargo() {
        return descripcion_cargo;
    }

    public void setDescripcion_cargo(String descripcion_cargo) {
        this.descripcion_cargo = descripcion_cargo;
    }

    public Integer getId_wtc_usuario() {
        return id_wtc_usuario;
    }

    public void setId_wtc_usuario(Integer id_wtc_usuario) {
        this.id_wtc_usuario = id_wtc_usuario;
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
        return "Cargo{" + "id_cargo=" + id_cargo + ", descripcion_cargo=" + descripcion_cargo + ", id_wtc_usuario=" + id_wtc_usuario + ", txUsuario=" + txUsuario + ", txHost=" + txHost + ", txFecha=" + txFecha + '}';
    }
}
