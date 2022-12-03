package bo.edu.ucb.sis213.wetaca.bl;

import org.springframework.stereotype.Service;

import bo.edu.ucb.sis213.wetaca.dao.PedidoDao;
import bo.edu.ucb.sis213.wetaca.dao.Wtc_usuarioDao;
import bo.edu.ucb.sis213.wetaca.entity.Pedido;
import bo.edu.ucb.sis213.wetaca.util.WetacaException;

@Service
public class PedidoBl {
    private final PedidoDao platoDao;
    private final Wtc_usuarioDao userDao;

    public PedidoBl(PedidoDao pedidoDao, Wtc_usuarioDao userDao) {
        this.pedidoDao = pedidoDao;
        this.userDao = userDao;

    }

    public void createPedido(String userName, PedidoDatoDto createPedidoDto) {
        // Crear el plato
        Pedido pedido = new Pedido();
        pedido.setId_wtc_usuario(userDao.buscarIdUsuarioPorUserName(userName));
        pedido.setNombre(createPedidoDto.getNombre());
        pedido.setDescripcion(createPedidoDto.getDescripcion());
        pedido.setIngredientes(createPedidoDto.getIngredientes());
        pedido.setCategoria(createPedidoDto.getCategoria());
        pedido.setPrecio(createPedidoDto.getPrecio());
        this.pedidoDao.createPedido(pedido);
    }

    // funcion findPedidoInfoByPedidoId similar a findPlatoInfoByPlatoId
    public PedidoInfo findPedidoInfoByPedidoId(Integer pedidoId) {
        PedidoInfo pedidoInfo = pedidoDao.findPedidoInfoByPedidoId(pedidoId);
        if(pedidoInfo == null) {
            throw new WetacaException("Pedido no encontrado");
        }
        return pedidoInfo;
    }

    // funcion void updatePedido similar a void updatePlato
    public void updatePedido(Integer pedidoId, PedidoDatoDto updatePedidoDto) {
        Pedido pedido = pedidoDao.findPedidoByPedidoId(pedidoId);
        if(pedido == null) {
            throw new WetacaException("Pedido no encontrado");
        }
        pedido.setNombre(updatePedidoDto.getNombre());
        pedido.setDescripcion(updatePedidoDto.getDescripcion());
        pedido.setIngredientes(updatePedidoDto.getIngredientes());
        pedido.setCategoria(updatePedidoDto.getCategoria());
        pedido.setPrecio(updatePedidoDto.getPrecio());
        pedidoDao.updatePedido(pedido);
    }

    // Eliminacion pedido por id
    public void deletePedido(Integer pedidoId) {
        Pedido pedido = pedidoDao.findPedidoByPedidoId(pedidoId);
        if(pedido == null) {
            throw new WetacaException("Pedido no encontrado");
        }
        pedidoDao.deletePedido(pedido);
    }

    // Listado de pedidos
    public List<PedidoInfo> findAllPedidos() {
        return pedidoDao.findAllPedidos();
    }

    // Listado de pedidos por usuario
    public List<PedidoInfo> findPedidosByUserId(Integer userId) {
        return pedidoDao.findPedidosByUserId(userId);
    }

    // Listado de pedidos por categoria
    public List<PedidoInfo> findPedidosByCategoria(String categoria) {
        return pedidoDao.findPedidosByCategoria(categoria);
    }

    /* 
    // Listado de los platos
    public List<PlatoInfo> findPlatoInfoByUserName(String userName) {
        List<PlatoInfo> platoInfo = platoDao.findPlatoInfoByUserName(userName);
        if (platoInfo.isEmpty()) {
            throw new WetacaException("");
        }
        return platoInfo;
    }

    // Datos mascota perfil
    public PlatoData findPlatoByPlatoId(Integer petId) {
        PlatoData platoData = platoDao.findPlatoDataByPlatoId(petId);
        if (platoData == null) {
            throw new WetacaException("");
        }
        return platoData;
    }*/

}
