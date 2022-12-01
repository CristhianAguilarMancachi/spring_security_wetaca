package bo.edu.ucb.sis213.wetaca.entity;

// clase de la tabla wtc_anuncio
public class wtc_anuncio {
    private int id_anuncio; // id del anuncio
    private int contador_click; //  contador de click
    private String txUsername; //   usuario que creo el anuncio
    private String txHost; // host del usuario
    private String txDate; //   fecha de creacion del anuncio
    
// constructor vacio
    public wtc_anuncio() {
    }
 // constructor con parametros
    public wtc_anuncio(int id_anuncio, int contador_click, String txUsername, String txHost, String txDate) {
        this.id_anuncio = id_anuncio;
        this.contador_click = contador_click;
        this.txUsername = txUsername;
        this.txHost = txHost;
        this.txDate = txDate;
    }
// getters y setters
    public int getId_anuncio() {
        return id_anuncio;
    }

    public void setId_anuncio(int id_anuncio) {
        this.id_anuncio = id_anuncio;
    }

    public int getContador_click() {
        return contador_click;
    }

    public void setContador_click(int contador_click) {
        this.contador_click = contador_click;
    }

    public String getTxUsername() {
        return txUsername;
    }

    public void setTxUsername(String txUsername) {
        this.txUsername = txUsername;
    }

    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    public String getTxDate() {
        return txDate;
    }

    public void setTxDate(String txDate) {
        this.txDate = txDate;
    }

    // metodo toString
    @Override
    public String toString() {
        return "wtc_anuncio{" + "id_anuncio=" + id_anuncio + ", contador_click=" + contador_click + ", txUsername=" + txUsername + ", txHost=" + txHost + ", txDate=" + txDate + '}';
    }

}
