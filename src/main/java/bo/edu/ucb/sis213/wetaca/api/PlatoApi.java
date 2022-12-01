package bo.edu.ucb.sis213.wetaca.api;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.edu.ucb.sis213.wetaca.bl.PlatoBl;
import bo.edu.ucb.sis213.wetaca.dto.ResponseDto;
import bo.edu.ucb.sis213.wetaca.util.AuthUtil;
import bo.edu.ucb.sis213.wetaca.util.WetacaException;
// libreria de http
import org.springframework.web.bind.annotation.GetMapping;

// La ruta de como sera llamado el servicio desde el front
@RestController
@RequestMapping("/api/v1/plato")
public class PlatoApi {
    PlatoBl platoBl;

    public PlatoApi(PlatoBl platoBl) {
        this.platoBl = platoBl;
    }

    @PostMapping()
    public ResponseEntity<ResponseDto<String>> createPlato(@RequestHeader Map<String, String> headers,
            @RequestBody CreatePlatoDto platoDto) {
        if(platoDto.validate()){
            try{
                String jwt = AuthUtil.getTokenFromHeader(headers);
                String username = AuthUtil.getUserNameFromToken(jwt);
                AuthUtil.verifyHasRole(jwt, "REGISTRAR PLATO");
                platoBl.createPlato(platoDto, username);
                ResponseDto<String> responseDto = new ResponseDto<>("Plato creado correctamente", "", false, null);
                return new ResponseEntity<>(responseDto, HttpStatus.OK);
            }catch(WetacaException ex){
                ResponseDto<String> responseDto = new ResponseDto<>(null, ex.getStatusCode(), ex.getMessage());
                return new ResponseEntity<>(responseDto, ex.getHttpStatus());
            }

         }else{
            String statusCode = "";
            ResponseDto<String> responseDto = new ResponseDto<>(null, statusCode, Http);
        }
    }
}
