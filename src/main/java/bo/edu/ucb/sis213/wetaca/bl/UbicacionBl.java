package bo.edu.ucb.sis213.wetaca.bl;

import bo.edu.ucb.sis213.wetaca.dao.UbicacionDao;

//clase que contiene los metodos de negocio para obtener la ubicacion de un usuario

public class UbicacionBl {
private UbicacionDao ubicacionDao; //Se declara el objeto de tipo UbicacionDao

//Constructor de la clase
public UbicacionBl(UbicacionDao ubicacionDao) {
    this.ubicacionDao = ubicacionDao;
}


}
