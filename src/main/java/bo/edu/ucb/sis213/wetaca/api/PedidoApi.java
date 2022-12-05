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
import bo.edu.ucb.sis213.wetaca.dto.CreatePedidoDto;
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

    // Registrar nuevo pedido
    @PostMapping()
    public ResponseEntity<ResponseDto<String>> createPedido(@RequestHeader Map<String, String> headers,
            @RequestBody CreatePedidoDto createPedidoDto) {
        if (createPedidoDto.validate()) {
            try {
                String jwt = AuthUtil.getTokenFromHeader(headers);
                String userName = AuthUtil.getUserNameFromToken(jwt);
                AuthUtil.verifyHasRole(jwt, "REGISTRAR PEDIDO");
                pedidoBl.createPedido(userName, createPedidoDto);
                ResponseDto<String> responseDto = new ResponseDto<>("Pedido creado correctamente", "", false);
                return new ResponseEntity<>(responseDto, HttpStatus.OK);
            } catch (WetacaException e) {
                ResponseDto<String> responseDto = new ResponseDto<>(e.getMessage(), "", false);
                return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
            }
        } else {
            String statusCode = "";
            ResponseDto<String> responseDto = new ResponseDto<>("Datos incorrectos", statusCode, false);
            return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
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
            CreatePedidoDto pedidoInfo = pedidoBl.findPedidoInfoByPedidoId(pedidoId);
            return new ResponseEntity<>(new ResponseDto<>(pedidoInfo, "", false), HttpStatus.OK);
        } catch (WetacaException e) {
            ResponseDto<String> responseDto = new ResponseDto<>(e.getMessage(), "", false);
            return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
        }
    }

    // Actualiza los datos de un pedido por id
    @PutMapping("/{pedido_id}")
    public ResponseEntity<ResponseDto<String>> updatePedido(@RequestHeader Map<String, String> headers,
            @RequestBody CreatePedidoDto updatePedidoData, @PathVariable Integer pedido_id) {
        if (updatePedidoData.validate()) {
            try {
                // Verificamos que el usuario este autenticado
                String jwt = AuthUtil.getTokenFromHeader(headers);
                AuthUtil.getUserNameFromToken(jwt);
                AuthUtil.verifyHasRole(jwt, "EDITAR INFORMACION DE EL PEDIDO");
                pedidoBl.updatePedido(pedido_id, updatePedidoData);
                ResponseDto<String> responseDto = new ResponseDto<>("Pedido actualizado correctamente", "", false);
                return new ResponseEntity<>(responseDto, HttpStatus.OK);
            } catch (WetacaException e) {
                ResponseDto<String> responseDto = new ResponseDto<>(e.getMessage(), "", false);
                return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
            }
        } else {
            String statusCode = "SCTY-1001";
            ResponseDto<String> responseDto = new ResponseDto<>("Datos incorrectos", statusCode, false);
            return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
        }
    }
    //Eliminación de pedido por id
    @PutMapping("/delete/{pedido_id}")
    public ResponseEntity<ResponseDto<String>> deletePet(@RequestHeader Map<String, String> headers,
                                                         @RequestBody CreatePedidoDto deletePedido, @PathVariable Integer pedido_id
    ) {
        if (deletePedido.validate()) {
            try {
                // Verificamos que el usuario este autenticado
                String jwt = AuthUtil.getTokenFromHeader(headers);
                AuthUtil.getUserNameFromToken(jwt);
                AuthUtil.verifyHasRole(jwt, "EDITAR INFORMACION DE EL PEDIDO");
                pedidoBl.deletePedido(pedido_id);
                ResponseDto<String> responseDto = new ResponseDto<>("Pedido eliminado correctamente", "", false);
                return new ResponseEntity<>(responseDto, HttpStatus.OK);
            } catch (WetacaException e) {
                ResponseDto<String> responseDto = new ResponseDto<>(e.getMessage(), "", false);
                return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
            }
        } else {
            String statusCode = "";
            ResponseDto<String> responseDto = new ResponseDto<>("Datos incorrectos", statusCode, false);
            return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
        }
    }

    // Lista de pedidos
    /*@GetMapping("/pedido-info")
    public ResponseEntity<ResponseDto> getPetInfo(@RequestHeader Map<String, String> headers) {
        try {
            String jwt = AuthUtil.getTokenFromHeader(headers);
            String userName = AuthUtil.getUserNameFromToken(jwt);
            List<PedidoDatoDto> pedidoInfo = pedidoBl.findPedidoInfoByUserName(userName);
            ResponseDto<List<PedidoInfo>> responseDto = new ResponseDto<>(pedidoInfo, "", null);
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } catch (WetacaException e) {
            ResponseDto<String> responseDto = new ResponseDto<>(e.getMessage(), "", false);
            return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
        }
    }*/

    // Lista de todos los pedidos
    @GetMapping("/all-pedido-info")
    public ResponseEntity<ResponseDto> getAllPedidoInfo(@RequestHeader Map<String, String> headers) {
        try {
            String jwt = AuthUtil.getTokenFromHeader(headers);
            AuthUtil.getUserNameFromToken(jwt);
            AuthUtil.verifyHasRole(jwt, "VER TODOS LOS PEDIDOS");
            List<CreatePedidoDto> pedidoInfo = pedidoBl.findAllPedidos();
            return new ResponseEntity<>(new ResponseDto<>(pedidoInfo, "", false), HttpStatus.OK);
        } catch (WetacaException e) {
            ResponseDto<String> responseDto = new ResponseDto<>(e.getMessage(), "", false);
            return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
        }
    }
    

}
