package bo.edu.ucb.sis213.wetaca.bl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import bo.edu.ucb.sis213.wetaca.dao.UserDao;
import bo.edu.ucb.sis213.wetaca.dao.UserPersonDao;
import bo.edu.ucb.sis213.wetaca.dto.CreateUserDto;
import bo.edu.ucb.sis213.wetaca.entity.WtcUsuario;
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

    public void createUser(CreateUserDto createUserDto) {
        WtcUsuario mrUser = new WtcUsuario();
        mrUser.setUsername(createUserDto.getUsername());
        // Encrypt secret with BCrypt
        String secret = BCrypt.withDefaults().hashToString(12,
                createUserDto.getSecret().toCharArray());
        mrUser.setSecret(secret);
        this.mrUserDao.createUser(mrUser);
    }

    public UserPerson findByUsername(String username) {
        return userPersonDao.findByUsername(username);
    }
}