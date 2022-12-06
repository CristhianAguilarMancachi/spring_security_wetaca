package bo.edu.ucb.sis213.wetaca.bl;

import bo.edu.ucb.sis213.wetaca.dao.WcPasswordRecoveryDao;
import bo.edu.ucb.sis213.wetaca.dao.Wtc_usuarioDao;
import bo.edu.ucb.sis213.wetaca.dto.PasswordRecoveryDto;
import bo.edu.ucb.sis213.wetaca.entity.WcPasswordRecovery;
import bo.edu.ucb.sis213.wetaca.util.WetacaException;

import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class PasswordRecoveryBl {
    private final WcPasswordRecoveryDao frPasswordRecoveryDao;
    private final Wtc_usuarioDao wcUserDao;

    public PasswordRecoveryBl(WcPasswordRecoveryDao frPasswordRecoveryDao , Wtc_usuarioDao wcUserDao) {
        this.frPasswordRecoveryDao = frPasswordRecoveryDao;
        this.wcUserDao = wcUserDao;
    }

    /**
     * Metodo que permite crear un código de recuperacion de contraseña
     * @param passwordRecoveryDto
     */
    public void createPasswordRecovery(PasswordRecoveryDto passwordRecoveryDto) {
        WcPasswordRecovery frPasswordRecovery = new WcPasswordRecovery();
        Integer userId = wcUserDao.findUserIdByEmail(passwordRecoveryDto.getEmail());

        //Verificar si el correo está en uso
        if(userId == null){
            throw new WetacaException("El correo ingresado no existe");
        }else{
            frPasswordRecovery.setUserId(userId);
        }

        //Encriptamos el codigo de recuperacion
        //String code = BCrypt.withDefaults().hashToString(12, passwordRecoveryDto.getCodeHash().toCharArray());
        frPasswordRecovery.setCodeHash(passwordRecoveryDto.getCodeHash());

        //Establecemos la fecha de expiracion del codigo (5 minutos)
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date()); // Configuramos la fecha
        calendar.add(Calendar.MINUTE, 5);
        frPasswordRecovery.setExpirationDate(calendar.getTime());

        try {
            this.frPasswordRecoveryDao.insertRecoveryAttempt(frPasswordRecovery);
        }catch (Exception e) {
            e.printStackTrace();
            throw new WetacaException("Error al crear el codigo de recuperacion");

        }
    }


    /**
     * Metodo que permite verificar si un codigo de recuperacion de contraseña es valido
     * @param passwordRecoveryDto
     * @return boolean
     */
    public boolean isCodeValid(PasswordRecoveryDto passwordRecoveryDto) {

        Integer userId = wcUserDao.findUserIdByEmail(passwordRecoveryDto.getEmail());
        //Verificar si el correo está en uso
        if(userId == null){
            throw new WetacaException("El correo ingresado no existe");
        }
        System.out.println(userId);

        //Encriptamos el codigo de recuperacion
        //String codeHash = BCrypt.withDefaults().hashToString(12, passwordRecoveryDto.getCodeHash().toCharArray());
        //System.out.println(codeHash);

        String codeHash = passwordRecoveryDto.getCodeHash();
        Date expirationDate = this.frPasswordRecoveryDao.findExpirationDate(userId,codeHash);
        System.out.println(expirationDate);
        if (expirationDate == null) {
            throw new WetacaException("Codigo de recuperacion no existe");
        }else{
            Date currentDate = new Date();
            if (currentDate.after(expirationDate)) {
                throw new WetacaException("Codigo de recuperacion expirado");
            }else{
                return true;
            }
        }
    }
}
