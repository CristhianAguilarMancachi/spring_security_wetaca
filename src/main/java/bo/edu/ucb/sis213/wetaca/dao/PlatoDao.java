package bo.edu.ucb.sis213.wetaca.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import bo.edu.ucb.sis213.wetaca.entity.Plato;

@Component
public interface PlatoDao {


// Insert a la tabla Plato con los atributos de la clase Plato que son nombre, descripcion, ingrediente, precio, status, tx_username, tx_host, tx_date
    @Insert(
                """
                INSERT INTO
                        Plato (nombre, descripcion, ingrediente, precio, status, tx_username, tx_host, tx_date)
                VALUES (#{nombre}, #{descripcion}, #{ingrediente}, #{precio}, true, 'anonymous', 'localhost', now())
                """
        )
        void createPlato(Plato plato);

// Borrado logico de la tabla Plato con el atributo id_plato
    @Delete(
                """
                UPDATE Plato
                SET status = false
                WHERE id_plato = #{idPlato}
                """
        )
        void deletePlato(Integer platoId);

        // Select de todos los atributos de la tabla Plato con el atributo id_plato excepto el atributo status, txUsuario, txHost, txFecha
        @Select(
                """
                SELECT id_plato, nombre, descripcion, ingrediente, precio
                FROM Plato
                WHERE id_plato = #{idPlato}
                """
        )
        Plato findByPrimaryKey(Integer platoId);

        // Select para sacar lista de todos los platos de la tabla Plato excepto el atributo status, txUsuario, txHost, txFecha
        @Select(
                """
                SELECT id_plato, nombre, descripcion, ingrediente, precio
                FROM Plato
                """
        )
        List<Plato> findAllPlatos();

        // Update de la tabla Plato con los atributos de la clase Plato que son nombre, descripcion, ingrediente, precio
        @Update(
                """
                UPDATE Plato SET
                nombre = #{nombre},
                descripcion = #{descripcion},
                ingrediente = #{ingrediente},
                precio = #{precio}
                WHERE id_plato = #{idPlato}
                """
        )
        void updatePlato(Plato plato);

        // Lista de platos por nombre de categoria
        @Select(
                """
                SELECT p.id_plato, p.nombre, p.descripcion, p.ingrediente, p.precio
                FROM Plato p
                INNER JOIN Categoria c ON p.id_categoria = c.id_categoria
                WHERE c.nombre = #{nombre}
                """
        )
        Plato findPlatosByCategoria(String nombre);

        // Encontrar plato por id de plato
        @Select(
                """
                SELECT p.id_plato, p.nombre, p.descripcion, p.ingrediente, p.precio
                FROM Plato p
                WHERE p.id_plato = #{idPlato}
                """
        )
        Plato findPlatoByPlatoId(Integer idPlato);

        // Funcion findPlatoInfoByPlatoId
        @Select(
                """
                SELECT p.id_plato, p.nombre, p.descripcion, p.ingrediente, p.precio, c.nombre
                FROM Plato p
                INNER JOIN Categoria c ON p.id_categoria = c.id_categoria
                WHERE p.id_plato = #{idPlato}
                """
        )
        Plato findPlatoInfoByPlatoId(Integer idPlato);

    



}
