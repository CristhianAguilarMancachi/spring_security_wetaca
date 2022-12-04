package bo.edu.ucb.sis213.wetaca.dto;

public class PedidoDatoDto {
    // Colocar todos los atributos de la tabla pedido excepto el id, el estado, el usuario, la fecha y la hora
    private String fechaPedido;
    private Double subtotal;
    private Integer cantidad;
    private String ciUsuario;
    private String fechaEntrega;
    
    public PedidoDatoDto() {
    }

    public PedidoDatoDto(String fechaPedido, Double subtotal, Integer cantidad, String ciUsuario, String fechaEntrega) {
        this.fechaPedido = fechaPedido;
        this.subtotal = subtotal;
        this.cantidad = cantidad;
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

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
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
        return "PedidoDatoDto{" + "fechaPedido=" + fechaPedido + ", subtotal=" + subtotal + ", cantidad=" + cantidad + ", ciUsuario=" + ciUsuario + ", fechaEntrega=" + fechaEntrega + '}';
    }

    
}
