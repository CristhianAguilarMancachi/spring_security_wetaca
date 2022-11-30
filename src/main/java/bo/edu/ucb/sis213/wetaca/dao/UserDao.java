package bo.edu.ucb.sis213.wetaca.dao;

import bo.edu.ucb.sis213.wetaca.entity.WtcUsuario;
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
    WtcUsuario findByPrimaryKey(Integer userId);

    @Select("""
            select user_id, username, secret, status, tx_username,
                tx_host, tx_date
            from 
                mr_user
            WHERE
                username = #{username}
                AND status = true
            """)
    WtcUsuario findByUsername(String username);

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
    void createUser (WtcUsuario mrUser);

}
