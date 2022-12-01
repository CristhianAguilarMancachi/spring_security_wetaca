package bo.edu.ucb.sis213.wetaca.api;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.edu.ucb.sis213.wetaca.bl.PedidoBl;
import bo.edu.ucb.sis213.wetaca.dto.ResponseDto;
import bo.edu.ucb.sis213.wetaca.util.AuthUtil;
import bo.edu.ucb.sis213.wetaca.util.WetacaException;

@RestController
@RequestMapping("/v1/api/pedido")
public class PedidoApi {
    PedidoBl pedidoBl;

    public PedidoApi(PedidoBl pedidoBl) {
        this.pedidoBl = pedidoBl;
    }

    // Registrar nueva mascota
    @PostMapping()
    public ResponseEntity<ResponseDto<String>> createPedido(@RequestHeader Map<String, String> headers,
            @RequestBody CreatePedidoDto createPetDto) {
        if (createPedidoDto.validate()) {
            try {
                String jwt = AuthUtil.getTokenFromHeader(headers);
                String userName = AuthUtil.getUserNameFromToken(jwt);
                AuthUtil.verifyHasRole(jwt, "REGISTRAR PEDIDO");
                pedidoBl.createPet(userName, createPetDto);
                ResponseDto<String> responseDto = new ResponseDto<>("Pedido Created", "", null);
                return new ResponseEntity<>(responseDto, HttpStatus.OK);
            } catch (WetacaException e) {
                ResponseDto<String> responseDto = new ResponseDto<>(null, e.getStatusCode(), e.getMessage());
                return new ResponseEntity<>(responseDto, e.getHttpStatus());
            }
        } else {
            String statusCode = "";
            ResponseDto<String> responseDto = new ResponseDto<>(null, statusCode,
                    httpMessageUtilMap.get(statusCode).getMessage());
            return new ResponseEntity<>(responseDto, httpMessageUtilMap.get(statusCode).getHttpStatus());
        }
    }

    // Información de el pedido por su ID
    @GetMapping("/pedido-info/{pedidoId}")
    public ResponseEntity<ResponseDto> getPedidoInfo(@RequestHeader Map<String, String> headers,
            @PathVariable Integer pedidoId) {

        try {
            // Verificamos que el usuario este autenticado
            String jwt = AuthUtil.getTokenFromHeader(headers);
            AuthUtil.getUserNameFromToken(jwt);
            PedidoInfo pedidoInfo = pedidoBl.findPedidoInfoByPedidoId(pedidoId);
            ResponseDto<PedidoInfo> responseDto = new ResponseDto<>(pedidoInfo, "", null);
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } catch (WetacaException e) {
            ResponseDto<String> responseDto = new ResponseDto<>(null, e.getStatusCode(), e.getMessage());
            return new ResponseEntity<>(responseDto, e.getHttpStatus());
        }
    }

    // Actualiza los datos de un pedido por id
    @PutMapping("/{pedido_id}")
    public ResponseEntity<ResponseDto<String>> updatePedido(@RequestHeader Map<String, String> headers,
                                                         @RequestBody PedidoData updatePetData, @PathVariable Integer pedido_id

    ) {
        if (updatePedidoData.validate()) {
            try {
                // Verificamos que el usuario este autenticado
                String jwt = AuthUtil.getTokenFromHeader(headers);
                AuthUtil.getUserNameFromToken(jwt);
                AuthUtil.verifyHasRole(jwt, "EDITAR INFORMACION DE EL PEDIDO");
                pedidoBl.updatePet(pet_id, updatePetData);
                ResponseDto<String> responseDto = new ResponseDto<>("Pedido Updated", "", null);
                return new ResponseEntity<>(responseDto, HttpStatus.OK);
            } catch (WetacaException e) {
                ResponseDto<String> responseDto = new ResponseDto<>(null, e.getStatusCode(), e.getMessage());
                return new ResponseEntity<>(responseDto, e.getHttpStatus());
            }
        } else {
            String statusCode = "SCTY-1001";
            ResponseDto<String> responseDto = new ResponseDto<>(null, statusCode,
                    httpMessageUtilMap.get(statusCode).getMessage());
            return new ResponseEntity<>(responseDto, httpMessageUtilMap.get(statusCode).getHttpStatus());
        }
    }
    //Eliminación de pedido por id
    @PutMapping("/delete/{pedido_id}")
    public ResponseEntity<ResponseDto<String>> deletePet(@RequestHeader Map<String, String> headers,
                                                         @RequestBody Pedido DeletePedido, @PathVariable Integer pet_id
    ) {
        if (DeletePet.validate()) {
            try {
                // Verificamos que el usuario este autenticado
                String jwt = AuthUtil.getTokenFromHeader(headers);
                AuthUtil.getUserNameFromToken(jwt);
                AuthUtil.verifyHasRole(jwt, "EDITAR INFORMACION DE EL PEDIDO");
                pedidoBl.deletePedido(pedido_id, DeletePedido);
                ResponseDto<String> responseDto = new ResponseDto<>("Pedido Delete", "", null);
                return new ResponseEntity<>(responseDto, HttpStatus.OK);
            } catch (WetacaException e) {
                ResponseDto<String> responseDto = new ResponseDto<>(null, e.getStatusCode(), e.getMessage());
                return new ResponseEntity<>(responseDto, e.getHttpStatus());
            }
        } else {
            String statusCode = "";
            ResponseDto<String> responseDto = new ResponseDto<>(null, statusCode,
                    httpMessageUtilMap.get(statusCode).getMessage());
            return new ResponseEntity<>(responseDto, httpMessageUtilMap.get(statusCode).getHttpStatus());
        }
    }
    @GetMapping("/pedido-info")
    public ResponseEntity<ResponseDto> getPetInfo(@RequestHeader Map<String, String> headers) {
        try {
            String jwt = AuthUtil.getTokenFromHeader(headers);
            String userName = AuthUtil.getUserNameFromToken(jwt);
            List<PedidoInfo> pedidoInfo = pedidoBl.findPedidoInfoByUserName(userName);
            ResponseDto<List<PedidoInfo>> responseDto = new ResponseDto<>(pedidoInfo, "", null);
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } catch (WetacaException e) {
            ResponseDto<String> responseDto = new ResponseDto<>(null, e.getStatusCode(), e.getMessage());
            return new ResponseEntity<>(responseDto, e.getHttpStatus());
        }
    }

    // Información del pedido
    @GetMapping("/{pedidoId}")
    public ResponseEntity<ResponseDto> getPedidoInfoByPedidoId(@RequestHeader Map<String, String> headers,
            @PathVariable Integer pedidoId) {
        try {
            // Verificamos que el usuario este autenticado
            String jwt = AuthUtil.getTokenFromHeader(headers);
            AuthUtil.getUserNameFromToken(jwt);
            PedidoData pedidoData = pedidoBl.findPedidoByPedidoId(pedidoId);
            ResponseDto<PedidoData> responseDto = new ResponseDto<>(pedidoData, "", null);
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } catch (WetacaException e) {
            ResponseDto<String> responseDto = new ResponseDto<>(null, e.getStatusCode(), e.getMessage());
            return new ResponseEntity<>(responseDto, e.getHttpStatus());
        }
    }

}
