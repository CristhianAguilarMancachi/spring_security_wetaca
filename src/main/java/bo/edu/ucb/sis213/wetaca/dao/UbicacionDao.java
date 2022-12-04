package bo.edu.ucb.sis213.wetaca.dao;

import bo.edu.ucb.sis213.wetaca.entity.Ubicacion;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Component;

@Component
public interface UbicacionDao {
    
    //Inserta una ubicacion nueva
    @Insert("""
            Insert Into ubicacion (latitud, longitud, descripcion_ubicacion)
            Values (#{latitud}, #{longitud}, #{descripcion_ubicacion})
            """)
    public void agregarNuevaUbicacion(Ubicacion ubicacion);
}
