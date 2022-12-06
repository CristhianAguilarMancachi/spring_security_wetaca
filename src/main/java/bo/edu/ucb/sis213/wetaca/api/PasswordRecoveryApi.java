package bo.edu.ucb.sis213.wetaca.api;

import org.springframework.web.bind.annotation.*;

import bo.edu.ucb.sis213.wetaca.bl.PasswordRecoveryBl;
import bo.edu.ucb.sis213.wetaca.dto.PasswordRecoveryDto;
import bo.edu.ucb.sis213.wetaca.dto.ResponseDto;
import bo.edu.ucb.sis213.wetaca.util.WetacaException;

@RestController
@RequestMapping("/api/v1/recover")
public class PasswordRecoveryApi {
    private PasswordRecoveryBl passwordRecoveryBl;

    public PasswordRecoveryApi(PasswordRecoveryBl passwordRecoveryBl) {
        this.passwordRecoveryBl = passwordRecoveryBl;
    }

    /**
     * Endpoint POST para crear un codigo de recuperacion de contraseña
     * @param passwordRecoveryDto
     * @return ResponseDto
     */
    @PostMapping()
    public ResponseDto<String> createPasswordRecoveryCode(@RequestBody PasswordRecoveryDto passwordRecoveryDto) {
        ResponseDto<String> responseDto;
        try {
            passwordRecoveryBl.createPasswordRecovery(passwordRecoveryDto);
            responseDto = new ResponseDto<>("Codigo de recuperacion creado correctamente", null, true);
        } catch (WetacaException ex) {
            responseDto = new ResponseDto<>(ex.getMessage(), null, false);
        }
        return responseDto;
    }

    /**
     * Endpoint POST para verificar si el codigo de recuperacion es valido
     * @param passwordRecoveryDto
     * @return ResponseDto
     */
    @PostMapping("/verify")
    public ResponseDto<String> verifyPasswordRecoveryCode(@RequestBody PasswordRecoveryDto passwordRecoveryDto) {
        ResponseDto<String> responseDto;
        try {
            passwordRecoveryBl.isCodeValid(passwordRecoveryDto);
            responseDto = new ResponseDto<>("Codigo de recuperacion valido", null, true);
        } catch (WetacaException ex) {
            responseDto = new ResponseDto<>(ex.getMessage(), null, false);
        }
        return responseDto;
    }


}
