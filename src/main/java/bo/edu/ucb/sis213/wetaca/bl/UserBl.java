package bo.edu.ucb.sis213.wetaca.bl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import bo.edu.ucb.sis213.wetaca.dao.UserDao;
import bo.edu.ucb.sis213.wetaca.dao.UserPersonDao;
import bo.edu.ucb.sis213.wetaca.dto.CrearUsuarioDto;
import bo.edu.ucb.sis213.wetaca.entity.Wtc_usuario;
import bo.edu.ucb.sis213.wetaca.entity.UserPerson;
import org.springframework.stereotype.Service;

@Service
public class UserBl {
    private UserDao mrUserDao;
    private UserPersonDao userPersonDao;

    public UserBl(UserDao mrUserDao, UserPersonDao userPersonDao) {
        this.mrUserDao = mrUserDao;
        this.userPersonDao = userPersonDao;
    }

    public void createUser(CrearUsuarioDto createUserDto) {
        Wtc_usuario mrUser = new Wtc_usuario();
        mrUser.setCi_wtc_usuario(createUserDto.getNombreUsuario_wtc_usuario());
        // Encrypt secret with BCrypt
        String secret = BCrypt.withDefaults().hashToString(12,
                createUserDto.getContrasena_wtc_usuario().toCharArray());
        mrUser.setNombre_wtc_usuario(secret);
        this.mrUserDao.createUser(mrUser);
    }

    public UserPerson findByUsername(String username) {
        return userPersonDao.findByUsername(username);
    }
}
