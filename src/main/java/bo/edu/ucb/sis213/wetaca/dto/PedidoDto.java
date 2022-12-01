package bo.edu.ucb.sis213.wetaca.dto;

public class PedidoDto {
    // Colocar todos los atributos de la tabla pedido excepto el id, el estado, el usuario, la fecha y la hora
    private String fechaPedido;
    private Double subtotal;
    private String ciUsuario;
    private String fechaEntrega;
    
    public PedidoDto() {
    }

    public PedidoDto(String fechaPedido, Double subtotal, String ciUsuario, String fechaEntrega) {
        this.fechaPedido = fechaPedido;
        this.subtotal = subtotal;
        this.ciUsuario = ciUsuario;
        this.fechaEntrega = fechaEntrega;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public String getCiUsuario() {
        return ciUsuario;
    }

    public void setCiUsuario(String ciUsuario) {
        this.ciUsuario = ciUsuario;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    @Override
    public String toString() {
        return "PedidoDto{" + "fechaPedido=" + fechaPedido + ", subtotal=" + subtotal + ", ciUsuario=" + ciUsuario + ", fechaEntrega=" + fechaEntrega + '}';
    }

    
}
