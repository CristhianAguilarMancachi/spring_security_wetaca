package bo.edu.ucb.sis213.wetaca.dao;

import bo.edu.ucb.sis213.wetaca.entity.Wtc_usuario;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface Wtc_usuarioDao {

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
    public Wtc_usuario findByUsername(String nombreusuario_wtc_usuario);


    // Inserta un usuario nuevo
    @Insert("""
            Insert Into wtc_usuario (ci_wtc_usuario, nombre_wtc_usuario, apellido_wtc_usuario,
             correo_wtc_usuario, fono_wtc_usuario, nombreusuario_wtc_usuario, password_wtc_usuario, status_wtc_usuario)
            Values (#{ci_wtc_usuario}, #{nombre_wtc_usuario}, #{apellido_wtc_usuario},
             #{correo_wtc_usuario}, #{fono_wtc_usuario}, #{nombreusuario_wtc_usuario}, #{password_wtc_usuario}, #{status_wtc_usuario})
            """)
    public void insert(Wtc_usuario wtc_usuario);

    /*
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

    
    */        
   
}
