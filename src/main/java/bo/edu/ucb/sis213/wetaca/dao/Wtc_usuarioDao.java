package bo.edu.ucb.sis213.wetaca.dao;

import bo.edu.ucb.sis213.wetaca.entity.Wtc_usuario;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Component
public interface Wtc_usuarioDao {

    /**
     * Insertar un nuevo registro de usuario a la BD
     * @param user
     * @return void
     */
    @Insert("""
            INSERT INTO
                wtc_usuario(ci_wtc_usuario, nombre_wtc_usuario, apellido_wtc_usuario,
                correo_wtc_usuario, fono_wtc_usuario, id_ubicacion, estado_wtc_usuario,nombreusuario_wtc_usuario, contrasena_wtc_usuario)
            VALUES ( #{ci_wtc_usuario}, #{nombre_wtc_usuario}, #{apellido_wtc_usuario}, 
            #{correo_wtc_usuario}, #{fono_wtc_usuario}, 1, true, #{nombreusuario_wtc_usuario}, #{contrasena_wtc_usuario})
            """)
    void createUser(Wtc_usuario user);

    /**
     * Encontrar un usuario por su nombre de usuario (username) para verificar si existe
     * @param username
     * @return Wtc_user
     */
    @Select("""
            Select id_wtc_usuario, ci_wtc_usuario, nombre_wtc_usuario, apellido_wtc_usuario,
             correo_wtc_usuario, fono_wtc_usuario, nombreusuario_wtc_usuario 
            From 
                wtc_usuario
            Where
                nombreusuario_wtc_usuario = #{nombreusuario_wtc_usuario}
                AND status_wtc_usuario = true
            """)
    public Wtc_usuario buscarUsuarioPorUserName(String nombreusuario_wtc_usuario);

    /**
     * Encontrar un usuario por su nombre de usuario (username) para verificar si existe
     * @param username
     * @return Wtc_usuario
     */
    @Select("""
            SELECT id_wtc_usuario, ci_wtc_usuario, nombre_wtc_usuario, apellido_wtc_usuario,
            correo_wtc_usuario, fono_wtc_usuario, id_ubicacion, estado_wtc_usuario, nombreusuario_wtc_usuario, contrasena_wtc_usuario 
            FROM 
                wtc_usuario

            WHERE 
                nombreusuario_wtc_usuario = #{username}
                AND estado_wtc_usuario = true
            """)
    Wtc_usuario findByUsername(String username);


    //Selecciona un nombre de usuario por su id_wtc_usuario
    @Select("""
            Select nombreusuario_wtc_usuario
            From 
                wtc_usuario
            Where
                id_wtc_usuario = #{id_wtc_usuario}
                AND status_wtc_usuario = true
            """)
    public Wtc_usuario buscarUserNamePorId(Integer id_wtc_usuario);

    //Selecciona un id_wtc_usuario por su nombre de usuario
    @Select("""
            Select id_wtc_usuario
            From 
                wtc_usuario
            Where
                nombreusuario_wtc_usuario = #{nombreusuario_wtc_usuario}
                AND status_wtc_usuario = true
            """)
    public Integer buscarIdUsuarioPorUserName(String nombreusuario_wtc_usuario);

    // Inserta un usuario nuevo
    @Insert("""
            Insert Into wtc_usuario (ci_wtc_usuario, nombre_wtc_usuario, apellido_wtc_usuario,
             correo_wtc_usuario, fono_wtc_usuario, nombreusuario_wtc_usuario, password_wtc_usuario, status_wtc_usuario)
            Values (#{ci_wtc_usuario}, #{nombre_wtc_usuario}, #{apellido_wtc_usuario},
             #{correo_wtc_usuario}, #{fono_wtc_usuario}, #{nombreusuario_wtc_usuario}, #{password_wtc_usuario}, #{status_wtc_usuario})
            """)
    public void agregarNuevoUsuario(Wtc_usuario wtc_usuario);

    //Selecciona la contraseña de un usuario por su nombre de usuario
    @Select("""
            Select contrasena_wtc_usuario
            From 
                wtc_usuario
            Where
                nombreusuario_wtc_usuario = #{nombreusuario_wtc_usuario}
                AND estado_wtc_usuario = true
            """)
    public String buscarPasswordPorUserName(String nombreusuario_wtc_usuario);

    /**
     * Encontrar un usuario por su id (userId)
     * @param userId
     * @return FrUser
     */
    @Select("""
            SELECT id_wtc_usuario, ci_wtc_usuario, nombre_wtc_usuario, apellido_wtc_usuario,
            correo_wtc_usuario, fono_wtc_usuario, nombreusuario_wtc_usuario, password_wtc_usuario, estado_wtc_usuario tx_user, tx_host, tx_date
            FROM wtc_usuario
            WHERE
                id_wtc_usuario = #{userId}
                AND estado_wtc_usuario = 1
            """)
    Wtc_usuario findById(Integer userId);

    /**
     * Actualizar un registro de usuario en la BD
     * @param user
     * @return void
     */
    @Update("""
            UPDATE
                wtc_usuario
            SET
                ci_wtc_usuario = #{ci},
                nombre_wtc_usuario = #{firstName},
                apellido_wtc_usuario = #{lastName},
                correo_wtc_usuario = #{email},
                fono_wtc_usuario = #{fono},
                nombreusuario_wtc_usuario = #{username},
            WHERE
                user_id = #{userId}
            """)
    void updateUser(Wtc_usuario user);

    /**
     * Actualizar la contraseña de un usuario
     * @param secret
     */
    @Update("""
            UPDATE
                wtc_usuario
            SET
                contrasena_wtc_usuario = #{secret}
            WHERE
                correo_wtc_usuario =  #{email}
            AND estado_wtc_usuario = 1
            """)
    void updatePassword(String email, String secret);

    /**
     * Encontrar un usuario por su email para verificar su existencia y evitar duplicados
     * @param email
     * @return Wtc_usuario
     */
    @Select("""
        SELECT id_wtc_usuario, ci_wtc_usuario, nombre_wtc_usuario, apellido_wtc_usuario,
        correo_wtc_usuario, fono_wtc_usuario, id_ubicacion, estado_wtc_usuario, nombreusuario_wtc_usuario, contrasena_wtc_usuario 
            FROM wtc_usuario
            WHERE
                correo_wtc_usuario = #{email}
                AND estado_wtc_usuario = true
            """)
    Wtc_usuario findByEmail(String email);

    


    /**
     * Encontrar el id de un usuario por su correo electronico
     * @param email
     * @return id_wtc_usuario
     */
    @Select("""
        SELECT id_wtc_usuario FROM wtc_usuario 
        WHERE correo_wtc_usuario = #{email} AND estado_wtc_usuario = true
        """)
    Integer findUserIdByEmail(String email);     
   
}
