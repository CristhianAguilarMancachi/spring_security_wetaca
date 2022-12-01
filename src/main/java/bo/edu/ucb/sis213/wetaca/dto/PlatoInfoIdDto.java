package bo.edu.ucb.sis213.wetaca.dto;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;


public class PlatoDto {

    public PlatoInfo findPLatoInfoById(Integer id){
        PlatoInfo platoInfo = new PlatoInfo();
        if(platoInfo == null){
            throw new WetacaException("SCTY-4008");
        }
        return platoInfo;
    }
    
    @GetMapping("/platos-info/{idPlato}")
    public ResponseEntity<ResponseDto> getPlatoInfo(@RequestHeader Map<String, String> headers, 
    @PathVariable Integer idPlato )  {
    
        try{
            // Vereficamos que el usuario este identificado
            String jwt = AuthUtil.getTokenFromHeader(headers);
            AuthUtil.getUserNameFromToken(jwt);
            PlatoInfo platoInfo = platoBl.findPLatoInfoById(idPlato);
            ResponseDto<PlatoInfo> responseDto = new ResponseDto<>(platoInfo, "SCTY-0000", true);
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        }catch (WetacaException ex){
            // Si hay error, se captura y se envia el error
            ResponseDto<String> responseDto = new ResponseDto<>(null, ex.getStatusCode(), ex.getMessage());
            return new ResponseEntity<>(responseDto, ex.getHttpStatus());
        }
    }

}


