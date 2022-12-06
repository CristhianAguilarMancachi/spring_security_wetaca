package bo.edu.ucb.sis213.wetaca.dao;

import bo.edu.ucb.sis213.wetaca.entity.Wtc_usuario;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {

    @Select("""
            select user_id, username, secret, status, tx_username,
                tx_host, tx_date
            from 
                mr_user
            WHERE
                user_id = #{userId}
                AND status = true
            """)
    Wtc_usuario findByPrimaryKey(Integer userId);

    @Select("""
            select user_id, username, secret, status, tx_username,
                tx_host, tx_date
            from 
                mr_user
            WHERE
                username = #{username}
                AND status = true
            """)
    Wtc_usuario findByUsername(String username);

    @Select("""
            select secret
            from 
                mr_user
            WHERE
                username = #{username} 
                AND status = true
            """)
    String findSecretByUsername(String username);

    @Insert("""
      INSERT INTO
       mr_user (username, secret, status, tx_username, tx_host, tx_date)
      VALUES (#{username}, #{secret}, true, 'anonymous', 'localhost', now())  
            """)
    void createUser (Wtc_usuario mrUser);

    // Selecciona un usuario por su nombre de usuario
    @Select("""
            Select ci_wtc_usuario, nombre_wtc_usuario, apellido_wtc_usuario,
             correo_wtc_usuario, fono_wtc_usuario, nombreusuario_wtc_usuario 
            From 
                wtc_usuario
            Where
                nombreusuario_wtc_usuario = #{nombreusuario_wtc_usuario}
                AND status_wtc_usuario = true
            """)
    public Wtc_usuario buscarUsuarioPorUserName(String nombreusuario_wtc_usuario);

    /**
     * Encontrar un usuario por su email para verificar su existencia y evitar duplicados
     * @param email
     * @return FrUser
     */
    @Select("""
        SELECT id_wtc_usuario, ci_wtc_usuario, nombre_wtc_usuario, apellido_wtc_usuario,
        correo_wtc_usuario, fono_wtc_usuario, nombreusuario_wtc_usuario, contrasena_wtc_usuario, estado_wtc_usuario 
            FROM wtc_usuario
            WHERE
                correo_wtc_usuario = #{email}
                AND estado_wtc_usuario = 1
            """)
    Wtc_usuario findByEmail(String email);

    

}
