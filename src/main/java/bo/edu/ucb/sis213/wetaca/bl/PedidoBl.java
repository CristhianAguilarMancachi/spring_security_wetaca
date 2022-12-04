package bo.edu.ucb.sis213.wetaca.bl;

import java.util.List;

import org.springframework.stereotype.Service;

import bo.edu.ucb.sis213.wetaca.dao.PedidoDao;
//import bo.edu.ucb.sis213.wetaca.dao.Wtc_usuarioDao;
import bo.edu.ucb.sis213.wetaca.dto.CreatePedidoDto;
import bo.edu.ucb.sis213.wetaca.dto.PedidoDatoDto;
import bo.edu.ucb.sis213.wetaca.entity.Pedido;
import bo.edu.ucb.sis213.wetaca.util.WetacaException;

@Service
public class PedidoBl {
    private final PedidoDao pedidoDao;
    //private final Wtc_usuarioDao userDao;

    public PedidoBl(PedidoDao pedidoDao
    //, Wtc_usuarioDao userDao
    ) {
        this.pedidoDao = pedidoDao;
        //this.userDao = userDao;

    }

    public void createPedido(String userName, CreatePedidoDto createPedidoDto) {
        // Crear el plato
        Pedido pedido = new Pedido();
        pedido.setFechaPedido(createPedidoDto.getFechaPedido());
        pedido.setSubtotal(createPedidoDto.getSubtotal());
        pedido.setCiUsuario(createPedidoDto.getCiUsuario());
        pedido.setFechaEntrega(createPedidoDto.getFechaEntrega());
        this.pedidoDao.createPedido(pedido);
    }

    // funcion findPedidoInfoByPedidoId similar a findPlatoInfoByPlatoId
    public CreatePedidoDto findPedidoInfoByPedidoId(Integer pedidoId) {
        CreatePedidoDto pedidoInfo = pedidoDao.findPedidoInfoByPedidoId(pedidoId);
        if(pedidoInfo == null) {
            throw new WetacaException("Pedido no encontrado");
        }
        return pedidoInfo;
    }

    // funcion void updatePedido similar a void updatePlato
    public void updatePedido(Integer pedidoId, CreatePedidoDto updatePedidoDto) {
        CreatePedidoDto pedido = pedidoDao.findPedidoInfoByPedidoId(pedidoId);
        if(pedido == null) {
            throw new WetacaException("Pedido no encontrado");
        }
        pedido.setFechaPedido(updatePedidoDto.getFechaPedido());
        pedido.setSubtotal(updatePedidoDto.getSubtotal());
        pedido.setCantidad(updatePedidoDto.getCantidad());
        pedido.setCiUsuario(updatePedidoDto.getCiUsuario());
        pedido.setFechaEntrega(updatePedidoDto.getFechaEntrega());
        pedidoDao.updatePedido(pedido);
    }

    // Eliminacion pedido por id
    public void deletePedido(Integer pedidoId) {
        CreatePedidoDto pedido = pedidoDao.findPedidoInfoByPedidoId(pedidoId);
        if(pedido == null) {
            throw new WetacaException("Pedido no encontrado");
        }
        pedidoDao.deletePedido(pedidoId);
    }

    // Listado de pedidos
    public List<CreatePedidoDto> findAllPedidos() {
        List<CreatePedidoDto> pedido = pedidoDao.findAllPedidos();
        if(pedido == null) {
            throw new WetacaException("Pedido no encontrado");
        }
        return pedido;
    }

    // Listado de pedidos por usuario
    public List<PedidoDatoDto> findPedidosByUserId(Integer userId) {
        List<PedidoDatoDto> pedido = pedidoDao.findPedidosByUsuarioId(userId);
        if(pedido == null) {
            throw new WetacaException("Pedido no encontrado");
        }
        return pedido;
    }


}
