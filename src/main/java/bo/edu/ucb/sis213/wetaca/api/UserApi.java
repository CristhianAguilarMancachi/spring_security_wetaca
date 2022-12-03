package bo.edu.ucb.sis213.wetaca.api;

import bo.edu.ucb.sis213.wetaca.bl.SeguridadBl;
import bo.edu.ucb.sis213.wetaca.bl.Wtc_usuarioBl;
import bo.edu.ucb.sis213.wetaca.dto.CrearUsuarioDto;
import bo.edu.ucb.sis213.wetaca.dto.ResponseDto;
import bo.edu.ucb.sis213.wetaca.entity.UserPerson;
import bo.edu.ucb.sis213.wetaca.util.AuthUtil;
import bo.edu.ucb.sis213.wetaca.util.WetacaException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
public class UserApi {
    private Wtc_usuarioBl userBl;
    private SeguridadBl securityBl;

    public UserApi(Wtc_usuarioBl userBl, SeguridadBl securityBl) {
        this.userBl = userBl;
        this.securityBl = securityBl;
    }

    @PostMapping
    public ResponseDto<String> createUser(@RequestHeader Map<String, String> headers, @RequestBody CrearUsuarioDto createUserDto) {
        try {
            String jwt = AuthUtil.getTokenFromHeader(headers);
            // Si no tiene error, se lanzaraá una excepción
            AuthUtil.verifyHasRole(jwt, "CREAR_USUARIO"); // Authorization
            userBl.crearUsuario(createUserDto);
            return new ResponseDto<>("Usuario creado correctamente", null, true);
        } catch (WetacaException ex) {
            return new ResponseDto<>(ex.getMessage(), null, false);
        }
    }

    /**
     * Endpoint para probar la busqueda por llave primaria
     * @param userId
     * @return
     */
    @GetMapping("/")
    public ResponseDto<UserPerson> getUserFromToken(@RequestHeader Map<String, String> headers) {
        try {
            Thread.sleep(3000);
        } catch (Exception ex) {
            // Do nothing
        }
        try {
            String username = AuthUtil.isUserAuthenticated(AuthUtil.getTokenFromHeader(headers));
            return new ResponseDto<>(this.userBl.findByUsername(username), null, true);
        }
        catch (WetacaException ex) {
            return new ResponseDto<>(null, ex.getMessage(), false);
        }
    }

}
