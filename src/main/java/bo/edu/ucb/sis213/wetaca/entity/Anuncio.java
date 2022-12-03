package bo.edu.ucb.sis213.wetaca.entity;

public class Anuncio {
    
    private Integer id_anuncio; //id de la tabla anuncio
    private int contador_clicks; //contador de clicks de la tabla anuncio
    private String txUsuario;
    private String txHost;
    private String txFecha;

    //constructor de la clase
    public Anuncio() {
    }

    //constructor con parametros de la clase
    public Anuncio(Integer id_anuncio, int contador_clicks, String txUsuario, String txHost, String txFecha) {
        this.id_anuncio = id_anuncio;
        this.contador_clicks = contador_clicks;
        this.txUsuario = txUsuario;
        this.txHost = txHost;
        this.txFecha = txFecha;
    }

    //getters y setters de la clase
    public Integer getId_anuncio() {
        return id_anuncio;
    }

    public void setId_anuncio(Integer id_anuncio) {
        this.id_anuncio = id_anuncio;
    }

    public int getContador_clicks() {
        return contador_clicks;
    }

    public void setContador_clicks(int contador_clicks) {
        this.contador_clicks = contador_clicks;
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
        return "Anuncio{" + "id_anuncio=" + id_anuncio + ", contador_clicks=" + contador_clicks + ", txUsuario=" + txUsuario + ", txHost=" + txHost + ", txFecha=" + txFecha + '}';
    }
    
    

}
