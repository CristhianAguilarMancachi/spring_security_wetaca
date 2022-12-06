package bo.edu.ucb.sis213.wetaca.bl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import bo.edu.ucb.sis213.wetaca.dao.UserDao;
import bo.edu.ucb.sis213.wetaca.dao.Wtc_usuarioDao;
import bo.edu.ucb.sis213.wetaca.dto.CreateUsuarioDto;
import bo.edu.ucb.sis213.wetaca.entity.Wtc_usuario;
import org.springframework.stereotype.Service;

@Service
//Clase que contiene los metodos de negocio de la entidad Wtc_usuario
public class Wtc_usuarioBl {
    private Wtc_usuarioDao mrUserDao; //Se declara el objeto de tipo Wtc_usuarioDao
    private UserDao userPersonDao; //Se declara el objeto de tipo UserPersonDao

    //Constructor de la clase
    public Wtc_usuarioBl(Wtc_usuarioDao mrUserDao, UserDao userPersonDao) {
        this.mrUserDao = mrUserDao; 
        this.userPersonDao = userPersonDao;
    }

    //Metodo que permite crear un usuario
    public void crearUsuario(CreateUsuarioDto createUserDto) {
        Wtc_usuario mrUser = new Wtc_usuario(); //Se crea un objeto de tipo Wtc_usuario
        mrUser.setCi_wtc_usuario(createUserDto.getUsername()); //Se asigna el nombre de usuario
        // Encriptar la contraseña
        String secret = BCrypt.withDefaults().hashToString(12,createUserDto.getSecret().toCharArray()); 
        mrUser.setNombre_wtc_usuario(secret); //Se asigna la contraseña encriptada
        this.mrUserDao.agregarNuevoUsuario(mrUser); //
    }


    //Metodo para buscar un usuario por su nombre de usuario
    public Wtc_usuario buscarNombreUsuario(String username) {
        return userPersonDao.buscarUsuarioPorUserName(username);
    }
}
