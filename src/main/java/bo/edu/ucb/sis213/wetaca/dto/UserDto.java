package bo.edu.ucb.sis213.wetaca.dto;

public class UserDto {
    private Integer id_wtc_usuario; //id de la tabla wtc usuario
    private String ci_wtc_usuario; //ci de la tabla wtc usuario
    private String nombre_wtc_usuario; //nombre del cliente de la tabla wtc usuario
    private String apellido_wtc_usuario; //apellido del cliente de la tabla wtc usuario
    private String correo_wtc_usuario; //correo del cliente de la tabla wtc usuario
    private String fono_wtc_usuario; //telefono del cliente de la tabla wtc usuario
    private String nombreusuario_wtc_usuario; //nombre de usuario del cliente de la tabla wtc usuario

    //constructor de la clase
    public UserDto() {
    }

    //constructor de la clase
    public UserDto(Integer id_wtc_usuario, String ci_wtc_usuario, String nombre_wtc_usuario, String apellido_wtc_usuario, String correo_wtc_usuario, String fono_wtc_usuario, 
    String nombreusuario_wtc_usuario) {
        this.id_wtc_usuario = id_wtc_usuario;
        this.ci_wtc_usuario = ci_wtc_usuario;
        this.nombre_wtc_usuario = nombre_wtc_usuario;
        this.apellido_wtc_usuario = apellido_wtc_usuario;
        this.correo_wtc_usuario = correo_wtc_usuario;
        this.fono_wtc_usuario = fono_wtc_usuario;
        this.nombreusuario_wtc_usuario = nombreusuario_wtc_usuario;
    }

    //getters y setters de la clase

    public Integer getId_wtc_usuario() {
        return id_wtc_usuario;
    }

    public void setId_wtc_usuario(Integer id_wtc_usuario) {
        this.id_wtc_usuario = id_wtc_usuario;
    }

    public String getCi_wtc_usuario() {
        return ci_wtc_usuario;
    }

    public void setCi_wtc_usuario(String ci_wtc_usuario) {
        this.ci_wtc_usuario = ci_wtc_usuario;
    }

    public String getNombre_wtc_usuario() {
        return nombre_wtc_usuario;
    }

    public void setNombre_wtc_usuario(String nombre_wtc_usuario) {
        this.nombre_wtc_usuario = nombre_wtc_usuario;
    }

    public String getApellido_wtc_usuario() {
        return apellido_wtc_usuario;
    }

    public void setApellido_wtc_usuario(String apellido_wtc_usuario) {
        this.apellido_wtc_usuario = apellido_wtc_usuario;
    }

    public String getCorreo_wtc_usuario() {
        return correo_wtc_usuario;
    }

    public void setCorreo_wtc_usuario(String correo_wtc_usuario) {
        this.correo_wtc_usuario = correo_wtc_usuario;
    }

    public String getFono_wtc_usuario() {
        return fono_wtc_usuario;
    }

    public void setFono_wtc_usuario(String fono_wtc_usuario) {
        this.fono_wtc_usuario = fono_wtc_usuario;
    }



    public String getNombreusuario_wtc_usuario() {
        return nombreusuario_wtc_usuario;
    }

    public void setNombreusuario_wtc_usuario(String nombreusuario_wtc_usuario) {
        this.nombreusuario_wtc_usuario = nombreusuario_wtc_usuario;
    }



    //metodo toString de la clase
    @Override
    public String toString() {
        return "Wtc_usuarioDto{" + "id_wtc_usuario=" + id_wtc_usuario +
         ", ci_wtc_usuario=" + ci_wtc_usuario + ", nombre_wtc_usuario=" 
         + nombre_wtc_usuario + ", apellido_wtc_usuario=" + apellido_wtc_usuario + 
         ", correo_wtc_usuario=" + correo_wtc_usuario + ", fono_wtc_usuario=" + fono_wtc_usuario + 
         //", id_ubicaci\u00f3n=" + id_ubicación + 
         ", nombreusuario_wtc_usuario=" + nombreusuario_wtc_usuario + '}';
    }

}
