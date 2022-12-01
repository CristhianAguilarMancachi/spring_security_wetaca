package bo.edu.ucb.sis213.wetaca.entity;

// clase de la tabla wtc_anuncio
public class wtc_anuncio {
    private int id_anuncio;
    private int contador_click;
    
// constructor vacio
    public wtc_anuncio() {
    }
// constructor con parametros
    public wtc_anuncio(int id_anuncio, int contador_click) {
        this.id_anuncio = id_anuncio;
        this.contador_click = contador_click;
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
// toString
    @Override
    public String toString() {
        return "wtc_anuncio{" + "id_anuncio=" + id_anuncio + ", contador_click=" + contador_click + '}';
    }
    
    
}
