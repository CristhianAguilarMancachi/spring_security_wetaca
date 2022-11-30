package bo.edu.ucb.sis213.wetaca.bl;

import bo.edu.ucb.sis213.wetaca.dao.PlatoDao;
import bo.edu.ucb.sis213.wetaca.dao.UserDao;
import bo.edu.ucb.sis213.wetaca.dto.PlatoDto;
import bo.edu.ucb.sis213.wetaca.entity.WtcPlato;

public class PlatoBl {
    private final PlatoDao platoDao;

    private final UserDao userDao;

    public PlatoBl(PlatoDao platoDao, UserDao userDao) {
        this.platoDao = platoDao;
        this.userDao = userDao;
    }

    public void createPlato(PlatoDto platoDto) {
        if(isTimeAfterNow(createPlatoDto.get)){
            throw new WetacaException("SCTY-1008");
        }
        WtcPlato plato = new WtcPlato();
        plato.setId_plato(userDao);

        
    }


}
