package bo.edu.ucb.sis213.wetaca.dao;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Component;

import bo.edu.ucb.sis213.wetaca.entity.Anuncio;

@Component
public interface AnuncioDao {
    //inserta un anuncio nuevo
    @Insert("""
            Insert Into anuncio (id_anuncio, contador_clicks))
            Values (#{id_anuncio}, #{contador_clicks})
            """)
    public void agregarNuevoAnuncio(Anuncio anuncio);

    
}
