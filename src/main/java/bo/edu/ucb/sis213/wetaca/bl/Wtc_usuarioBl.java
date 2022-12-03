package bo.edu.ucb.sis213.wetaca.bl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import bo.edu.ucb.sis213.wetaca.dao.Wtc_usuarioDao;
import bo.edu.ucb.sis213.wetaca.dao.UserPersonDao;
import bo.edu.ucb.sis213.wetaca.dto.CreateUserDto;
import bo.edu.ucb.sis213.wetaca.entity.Wtc_usuario;
import bo.edu.ucb.sis213.wetaca.entity.UserPerson;
import org.springframework.stereotype.Service;

@Service
//Clase que contiene los metodos de negocio de la entidad Wtc_usuario
public class Wtc_usuarioBl {
    private Wtc_usuarioDao mrUserDao; //Se declara el objeto de tipo Wtc_usuarioDao
    private UserPersonDao userPersonDao; //Se declara el objeto de tipo UserPersonDao

    //Constructor de la clase
    public Wtc_usuarioBl(Wtc_usuarioDao mrUserDao, UserPersonDao userPersonDao) {
        this.mrUserDao = mrUserDao; 
        this.userPersonDao = userPersonDao;
    }

    //Metodo que permite crear un usuario
    public void createUser(CreateUserDto createUserDto) {
        Wtc_usuario mrUser = new Wtc_usuario();
        mrUser.setCi_wtc_usuario(createUserDto.getUsername());
        // Encriptar la contraseña
        String secret = BCrypt.withDefaults().hashToString(12,createUserDto.getSecret().toCharArray());
        mrUser.setNombre_wtc_usuario(secret);
        this.mrUserDao.agregarNuevoUsuario(mrUser);
    }

    public UserPerson findByUsername(String username) {
        return userPersonDao.findByUsername(username);
    }
}
