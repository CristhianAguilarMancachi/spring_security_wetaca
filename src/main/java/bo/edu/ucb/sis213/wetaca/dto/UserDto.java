package bo.edu.ucb.sis213.wetaca.dto;

public class UserDto {
 private int id_usuarioDto; // id del usuario
 private String ci_usuarioDto; // ci del usuario
    private String nombre_usuarioDto; // nombre del usuario
    private String apellido_usuarioDto; // apellido del usuario
    private String email_usuarioDto; // email del usuario
    private String fono_usuarioDto; // telefono del usuario
    private int id_ubicacionDto;  // id de la ubicacion del usuario
    private String usernameDto; // nombre de usuario
    private String contrasena_usuarioDto; // clave del usuario
    private Boolean estado_usuarioDto; // estado del usuario

    // constructor vacio
    public UserDto() {
    }
    // constructor con parametros
    public UserDto(int id_usuarioDto, String ci_usuarioDto, String nombre_usuarioDto, String apellido_usuarioDto, String email_usuarioDto, String fono_usuarioDto, int id_ubicacionDto, String usernameDto, String contrasena_usuarioDto, Boolean estado_usuarioDto) {
        this.id_usuarioDto = id_usuarioDto;
        this.ci_usuarioDto = ci_usuarioDto;
        this.nombre_usuarioDto = nombre_usuarioDto;
        this.apellido_usuarioDto = apellido_usuarioDto;
        this.email_usuarioDto = email_usuarioDto;
        this.fono_usuarioDto = fono_usuarioDto;
        this.id_ubicacionDto = id_ubicacionDto;
        this.usernameDto = usernameDto;
        this.contrasena_usuarioDto = contrasena_usuarioDto;
        this.estado_usuarioDto = estado_usuarioDto;
    }
    // getters y setters
    public int getId_usuarioDto() {
        return id_usuarioDto;
    }
    public void setId_usuarioDto(int id_usuarioDto) {
        this.id_usuarioDto = id_usuarioDto;
    }
    public String getCi_usuarioDto() {
        return ci_usuarioDto;
    }
    public void setCi_usuarioDto(String ci_usuarioDto) {
        this.ci_usuarioDto = ci_usuarioDto;
    }
    public String getNombre_usuarioDto() {
        return nombre_usuarioDto;
    }
    public void setNombre_usuarioDto(String nombre_usuarioDto) {
        this.nombre_usuarioDto = nombre_usuarioDto;
    }
    public String getApellido_usuarioDto() {
        return apellido_usuarioDto;
    }
    public void setApellido_usuarioDto(String apellido_usuarioDto) {
        this.apellido_usuarioDto = apellido_usuarioDto;
    }
    public String getEmail_usuarioDto() {
        return email_usuarioDto;
    }
    public void setEmail_usuarioDto(String email_usuarioDto) {
        this.email_usuarioDto = email_usuarioDto;
    }
    public String getFono_usuarioDto() {
        return fono_usuarioDto;
    }
    public void setFono_usuarioDto(String fono_usuarioDto) {
        this.fono_usuarioDto = fono_usuarioDto;
    }
    public int getId_ubicacionDto() {
        return id_ubicacionDto;
    }
    public void setId_ubicacionDto(int id_ubicacionDto) {
        this.id_ubicacionDto = id_ubicacionDto;
    }
    public String getUsernameDto() {
        return usernameDto;
    }
    public void setUsernameDto(String usernameDto) {
        this.usernameDto = usernameDto;
    }
    public String getContrasena_usuarioDto() {
        return contrasena_usuarioDto;
    }
    public void setContrasena_usuarioDto(String contrasena_usuarioDto) {
        this.contrasena_usuarioDto = contrasena_usuarioDto;
    }
    public Boolean getEstado_usuarioDto() {
        return estado_usuarioDto;
    }
    public void setEstado_usuarioDto(Boolean estado_usuarioDto) {
        this.estado_usuarioDto = estado_usuarioDto;
    }

    // toString
    @Override
    public String toString() {
        return "UserDto{" + "id_usuarioDto=" + id_usuarioDto + ", ci_usuarioDto=" + ci_usuarioDto + ", nombre_usuarioDto=" + nombre_usuarioDto + ", apellido_usuarioDto=" + apellido_usuarioDto + ", email_usuarioDto=" + email_usuarioDto + ", fono_usuarioDto=" + fono_usuarioDto + ", id_ubicacionDto=" + id_ubicacionDto + ", usernameDto=" + usernameDto + ", contrasena_usuarioDto=" + contrasena_usuarioDto + ", estado_usuarioDto=" + estado_usuarioDto + '}';
    }
    
}
