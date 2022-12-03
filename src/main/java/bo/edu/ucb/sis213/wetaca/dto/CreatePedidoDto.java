package bo.edu.ucb.sis213.wetaca.dto;

public class CreatePedidoDto {
    private String fechaPedido;
    private Double subtotal;
    private String fechaEntrega;
    private String ciUsuario;

    public CreatePedidoDto() {
    }

    // Constructor
    public CreatePedidoDto(String fechaPedido, Double subtotal, String fechaEntrega, String ciUsuario) {
        this.fechaPedido = fechaPedido;
        this.subtotal = subtotal;
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
        return "CreatePedidoDto{" +
                "fechaPedido='" + fechaPedido + '\'' +
                ", subtotal=" + subtotal +
                ", fechaEntrega='" + fechaEntrega + '\'' +
                ", ciUsuario='" + ciUsuario + '\'' +
                '}';
    }

    public boolean validate() {
        if(this.fechaPedido == null || this.fechaPedido.isEmpty()) {
            return false;
        }
        if(this.subtotal == null) {
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
