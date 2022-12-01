package bo.edu.ucb.sis213.wetaca.bl;

import bo.edu.ucb.sis213.wetaca.dao.PedidoDao;

public class PedidoBl {
    private final PedidoDao platoDao;

    private final UserDao userDao;

    public PedidoBl(PedidoDao pedidoDao, UserDao userDao) {
        this.pedidoDao = pedidoDao;
        this.userDao = userDao;
    }

    public void createPlato(PlatoDatoDto platoDto) {
        if(isTimeAfterNow(createPlatoDto.get)){
            throw new WetacaException("");
        }
        Plato plato = new Plato();
        plato.setId_plato(userDao);

        
    }
}
