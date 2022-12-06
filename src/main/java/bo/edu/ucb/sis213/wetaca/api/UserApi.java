package bo.edu.ucb.sis213.wetaca.api;

import bo.edu.ucb.sis213.wetaca.bl.UserBl;
import bo.edu.ucb.sis213.wetaca.dto.CreateUsuarioDto;
import bo.edu.ucb.sis213.wetaca.dto.RecoverPasswordDto;
import bo.edu.ucb.sis213.wetaca.dto.ResponseDto;
import bo.edu.ucb.sis213.wetaca.dto.UserDto;
import bo.edu.ucb.sis213.wetaca.dto.Wtc_usuarioDto;
import bo.edu.ucb.sis213.wetaca.entity.Wtc_usuario;
import bo.edu.ucb.sis213.wetaca.util.AuthUtil;
import bo.edu.ucb.sis213.wetaca.util.WetacaException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
public class UserApi {
    private UserBl userBl;

    public UserApi(UserBl userBl) {
        this.userBl = userBl;
    }

     /**
     * Endpoint POST para crear un nuevo usuario
     * @param createUsuarioDto
     * @return ResponseDto
     */
    @PostMapping()
    public ResponseDto<String> createUser(@RequestBody CreateUsuarioDto createUsuarioDto) {
        CreateUsuarioDto user = createUsuarioDto;
        System.out.println(user);
        ResponseDto<String> responseDto;
        try {
            userBl.createUser(createUsuarioDto);
            responseDto = new ResponseDto<>("Usuario creado correctamente", null, true);
        } catch (WetacaException ex) {
            responseDto = new ResponseDto<>("", "No creado", false);
        }
        return responseDto;
    }

    /**
     * Endpoint GET para obtener un usuario por su username
     * @param username
     * @return ResponseDto
     */
    @GetMapping("/{username}")
    public ResponseDto<Wtc_usuarioDto> getUserByUsername(@PathVariable String username) {
        ResponseDto responseDto;
        try {
            Wtc_usuario frUser = userBl.getUserByUsername(username);
            UserDto userDto = new UserDto(frUser.getId_wtc_usuario(), frUser.getCi_wtc_usuario(),frUser.getNombre_wtc_usuario(), frUser.getApellido_wtc_usuario(), frUser.getCorreo_wtc_usuario(), frUser.getFono_wtc_usuario(), frUser.getNombreusuario_wtc_usuario());
            responseDto = new ResponseDto<>(userDto, null, true);
        } catch (WetacaException ex) {
            responseDto = new ResponseDto<>(ex.getMessage(), null, false);
        }
        return responseDto;
    }

    /**
     * Endpoint GET para obtener un usuario por su correo
     * @param username
     * @return ResponseDto
     */
    @GetMapping("/email/{email}")
    public ResponseDto<UserDto> getUserByEmail(@PathVariable String email) {
        ResponseDto responseDto;
        try {
            System.out.println("API email: "+email);
            Wtc_usuario wcUser = userBl.getUserByEmail(email);
            UserDto userDto = new UserDto(wcUser.getId_wtc_usuario(), wcUser.getCi_wtc_usuario(),wcUser.getNombre_wtc_usuario(), wcUser.getApellido_wtc_usuario(), wcUser.getCorreo_wtc_usuario(), wcUser.getFono_wtc_usuario(), wcUser.getNombreusuario_wtc_usuario());
            responseDto = new ResponseDto<>(userDto, null, true);
        } catch (WetacaException ex) {
            responseDto = new ResponseDto<>(ex.getMessage(), null, false);
        }
        return responseDto;
    }




     /**
     * Endpoint GET para obtener un usuario por su token
     * @param headers
     * @return ResponseDto
     */
    @GetMapping("/")
    public ResponseDto<UserDto> getUserFromToken(@RequestHeader Map<String, String> headers) {
        ResponseDto responseDto;
        try {
            Thread.sleep(3000);
        } catch (Exception ex) {
            // Do nothing
        }
        try {
            String username = AuthUtil.isUserAuthenticated(AuthUtil.getTokenFromHeader(headers));
            System.out.println("username : "+username);
            Wtc_usuario frUser = userBl.getUserByUsername(username);
            UserDto userDto = new UserDto(frUser.getId_wtc_usuario(), frUser.getCi_wtc_usuario(),frUser.getNombre_wtc_usuario(), frUser.getApellido_wtc_usuario(), frUser.getCorreo_wtc_usuario(), frUser.getFono_wtc_usuario(), frUser.getNombreusuario_wtc_usuario());
            responseDto = new ResponseDto<>(userDto, null, true);
        }
        catch (WetacaException ex) {
            responseDto = new ResponseDto<>(null, ex.getMessage(), false);
        }
        return responseDto;
    }


     /**
     * Endpoint PUT para actualizar un usuario por su token
     * @param headers
     * @param userDto
     * @return ResponseDto
     */
    @PutMapping()
    public ResponseDto<String> updateUser(@RequestHeader Map<String, String> headers, @RequestBody CreateUsuarioDto userDto) {
        ResponseDto responseDto;
        try {
            String username = AuthUtil.isUserAuthenticated(AuthUtil.getTokenFromHeader(headers));
            int userId = this.userBl.getUserByUsername(username).getId_wtc_usuario();
            userBl.updateUser(userId, userDto);
            responseDto = new ResponseDto<>("Usuario actualizado correctamente", null, true);
        }
        catch (WetacaException ex) {
            responseDto = new ResponseDto<>(null, ex.getMessage(), false);
        }
        return responseDto;
    }

    /*
     * Endpoint DELETE para eliminar de manera lógica un usuario por su token
     * @param headers
     * @return ResponseDto
     
    @DeleteMapping("/")
    public ResponseDto<String> deleteUser(@RequestHeader Map<String, String> headers) {
        ResponseDto responseDto;
        try {
            String username = AuthUtil.isUserAuthenticated(AuthUtil.getTokenFromHeader(headers));
            int userId = this.userBl.getUserByUsername(username).getId_wtc_usuario();
            userBl.deleteUser(userId);
            responseDto = new ResponseDto<>("Usuario eliminado correctamente", null, true);
        }
        catch (WetacaException ex) {
            responseDto = new ResponseDto<>(null, ex.getMessage(), false);
        }
        return responseDto;
    }
    */

    /**
     * Endpoint PUT para cambiar contraseña de un usuario
     * @param 
     * @return ResponseDto
     */
    @PutMapping("/restorePassword")
    public ResponseDto<String> recoverPassword(@RequestBody RecoverPasswordDto recoverPasswordDto) {
        ResponseDto responseDto;
        try {
            userBl.updatePassword(recoverPasswordDto.getEmail(), recoverPasswordDto.getSecret());
            responseDto = new ResponseDto<>("Contraseña actualizada correctamente", null, true);
        }
        catch (WetacaException ex) {
            responseDto = new ResponseDto<>(null, ex.getMessage(), false);
        }
        return responseDto;
    }

}
