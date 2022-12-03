package bo.edu.ucb.sis213.wetaca.dto;

public class AnuncioDto {
    private Integer id_anuncio; //id de la tabla anuncio
    private int contador_clicks; //contador de clicks de la tabla anuncio

    //constructor de la clase
    public AnuncioDto() {
    }

    //constructor con parametros de la clase
    public AnuncioDto(Integer id_anuncio, int contador_clicks) {
        this.id_anuncio = id_anuncio;
        this.contador_clicks = contador_clicks;
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

    //toString de la clase

    @Override
    public String toString() {
        return "AnuncioDto{" + "id_anuncio=" + id_anuncio + ", contador_clicks=" + contador_clicks + '}';
    }
    
}
