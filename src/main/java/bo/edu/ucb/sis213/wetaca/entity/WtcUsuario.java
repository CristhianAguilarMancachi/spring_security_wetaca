package bo.edu.ucb.sis213.wetaca.entity;

import java.util.Date;
import java.util.Objects;

public class WtcUsuario {
    private Integer id_wtc_usuario; // id del usuario
    private String ci_wtc_usuario; // cedula del usuario
    private String nombre_wtc_usuario; // nombre del usuario
    private String apellido_wtc_usuario; // apellido del usuario
    private String email_wtc_usuario; // email del usuario
    private String fono_wtc_usuario; // telefono del usuario
    private int id_ubicacion;  // id de la ubicacion del usuario

    private String username; // nombre de usuario
    private String contrasena_wtc_usuario; // clave del usuario
    private Boolean estado_wtc_usuario; // estado del usuario
    private String txUsername; // usuario que creo el usuario
    private String txHost; // host del usuario
    private Date txDate; // fecha de creacion del usuario

    // constructor vacio
    public WtcUsuario() {
    }

    // constructor con parametros
    public WtcUsuario(Integer id_wtc_usuario, String ci_wtc_usuario, String nombre_wtc_usuario, String apellido_wtc_usuario, String email_wtc_usuario, String fono_wtc_usuario, int id_ubicacion, String username, String contrasena_wtc_usuario, Boolean estado_wtc_usuario, String txUsername, String txHost, Date txDate) {
        this.id_wtc_usuario = id_wtc_usuario;
        this.ci_wtc_usuario = ci_wtc_usuario;
        this.nombre_wtc_usuario = nombre_wtc_usuario;
        this.apellido_wtc_usuario = apellido_wtc_usuario;
        this.email_wtc_usuario = email_wtc_usuario;
        this.fono_wtc_usuario = fono_wtc_usuario;
        this.id_ubicacion = id_ubicacion;
        this.username = username;
        this.contrasena_wtc_usuario = contrasena_wtc_usuario;
        this.estado_wtc_usuario = estado_wtc_usuario;
        this.txUsername = txUsername;
        this.txHost = txHost;
        this.txDate = txDate;
    }
 
    // getters y setters
    public Integer getId_wtc_usuario() {
        return id_wtc_usuario;
    }
    public String getCi_wtc_usuario() {
        return ci_wtc_usuario;
    }
    public String getNombre_wtc_usuario() {
        return nombre_wtc_usuario;
    }
    public String getApellido_wtc_usuario() {
        return apellido_wtc_usuario;
    }
    public String getEmail_wtc_usuario() {
        return email_wtc_usuario;
    }
    public String getFono_wtc_usuario() {
        return fono_wtc_usuario;
    }
    public int getId_ubicacion() {
        return id_ubicacion;
    }
    public String getUsername() {
        return username;
    }
    public String getContrasena_wtc_usuario() {
        return contrasena_wtc_usuario;
    }
    public Boolean getEstado_wtc_usuario() {
        return estado_wtc_usuario;
    }
    public String getTxUsername() {
        return txUsername;
    }
    public String getTxHost() {
        return txHost;
    }
    public Date getTxDate() {
        return txDate;
    }
    public void setId_wtc_usuario(Integer id_wtc_usuario) {
        this.id_wtc_usuario = id_wtc_usuario;
    }
    public void setCi_wtc_usuario(String ci_wtc_usuario) {
        this.ci_wtc_usuario = ci_wtc_usuario;
    }
    public void setNombre_wtc_usuario(String nombre_wtc_usuario) {
        this.nombre_wtc_usuario = nombre_wtc_usuario;
    }
    public void setApellido_wtc_usuario(String apellido_wtc_usuario) {
        this.apellido_wtc_usuario = apellido_wtc_usuario;
    }
    public void setEmail_wtc_usuario(String email_wtc_usuario) {
        this.email_wtc_usuario = email_wtc_usuario;
    }
    public void setFono_wtc_usuario(String fono_wtc_usuario) {
        this.fono_wtc_usuario = fono_wtc_usuario;
    }
    public void setId_ubicacion(int id_ubicacion) {
        this.id_ubicacion = id_ubicacion;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setContrasena_wtc_usuario(String contrasena_wtc_usuario) {
        this.contrasena_wtc_usuario = contrasena_wtc_usuario;
    }
    public void setEstado_wtc_usuario(Boolean estado_wtc_usuario) {
        this.estado_wtc_usuario = estado_wtc_usuario;
    }
    public void setTxUsername(String txUsername) {
        this.txUsername = txUsername;
    }
    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }
    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WtcUsuario mrUser = (WtcUsuario) o;
        return id_wtc_usuario.equals(mrUser.id_wtc_usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_wtc_usuario);
    }
}

