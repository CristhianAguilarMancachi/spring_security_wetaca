package bo.edu.ucb.sis213.wetaca.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import bo.edu.ucb.sis213.wetaca.dto.CreatePedidoDto;
import bo.edu.ucb.sis213.wetaca.dto.PedidoDatoDto;
import bo.edu.ucb.sis213.wetaca.entity.Pedido;

@Component
public interface PedidoDao {

    @Insert("""
            INSERT INTO
                pedido (id_pedido, fecha_pedido, cantidad_pedido, subtotal_pedido, estado_pedido, ci_usuario, fecha_entrega, id_usuario, tx_usuario, tx_host, tx_fecha)
            """)
    void createPedido(Pedido pedido);

    @Delete(
            """
            DELETE FROM pedido
            WHERE id_pedido = #{idPedido}
            """    
    )
    void deletePlato(Integer platoId);

    // Select para obtener una lista de la tabla Pedido con los atributos id_pedido, fecha_pedido, cantidad_pedido, subtotal_pedido, estado_pedido, ci_usuario, fecha_entrega, id_usuario, tx_usuario, tx_host, tx_fecha
    @Select(
            """
            SELECT fecha_pedido, cantidad_pedido, subtotal_pedido, estado_pedido, ci_usuario, fecha_entrega
            FROM pedido
            """
    )
    List<CreatePedidoDto> findAllPedidos();

    @Update(
            """
                UPDATE pedido SET
                id_pedido = #{idPedido},
                fecha_pedido = #{fechaPedido},
                cantidad_pedido = #{cantidadPedido},
                subtotal_pedido = #{subtotalPedido},
                estado_pedido = #{estadoPedido},
                ci_usuario = #{ciUsuario},
                fecha_entrega = #{fechaEntrega},
                id_usuario = #{idUsuario},
                tx_usuario = #{txUsuario},
                tx_host = #{txHost},
                tx_fecha = #{txFecha}
                    """
    )
    void updatePedido(CreatePedidoDto pedido);

    // Funcion findPedidoInfoByPedidoId
        @Select(
                """
                SELECT id_pedido, fecha_pedido, cantidad_pedido, subtotal_pedido, estado_pedido, ci_usuario, fecha_entrega
                FROM pedido
                WHERE id_pedido = #{idPedido}
                """
        )
        CreatePedidoDto findPedidoInfoByPedidoId(Integer idPedido);

        // Eliminacion pedido por id_pedido
        @Delete(
                """
                DELETE FROM pedido
                WHERE id_pedido = #{idPedido}
                """
        )
        void deletePedido(Integer idPedido);

        // Funcion findPedidoByUsuarioId
        @Select(
                """
                SELECT id_pedido, fecha_pedido, cantidad_pedido, subtotal_pedido, estado_pedido, ci_usuario, fecha_entrega
                FROM pedido
                WHERE id_usuario = #{idUsuario}
                """
        )
        List<PedidoDatoDto> findPedidosByUsuarioId(Integer idUsuario);

        // Funcion findPedidoInfoByCIUsuario
        @Select(
                """
                SELECT id_pedido, fecha_pedido, cantidad_pedido, subtotal_pedido, estado_pedido, ci_usuario, fecha_entrega
                FROM pedido
                WHERE ci_usuario = #{ciUsuario}
                """
        )
        List<PedidoDatoDto> findPedidosByCIUsuario(String ciUsuario);
        


                
    
    

    
}
