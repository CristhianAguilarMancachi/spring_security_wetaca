package bo.edu.ucb.sis213.wetaca.util;

import bo.edu.ucb.sis213.wetaca.bl.SeguridadBl;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

import java.util.List;
import java.util.Map;

public class AuthUtil {
    /**
     * Recibimos el token JWT y si sale bien, retornamos el sub, caso controraio lanzamos una excepcion
     * @param jwtToken
     * @return
     */
    // este metodo verifica el token
    public static String isUserAuthenticated(String jwt) {
        String subject = null;
        try {
             subject = JWT.require(Algorithm.HMAC256(SeguridadBl.JWT_SECRET))
                    .build()
                    .verify(jwt)
                    .getSubject();
        } catch (JWTVerificationException ex) {
            throw new WetacaException("Usuario no autenticado" + ex.getMessage());
        }
        return subject;
    }

    public static String getTokenFromHeader(Map<String, String> headers) {
        if (headers.get("Authorization") == null && headers.get("authorization") == null ) {
            throw new WetacaException("No se ha enviado el token de autorización");
        }
        // Se acostumbra que cuando se envia el token, se lo envia en el siguiente formato
        // Authorization: Bearer TOKEN
        String jwt = "";
        if (headers.get("Authorization") != null) {
            jwt = headers.get("Authorization").split(" ")[1];
        } else {
            jwt = headers.get("authorization").split(" ")[1];
        }
        return jwt;
    }
    /**
     * Recibimos el token JWT y verificamos si tiene un rol en particular
     * @param jwtToken
     * @return true si tiene el rol y false si no lo tiene
     */
    public static boolean tokenHasRole(String jwt, String role) {
        List<String> roles = JWT.require(Algorithm.HMAC256(SeguridadBl.JWT_SECRET))
                .build()
                .verify(jwt)
                .getClaim("roles").asList(String.class);
        return roles.contains(role);
    }

    /**
     * Recibimos el token JWT y verificamos si tiene un rol en particular, si no lo tiene se lanza excepción
     * @param jwtToken
     */
    public static void verifyHasRole(String jwt, String role) {
        List<String> roles = JWT.require(Algorithm.HMAC256(SeguridadBl.JWT_SECRET))
                .build()
                .verify(jwt)
                .getClaim("roles").asList(String.class);
        if(!roles.contains(role)) {
            throw new WetacaException("No tiene permisos para realizar esta acción");
        }
    }

    // Funcion que nos permite obtener el id del usuario que esta autenticado || funcion de prueba
    public static String getUserNameFromToken(String jwt) {
        return JWT.require(Algorithm.HMAC256(SeguridadBl.JWT_SECRET))
                .build()
                .verify(jwt)
                .getClaim("username").asString();
    }
}
