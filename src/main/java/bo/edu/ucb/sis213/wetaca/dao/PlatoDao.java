package bo.edu.ucb.sis213.wetaca.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import bo.edu.ucb.sis213.wetaca.entity.WtcPlato;

@Component
public interface PlatoDao {
    
    @Insert("""
            INSERT INTO
                wtc_plato (nombre, descripcion, precio, status, tx_username, tx_host, tx_date)
            VALUES (#{nombre}, #{descripcion}, #{precio}, true, 'anonymous', 'localhost', now())
            """)
    void createPlato(WtcPlato plato);

    @Update(
            """
            UPDATE wtc_plato
            SET nombre = #{nombre}, descripcion = #{descripcion}, precio = #{precio}, status = #{status}, tx_username = #{txUsername}, tx_host = #{txHost}, tx_date = #{txDate}
            WHERE plato_id = #{platoId}
            """
    )
    void updatePlato(WtcPlato plato);

    @Delete(
            """
            DELETE FROM wtc_plato
            WHERE plato_id = #{platoId}
            """
    )
    void deletePlato(Integer platoId);

    @Select(
            """
            SELECT plato_id, nombre, descripcion, precio, status, tx_username, tx_host, tx_date
            FROM wtc_plato
            WHERE plato_id = #{platoId}
            """
    )
    WtcPlato findByPrimaryKey(Integer platoId);

    
    



}
