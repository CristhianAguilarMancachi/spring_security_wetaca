package bo.edu.ucb.sis213.wetaca.api;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.edu.ucb.sis213.wetaca.bl.PlatoBl;
import bo.edu.ucb.sis213.wetaca.dto.CreatePlatoDto;
import bo.edu.ucb.sis213.wetaca.dto.PlatoDatoDto;
import bo.edu.ucb.sis213.wetaca.dto.ResponseDto;
import bo.edu.ucb.sis213.wetaca.util.AuthUtil;
import bo.edu.ucb.sis213.wetaca.util.WetacaException;

import org.springframework.web.bind.annotation.DeleteMapping;
// libreria de http
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
                platoBl.createPlato(platoDto);
                ResponseDto<String> responseDto = new ResponseDto<>("Plato creado correctamente", "", false);
                return new ResponseEntity<>(responseDto, HttpStatus.OK);
            }catch(WetacaException ex){
                ResponseDto<String> responseDto = new ResponseDto<>(ex.getMessage(), ex.getStatusCode(), false);
                return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
            }

         }else{
            String statusCode = "";
            ResponseDto<String> responseDto = new ResponseDto<>(null, statusCode, true);
            return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
        }
    }

    // Informacion del plato por id
    @GetMapping("/plato-info/{platoId}")
    public ResponseEntity<PlatoDatoDto>getPlatoInfo(@RequestHeader Map<String, String> headers, 
            @PathVariable Integer platoId) {
        try {
            String jwt = AuthUtil.getTokenFromHeader(headers);
            String username = AuthUtil.getUserNameFromToken(jwt);
            AuthUtil.verifyHasRole(jwt, "OBTENER PLATO");
            PlatoDatoDto platoDto = platoBl.getPlato(platoId);
            ResponseDto<PlatoDatoDto> responseDto = new ResponseDto<>(platoDto, "", false);
            return new ResponseEntity<>(platoDto, HttpStatus.OK);
        } catch (WetacaException ex) {
            ResponseDto<String> responseDto = new ResponseDto<>(null, ex.getStatusCode(), false);
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // Actualiza los datos de un plato por id
    @PutMapping("/{plato_id}")
    public ResponseEntity<ResponseDto<String>> updatePlato(@RequestHeader Map<String, String> headers,
            @PathVariable Integer pedido_id, @RequestBody CreatePlatoDto platoDto) {
        if (platoDto.validate()) {
            try {
                String jwt = AuthUtil.getTokenFromHeader(headers);
                String username = AuthUtil.getUserNameFromToken(jwt);
                AuthUtil.verifyHasRole(jwt, "ACTUALIZAR PLATO");
                platoBl.updatePlato(pedido_id, platoDto);
                ResponseDto<String> responseDto = new ResponseDto<>("Plato actualizado correctamente", "", false);
                return new ResponseEntity<>(responseDto, HttpStatus.OK);
            } catch (WetacaException ex) {
                ResponseDto<String> responseDto = new ResponseDto<>(ex.getMessage(), ex.getStatusCode(), false);
                return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
            }
        } else {
            String statusCode = "";
            ResponseDto<String> responseDto = new ResponseDto<>(null, statusCode, false);
            return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
        }
    }

    // Elimina un plato por id
    @DeleteMapping("/delete/{plato_id}")
    public ResponseEntity<ResponseDto<String>> deletePlato(@RequestHeader Map<String, String> headers,
            @PathVariable Integer pedido_id) {
        try {
            String jwt = AuthUtil.getTokenFromHeader(headers);
            String username = AuthUtil.getUserNameFromToken(jwt);
            AuthUtil.verifyHasRole(jwt, "ELIMINAR PLATO");
            platoBl.deletePlato(pedido_id);
            ResponseDto<String> responseDto = new ResponseDto<>("Plato eliminado correctamente", "", false);
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } catch (WetacaException ex) {
            ResponseDto<String> responseDto = new ResponseDto<>(ex.getMessage(), ex.getStatusCode(), false);
            return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
        }
    }

    // Lista de platos
    @GetMapping("/plato-info")
    public ResponseEntity<List<PlatoDatoDto>> getPlatos(@RequestHeader Map<String, String> headers) {
        try {
            String jwt = AuthUtil.getTokenFromHeader(headers);
            String username = AuthUtil.getUserNameFromToken(jwt);
            AuthUtil.verifyHasRole(jwt, "OBTENER PLATOS");
            List<PlatoDatoDto> platoDto = platoBl.getPlatos();
            ResponseDto<List<PlatoDatoDto>> responseDto = new ResponseDto<>(platoDto, "", false);
            return new ResponseEntity<>(platoDto, HttpStatus.OK);
        } catch (WetacaException ex) {
            ResponseDto<List<PlatoDatoDto>> responseDto = new ResponseDto<>(null, ex.getStatusCode(), false);
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // Informacion del plato
    @GetMapping("/{platoId}")
    public ResponseEntity<PlatoDatoDto> getPlato(@RequestHeader Map<String, String> headers, @PathVariable Integer platoId) {
        try {
            String jwt = AuthUtil.getTokenFromHeader(headers);
            String username = AuthUtil.getUserNameFromToken(jwt);
            AuthUtil.verifyHasRole(jwt, "OBTENER PLATO");
            PlatoDatoDto platoDto = platoBl.getPlato(platoId);
            ResponseDto<PlatoDatoDto> responseDto = new ResponseDto<>(platoDto, "", false);
            return new ResponseEntity<>(platoDto, HttpStatus.OK);
        } catch (WetacaException ex) {
            ResponseDto<PlatoDatoDto> responseDto = new ResponseDto<>(null, ex.getStatusCode(), false);
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
