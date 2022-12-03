package bo.edu.ucb.sis213.wetaca.bl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import bo.edu.ucb.sis213.wetaca.dao.RoleDao;
import bo.edu.ucb.sis213.wetaca.dao.Wtc_usuarioDao;
import bo.edu.ucb.sis213.wetaca.dto.AuthReqDto;
import bo.edu.ucb.sis213.wetaca.dto.AuthResDto;
import bo.edu.ucb.sis213.wetaca.dto.Wtc_usuarioDto;
import bo.edu.ucb.sis213.wetaca.entity.Cargo;
import bo.edu.ucb.sis213.wetaca.entity.Wtc_usuario;
import bo.edu.ucb.sis213.wetaca.util.WetacaException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SecurityBl {

    public final static String JWT_SECRET = "2022";
    private Wtc_usuarioDao mrUserDao;

    private RoleDao mrRoleDao;


    public SecurityBl(Wtc_usuarioDao mrUserDao, RoleDao mrRoleDao) {
        this.mrUserDao = mrUserDao;
        this.mrRoleDao = mrRoleDao;
    }

    /**
     * Método realizado para probar la conexión a la BBDD
     * @param userId
     * @return
     */
    public Wtc_usuarioDto getUserByPk(Integer userId) {
        Wtc_usuario mrUser = mrUserDao.findByPrimaryKey(userId); // Se obtiene el usuario de la BBDD
        // Transformamos la entidad de Base de Datos
        // a un DTO para retornar via API  (Data Transfer Object)
        Wtc_usuarioDto userDto = new Wtc_usuarioDto(mrUser.getId_wtc_usuario(), mrUser.getCi_wtc_usuario());
        return userDto;
    }

    /**
     * Este metodo realiza la autenticación del sistema, va a buscar al repositorio de BBDD
     * la contraseña del usuario y la compara con su equivalente en BCRYPT
     * @param credentials
     * @return
     */
    public AuthResDto authenticate(AuthReqDto credentials) {
        AuthResDto result = new AuthResDto();
        System.out.println("Comenzando proceso de autenticación con: " + credentials);
        String currentPasswordInBCrypt = mrUserDao.findSecretByUsername(credentials.username());
        System.out.println("Se obtuvo la siguiente contraseña de bbdd: " + currentPasswordInBCrypt);
        // Consulto si los passwords coinciden
        if (currentPasswordInBCrypt != null ) {
            System.out.println("Se procede a verificar si las contraseñas coinciden");
            BCrypt.Result bcryptResult = BCrypt.verifyer().verify(credentials.password().toCharArray(), currentPasswordInBCrypt);
            if (bcryptResult.verified) { // Ha sido verificado
                // Procedo a generar el token
                System.out.println("Las constraseñas coinciden se genera el token");
                // Consultamos los roles que tiene el usuario
                List<Cargo> roles = mrRoleDao.findRolesByUsername(credentials.username());
                List<String> rolesAsString = new ArrayList<>();
                for ( Cargo role : roles) {
                    rolesAsString.add(role.getName());
                }
                // Con esto no será necesario refrescar token.
                // FIXME: Error de seguridad, los tokens deberían ser de corta duración.
                result = generateTokenJwt(credentials.username(), 30000, rolesAsString);

            } else {
                System.out.println("Las constraseñas no coinciden");
                throw new WetacaException("Forbiden the secret and password are wrong.");
            }
        } else {
            System.out.println("Usuario no existente");
            throw new WetacaException("El usuario y contraseña son incorrectos.");
        }
        return result;
    }

    /** Este metodo valida un token JWT y retorna un MrUser
     * @param token
     * @return
     */
    public Wtc_usuario validateJwtToken(String jwt) {
        System.out.printf("VAlidando token: " + jwt);
        Wtc_usuario result = null;
        try {
            String username = JWT.require(Algorithm.HMAC256(JWT_SECRET))
                    .build()
                    .verify(jwt)
                    .getSubject();
            result = mrUserDao.findByUsername(username);
        } catch (Exception exception){
            throw new WetacaException("El usuario y cotraseña son incorrectos.", exception);
        }
        return result;
    }


    /** Este metodo generea tokens JWT */
    private AuthResDto generateTokenJwt(String subject, int expirationTimeInSeconds, List<String> roles) {
        AuthResDto result = new AuthResDto();
        // Generar el token princpial
        try {
            Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
            String token = JWT.create()
                    .withIssuer("ucb")
                    .withSubject(subject)
                    .withArrayClaim("roles", roles.toArray(new String[roles.size()]))
                    .withClaim("refresh", false)
                    .withExpiresAt(new Date(System.currentTimeMillis() + (expirationTimeInSeconds * 1000)))
                    .sign(algorithm);
            result.setToken(token);
            String refreshToken = JWT.create()
                    .withIssuer("ucb")
                    .withSubject(subject)
                    .withClaim("refresh", true)
                    .withExpiresAt(new Date(System.currentTimeMillis() + (expirationTimeInSeconds * 1000 * 2)))
                    .sign(algorithm);
            result.setRefresh(refreshToken);
        } catch (JWTCreationException exception){
            throw new WetacaException("Error al generar el token", exception);
        }
        return result;
    }


}
