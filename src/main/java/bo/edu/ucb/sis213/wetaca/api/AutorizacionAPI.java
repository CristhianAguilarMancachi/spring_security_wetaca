package bo.edu.ucb.sis213.wetaca.api;

import bo.edu.ucb.sis213.wetaca.bl.SeguridadBl;
import bo.edu.ucb.sis213.wetaca.dto.AuthReqDto;
import bo.edu.ucb.sis213.wetaca.dto.AuthResDto;
import bo.edu.ucb.sis213.wetaca.dto.ResponseDto;
import bo.edu.ucb.sis213.wetaca.util.WetacaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/autorizacion") //ruta de la api
//clase AuthApi
public class AutorizacionAPI {

    private SeguridadBl securityBl; //creamos un objeto de la clase SecurityBl

    public AutorizacionAPI(SeguridadBl securityBl) {
        this.securityBl = securityBl;
    }

    /**
     * HACERLO ASÍ POR SIMPLICIDAD.
     * @param authReqDto
     * @return
     */
    @PostMapping()
    public ResponseDto<AuthResDto> authentication(@RequestBody  AuthReqDto authReqDto) {
        try {
            Thread.sleep(3000);
        } catch (Exception ex) {
            // Do nothing
        }
        if (authReqDto != null && authReqDto.username() != null && authReqDto.password() != null) {
            // Retorna los tokens, null (porque no hay error), true porque fue exitoso
            try {
                return new ResponseDto<>(securityBl.authenticate(authReqDto), null, true);
            } catch (WetacaException ex) {
                return new ResponseDto<>(null, ex.getMessage(), false);
            }
        } else {
            return new ResponseDto<>(null, "Credenciales incorrectas", false);
        }
    }

    /**
     * HACERLO ASÍ POR SIMPLICIDAD.
     * @param authReqDto
     * @return
     */
    @RequestMapping(value="/v2/", method = RequestMethod.POST)
    
    public ResponseEntity<ResponseDto<AuthResDto>> authenticationV2(@RequestBody  AuthReqDto authReqDto) {
        // ResponseEntity es un objeto que permite manejar el código de respuesta HTTP
        if (authReqDto != null && authReqDto.username() != null && authReqDto.password() != null) {
            // Retorna los tokens, null (porque no hay error), true porque fue exitoso
            try {
                
                ResponseDto<AuthResDto> responseDto = new  ResponseDto<>(securityBl.authenticate(authReqDto), null, true); //creamos un objeto de la clase ResponseDto
                return new ResponseEntity<>(responseDto, HttpStatus.OK);
            } catch (WetacaException ex) {
                ResponseDto<AuthResDto> responseDto = new ResponseDto<>(null, ex.getMessage(),
                        false);
                return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
            }

        } else {
            ResponseDto<AuthResDto> responseDto = new ResponseDto<>(null, "Credenciales incorrectas",
                    false);
            return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
        }
    }

}
