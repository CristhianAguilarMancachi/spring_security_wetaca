package bo.edu.ucb.sis213.wetaca.bl;

import java.util.List;

import org.springframework.stereotype.Service;

import bo.edu.ucb.sis213.wetaca.dao.PlatoDao;
import bo.edu.ucb.sis213.wetaca.dto.CreatePlatoDto;
import bo.edu.ucb.sis213.wetaca.dto.PlatoDatoDto;
import bo.edu.ucb.sis213.wetaca.entity.Plato;
import bo.edu.ucb.sis213.wetaca.util.WetacaException;

// El procesamiento de informacion, validacion de los Daos
@Service
public class PlatoBl {
    private final PlatoDao platoDao;

    public PlatoBl(PlatoDao platoDao) {
        this.platoDao = platoDao;

    }

    public void createPlato(CreatePlatoDto createPlatoDto) {
        // Crear el plato
        Plato plato = new Plato();
        plato.setNombre(createPlatoDto.getNombre());
        plato.setDescripcion(createPlatoDto.getDescripcion());
        plato.setIngredientes(createPlatoDto.getIngredientes());
        plato.setCategoria(createPlatoDto.getCategoria());
        plato.setPrecio(createPlatoDto.getPrecio());
        this.platoDao.createPlato(plato);
    }

    public Plato findPlatoInfoByPlatoId(Integer platoId) {
        Plato platoInfo = platoDao.findPlatoByPlatoId(platoId);
        if (platoInfo == null) {
            throw new WetacaException("");
        }
        return platoInfo;
    }

    public void updatePlato(Integer platoId, CreatePlatoDto platoData) {
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

    // Listado de los platos con platoDao.findALL
    public List<PlatoDatoDto> getPlatos() {
        List<PlatoDatoDto> platoInfo = platoDao.findAllPlatos();
        if (platoInfo.isEmpty()) {
            throw new WetacaException("");
        }
        return platoInfo;
    }

    // Funcion getPlatoInfoByPlatoId
    public PlatoDatoDto getPlato(Integer platoId) {
        PlatoDatoDto platoInfo = platoDao.findPlatoInfoByPlatoId(platoId);
        if (platoInfo == null) {
            throw new WetacaException("");
        }
        return platoInfo;
    }
    

}
