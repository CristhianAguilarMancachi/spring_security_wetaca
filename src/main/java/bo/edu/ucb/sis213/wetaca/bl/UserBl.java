package bo.edu.ucb.sis213.wetaca.bl;

import at.favre.lib.crypto.bcrypt.BCrypt;

import bo.edu.ucb.sis213.wetaca.dao.Wtc_usuarioDao;
import bo.edu.ucb.sis213.wetaca.dto.CreateUsuarioDto;
import bo.edu.ucb.sis213.wetaca.entity.Wtc_usuario;
import bo.edu.ucb.sis213.wetaca.util.WetacaException;
import org.springframework.stereotype.Service;

@Service
public class UserBl {
    private Wtc_usuarioDao wcUserDao;

    public UserBl(Wtc_usuarioDao wcUserDao) {
        this.wcUserDao = wcUserDao;
    }

    /**
     * Crear un nuevo usuario
     * @param createUserDto
     * @throws WetacaException
     */
    public void createUser(CreateUsuarioDto createUserDto){
        Wtc_usuario wcUser = new Wtc_usuario();
        wcUser.setCi_wtc_usuario(createUserDto.getCiuser());
        wcUser.setNombre_wtc_usuario(createUserDto.getFirstName());
        wcUser.setApellido_wtc_usuario(createUserDto.getLastName());
        wcUser.setCorreo_wtc_usuario(createUserDto.getEmail());
        wcUser.setFono_wtc_usuario(createUserDto.getFono());
        wcUser.setNombreusuario_wtc_usuario(createUserDto.getUsername());
        
        //Encriptamos la constraseña con BCrypt
        String secret = BCrypt.withDefaults().hashToString(12, createUserDto.getSecret().toCharArray());
        wcUser.setContrasena_wtc_usuario(secret);

        System.out.println("Se concreto todos los datos");


        //Verificamos si el username ya existe
        if (wcUserDao.findByUsername(createUserDto.getUsername()) == null){
            //Verificamos si el email ya existe
            if (wcUserDao.findByEmail(createUserDto.getEmail()) == null) {
                wcUserDao.createUser(wcUser);
            } else {
                throw new WetacaException("El correo ya está registrado");
            }
        } else {
            throw new WetacaException("El username ya está registrado");
        }
    }

    /**
     * Obtener un usuario por su username
     * @param username
     * @return Wtc_usuario
     * @throws WetacaException
     */
    public Wtc_usuario getUserByUsername(String username){
        Wtc_usuario wcUser = wcUserDao.findByUsername(username);
        System.out.println("username: "+username);
        if (wcUser != null){
            return wcUser;
        } else {
            throw new WetacaException
                ("El usuario no existe");
        }
    }

    /**
     * Método para actualizar la información de un usuario
     * @param userId
     * @param updateUserDto
     */
    public void updateUser(int userId, CreateUsuarioDto updateUserDto){
        Wtc_usuario wcUser = new Wtc_usuario();
        wcUser.setId_wtc_usuario(userId);
        wcUser.setNombreusuario_wtc_usuario(updateUserDto.getUsername());
        wcUser.setNombre_wtc_usuario(updateUserDto.getFirstName());
        wcUser.setApellido_wtc_usuario(updateUserDto.getLastName());
        wcUser.setCorreo_wtc_usuario(updateUserDto.getEmail());
        wcUser.setFono_wtc_usuario(updateUserDto.getFono());
        //Encriptamos la constraseña con BCrupt

        

        //Verificamos si hubo cambios en username o correo
        boolean usernameChanged = false;
        boolean emailChanged = false;
        //Obtenemos el usuario por su id
        Wtc_usuario oldUser = wcUserDao.findById(userId);
        if(oldUser.getNombreusuario_wtc_usuario().equals(updateUserDto.getUsername())){
            if(oldUser.getCorreo_wtc_usuario().equals(updateUserDto.getEmail())){
                wcUserDao.updateUser(wcUser);
            }else {
                emailChanged = true;
            }
        }else{
            usernameChanged = true;
        }

        //Verificamos si el username que se quiere ingresar ya existe
        if (wcUserDao.findByUsername(updateUserDto.getUsername()) == null || !usernameChanged){
            //Verificamos si el email que se quiere ingresar ya existe
            if (wcUserDao.findByEmail(updateUserDto.getEmail()) == null || !emailChanged) {
                wcUserDao.updateUser(wcUser);
            } else {
                throw new WetacaException("El correo se encuentra en uso");
            }
        } else {
            throw new WetacaException("El username se encuentra en uso");
        }
    }

    /**
     * Obtener un usuario por su correo electrónico
     * @param email
     * @return Wtc_usuario
     * @throws WetacaException
     */
    public Wtc_usuario getUserByEmail(String email){
        Wtc_usuario wcUser = wcUserDao.findByEmail(email);
        System.out.println("email: "+email);
        System.out.println("wcUser: "+wcUser);
        if (wcUser != null){
            return wcUser;
        } else {
            throw new WetacaException("El usuario no existe");
        }
    }

    
     /**
     * Método para eliminar un usuario de manera lógica
     * param userId
     
    
    public void deleteUser(int userId){
        fr
        UserDao.deleteUser(userId);
    }
    */

    /**
     * Metodo para actualizar la contraseña de un usuario
     */
    public void updatePassword(String email, String secret){
        //Encriptamos la constraseña con BCrypt
        String secretHash = BCrypt.withDefaults().hashToString(12, secret.toCharArray());
        wcUserDao.updatePassword(email, secretHash);
    }
}
