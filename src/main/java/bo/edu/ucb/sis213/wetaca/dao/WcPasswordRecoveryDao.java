package bo.edu.ucb.sis213.wetaca.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import bo.edu.ucb.sis213.wetaca.entity.WcPasswordRecovery;

import java.util.Date;

@Component
public interface WcPasswordRecoveryDao {
    /**
     * Seleccionar de la base de datos la fecha de expiracion del codigo de recuperacion de contraseña.
     * @param userId
     * @param codeHash
     * @return
     */
    @Select("""
            SELECT expiration_date
            FROM recovery_attempt
            WHERE
                user_id = #{userId}
                AND status = 1
                AND code_hash = #{codeHash}
            """)
    Date findExpirationDate(int userId, String codeHash);

    /**
     * Insertar un codigo de recuperacion de contraseña en la base de datos
     * @param frPasswordRecovery
     * @return
     */
    @Insert("""
            INSERT INTO recovery_attempt (user_id, code_hash, expiration_date, status, tx_user, tx_host, tx_date)
            VALUES (#{userId}, #{codeHash}, #{expirationDate}, 1, 'ADMIN', 'LOCALHOST', now())
            """)
    void insertRecoveryAttempt(WcPasswordRecovery frPasswordRecovery);
}
