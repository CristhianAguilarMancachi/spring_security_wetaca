package bo.edu.ucb.sis213.wetaca.dto;

public class CreatePedidoDto {
    private String fechaPedido;
    private Double subtotal;
    private Integer cantidad;
    private String fechaEntrega;
    private String ciUsuario;

    public CreatePedidoDto() {
    }

    // Constructor
    public CreatePedidoDto(String fechaPedido, Double subtotal, Integer cantidad, String fechaEntrega, String ciUsuario) {
        this.fechaPedido = fechaPedido;
        this.subtotal = subtotal;
        this.cantidad = cantidad;
        this.fechaEntrega = fechaEntrega;
        this.ciUsuario = ciUsuario;
    }

    // Getters and Setters

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

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getCiUsuario() {
        return ciUsuario;
    }

    public void setCiUsuario(String ciUsuario) {
        this.ciUsuario = ciUsuario;
    }

    @Override
    public String toString() {
        return "CreatePedidoDto{" + "fechaPedido=" + fechaPedido + ", subtotal=" + subtotal + ", cantidad=" + cantidad + ", fechaEntrega=" + fechaEntrega + ", ciUsuario=" + ciUsuario + '}';
    }

    public boolean validate() {
        if(this.fechaPedido == null || this.fechaPedido.isEmpty()) {
            return false;
        }
        if(this.subtotal == null || this.subtotal < 0) {
            return false;
        }
        if(this.cantidad == null || this.cantidad < 0) {
            return false;
        }
        if(this.fechaEntrega == null || this.fechaEntrega.isEmpty()) {
            return false;
        }
        if(this.ciUsuario == null || this.ciUsuario.isEmpty()) {
            return false;
        }
        return true;
    }
    

}
