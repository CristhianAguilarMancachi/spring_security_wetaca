package bo.edu.ucb.sis213.wetaca.dao;

import bo.edu.ucb.sis213.wetaca.entity.UserPerson;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface UserPersonDao {
    /**
    muestra todos los datos de la tabla wtc_usuario
     */

    @Select("""
        SELECT ci_wtc_usuario, nombre_wtc_usuario, apellido_wtc_usuario, correo_wtc_usuario, 
        fono_wtc_usuario, nombreusuario_wtc_usuario 
        FROM wtc_usuario;
            """)
    public UserPerson findByUsername(String username); // busca por nombre de usuario
    


}
