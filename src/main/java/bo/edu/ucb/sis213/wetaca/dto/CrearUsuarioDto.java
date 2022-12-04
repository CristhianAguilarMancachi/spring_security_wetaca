package bo.edu.ucb.sis213.wetaca.dto;

//creamos la clase CrearUsuarioDto
public class CrearUsuarioDto {
private String nombreUsuario_wtc_usuario;
private String contrasena_wtc_usuario;

//constructor de la clase
public CrearUsuarioDto() {
}

//constructor con parametros de la clase
public CrearUsuarioDto(String nombreUsuario_wtc_usuario, String contrasena_wtc_usuario) {
    this.nombreUsuario_wtc_usuario = nombreUsuario_wtc_usuario;
    this.contrasena_wtc_usuario = contrasena_wtc_usuario;
}

//getters y setters de la clase
public String getNombreUsuario_wtc_usuario() {
    return nombreUsuario_wtc_usuario;
}

public void setNombreUsuario_wtc_usuario(String nombreUsuario_wtc_usuario) {
    this.nombreUsuario_wtc_usuario = nombreUsuario_wtc_usuario;}
public String getContrasena_wtc_usuario() {
    return contrasena_wtc_usuario;
}

public void setContrasena_wtc_usuario(String contrasena_wtc_usuario) {
    this.contrasena_wtc_usuario = contrasena_wtc_usuario;
}

//metodo toString de la clase
@Override
public String toString() {
    return "CrearUsuarioDto{" + "nombreUsuario_wtc_usuario=" + nombreUsuario_wtc_usuario + ", contrasena_wtc_usuario=" + contrasena_wtc_usuario + '}';
}


}
