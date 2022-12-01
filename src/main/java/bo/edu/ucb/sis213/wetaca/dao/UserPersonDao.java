package bo.edu.ucb.sis213.wetaca.dao;

import bo.edu.ucb.sis213.wetaca.bl.UserBl;
import bo.edu.ucb.sis213.wetaca.entity.UserPerson;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface UserPersonDao {
    /**
     * En la vida real sería un query similar a:
     *  SELECT p.first_name, p.last_name, u.username
     *  FROM user u JOIN person p ON u.person_id = p.person_id
     *  WHERE u.username = #{username}
     *  AND u.status = true
     */

    @Select("""
            SELECT 'LUISA' as first_name, 'RAMIREZ' as last_name, username
            from 
                mr_user
            WHERE
                username = #{username}
                AND status = true
            """)
<<<<<<< HEAD
    public UserPerson findByUsername(String username);
=======
    public UserPerson findByUsername(String username); // busca por nombre de usuario
>>>>>>> 41fef87f2d5d5efdfe594acac5f365755311b59c

       // crear usuario
       @Insert("""

        --INSERT into wtc_usuario values ((#{ci_wtc_usuario}, #{nombre_wtc_usuario}, #{apellido_wtc_usuario}, 
                    #{correo_wtc_usuario}, #{fono_wtc_usuario}, #{id_ubicacion}, #{estado_wtc_usuario}, 
                    #{nombreusuario_wtc_usuario}, #{contrasena_wtc_usuario});
         """)
void creaUsuario(UserBl usuarioNuevo);
}

