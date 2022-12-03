package bo.edu.ucb.sis213.wetaca.dao;

import bo.edu.ucb.sis213.wetaca.entity.UserPerson;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface UserPersonDao {
// Selecciona un usuario por su nombre de usuario
    @Select("""
            SELECT 'LUISA' as first_name, 'RAMIREZ' as last_name, username
            from 
                mr_user
            WHERE
                username = #{username}
                AND status = true
            """)
    public UserPerson findByUsername(String username);


}
