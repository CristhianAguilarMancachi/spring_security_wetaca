package bo.edu.ucb.sis213.wetaca.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import bo.edu.ucb.sis213.wetaca.entity.DetallePedido;

@Component
public interface DetallePlatoDao {
    
    @Insert(
        """
            INSERT INTO detalle_pedido (id_detalle_pedido, total_pedido, tipo_pago, id_pedido, tx_usuario, tx_host, tx_fecha)
                """
    )
    void createDetallePedido(DetallePedido detallePedido);

    @Delete(
        """
            DELETE FROM detalle_pedido
            WHERE id_detalle_pedido = #{idDetallePedido}
            """
    )
    void deleteDetallePedido(Integer idDetallePedido);

    @Update(
        """
            UPDATE detalle_pedido SET
            id_detalle_pedido = #{idDetallePedido},
            total_pedido = #{totalPedido},
            tipo_pago = #{tipoPago},
            id_pedido = #{idPedido},
            tx_usuario = #{txUsuario},
            tx_host = #{txHost},
            tx_fecha = #{txFecha}
            """
    )
    void updateDetallePedido(DetallePedido detallePedido);

    @Select(
        """
            SELECT id_detalle_pedido, total_pedido, tipo_pago, id_pedido, tx_usuario, tx_host, tx_fecha
            FROM detalle_pedido
            WHERE id_detalle_pedido = #{idDetallePedido}
            """
    )
    DetallePedido findByPrimaryKey(Integer idDetallePedido);
    
}
