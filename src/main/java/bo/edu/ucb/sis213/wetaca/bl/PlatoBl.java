package bo.edu.ucb.sis213.wetaca.bl;

import java.util.List;

import org.springframework.stereotype.Service;

import bo.edu.ucb.sis213.wetaca.dao.PlatoDao;
import bo.edu.ucb.sis213.wetaca.dao.Wtc_usuarioDao;
import bo.edu.ucb.sis213.wetaca.dto.PlatoDatoDto;
import bo.edu.ucb.sis213.wetaca.entity.Plato;
import bo.edu.ucb.sis213.wetaca.util.WetacaException;

// El procesamiento de informacion, validacion de los Daos
@Service
public class PlatoBl {
    private final PlatoDao platoDao;
    private final Wtc_usuarioDao userDao;

    public PlatoBl(PlatoDao platoDao, Wtc_usuarioDao userDao) {
        this.platoDao = platoDao;
        this.userDao = userDao;

    }

    public void createPlato(PlatoDatoDto createPlatoDto, String userName) {
        // Crear el plato
        Plato plato = new Plato();
        plato.setId_wtc_usuario(userDao.findUserIdByUserName(userName));
        plato.setNombre(createPlatoDto.getNombre());
        plato.setDescripcion(createPlatoDto.getDescripcion());
        plato.setIngredientes(createPlatoDto.getIngredientes());
        plato.setCategoria(createPlatoDto.getCategoria());
        plato.setPrecio(createPlatoDto.getPrecio());
        this.platoDao.createPlato(plato);
    }

    public PlatoInfo findPlatoInfoByPlatoId(Integer platoId) {
        PlatoInfo platoInfo = platoDao.findPlatoInfoByPlatoId(platoId);
        if (platoInfo == null) {
            throw new WetacaException("");
        }
        return platoInfo;
    }

    public void updatePlato(Integer platoId, PlatoDatoDto platoData) {
        Plato plato = platoDao.findPlatoByPlatoId(platoId);
        if (plato == null) {
            throw new WetacaException("");
        }
        plato.setIdPlato(platoId);
        plato.setNombre(platoData.getNombre());
        plato.setDescripcion(platoData.getDescripcion());
        plato.setPrecio(platoData.getPrecio());
        plato.setIngredientes(plato.getIngredientes());

        this.platoDao.updatePlato(plato);
    }
    //Eliminación plato por id
    public void deletePlato(Integer platoId) {
        Plato pet = platoDao.findPlatoByPlatoId(platoId);
        if (pet == null) {
            throw new WetacaException("");
        }
        this.platoDao.deletePlato(platoId);
    }

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
    }

}
