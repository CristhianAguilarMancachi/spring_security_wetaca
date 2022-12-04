package bo.edu.ucb.sis213.wetaca.bl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import bo.edu.ucb.sis213.wetaca.dao.CargoDao;
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
public class SeguridadBl {

    public final static String JWT_SECRET = "2022";
    private Wtc_usuarioDao mrUserDao;
    private CargoDao mrCargo;

    //Constructor de la clase
    public SeguridadBl(Wtc_usuarioDao mrUserDao, CargoDao mrCargo) {
        this.mrUserDao = mrUserDao;
        this.mrCargo = mrCargo;
    }

    /**
     * Método realizado para probar la conexión a la BBDD
     * @param userId
     * @return
     */
    public Wtc_usuarioDto getUserByPk(Integer userId) {
        Wtc_usuario mrUser = mrUserDao.buscarUserNamePorId(userId); // Se obtiene el usuario de la BBDD
        // Transformamos la entidad de Base de Datos
        // a un DTO para retornar via API  (Data Transfer Object)
        Wtc_usuarioDto userDto = new Wtc_usuarioDto(mrUser.getId_wtc_usuario(), mrUser.getCi_wtc_usuario(), 
        mrUser.getNombre_wtc_usuario(), mrUser.getApellido_wtc_usuario(), mrUser.getCorreo_wtc_usuario(), 
        mrUser.getFono_wtc_usuario(), mrUser.getId_ubicación(), mrUser.getEstado_wtc_usuario(),
        mrUser.getNombreusuario_wtc_usuario(), mrUser.getContrasena_wtc_usuario());
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
        String currentPasswordInBCrypt = mrUserDao.buscarPasswordPorUserName(credentials.username());
        System.out.println("Se obtuvo la siguiente contraseña de bbdd: " + currentPasswordInBCrypt);
        // Consulto si los passwords coinciden
        if (currentPasswordInBCrypt != null ) {
            System.out.println("Se procede a verificar si las contraseñas coinciden");
            BCrypt.Result bcryptResult = BCrypt.verifyer().verify(credentials.password().toCharArray(), currentPasswordInBCrypt);
            if (bcryptResult.verified) { // Ha sido verificado
                // Procedo a generar el token
                System.out.println("Las constraseñas coinciden se genera el token");
                // Consultamos los roles que tiene el usuario
                /*List<Cargo> roles = mrCargo.buscarCargoByUsername(credentials.username()); // Se obtiene el usuario de la BBDD
                List<String> rolesAsString = new ArrayList<>(); // Lista de roles en formato String
                for ( Cargo role : roles) {
                    rolesAsString.add(role.getDescripcion_cargo());
                }*/
                // Con esto no será necesario refrescar token.
                // FIXME: Error de seguridad, los tokens deberían ser de corta duración.
                result = generateTokenJwt(credentials.username(), 300000);

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
        System.out.println("Validando token: " + jwt);
        Wtc_usuario result = null;
        try {
            String username = JWT.require(Algorithm.HMAC256(JWT_SECRET)) // Se verifica la firma
                    .build() // Se construye el objeto
                    .verify(jwt) // Se verifica el token
                    .getSubject(); // Se obtiene el subject
            result = mrUserDao.buscarUsuarioPorUserName(username); // Se obtiene el usuario de la BBDD
        } catch (Exception exception){
            throw new WetacaException("El usuario y cotraseña son incorrectos.", exception);
        }
        return result;
    }


    /** Este metodo generea tokens JWT */
    private AuthResDto generateTokenJwt(String subject, int expirationTimeInSeconds) {
        AuthResDto result = new AuthResDto();
        // Generar el token princpial
        try {
            Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
            // Se genera el token
            String token = JWT.create()
                    .withIssuer("ucb") // Quien lo emite
                    .withSubject(subject) // Quien lo usa
                    //.withArrayClaim("roles", roles.toArray(new String[roles.size()])) // Los roles
                    .withClaim("refresh", false) // Es un token de acceso
                    .withExpiresAt(new Date(System.currentTimeMillis() + (expirationTimeInSeconds * 100000))) // Tiempo de expiración
                    .sign(algorithm); // Algoritmo de encriptación
            result.setToken(token); // Se asigna el token

            // Generar el token de refresco
            String refreshToken = JWT.create()
                    .withIssuer("ucb") // Quien lo emite
                    .withSubject(subject) // Quien lo usa
                    .withClaim("refresh", true) // Es un token de refresco
                    .withExpiresAt(new Date(System.currentTimeMillis() + (expirationTimeInSeconds * 100000 * 2))) // Tiempo de expiración
                    .sign(algorithm); // Algoritmo de encriptación
            result.setRefresh(refreshToken); // Se asigna el token de refresco
        } catch (JWTCreationException exception){
            throw new WetacaException("Error al generar el token", exception);
        }
        return result;
    }


}
