package bo.edu.ucb.sis213.wetaca.entity;

import java.util.Date;
import java.util.Objects;
//clase de la tabla wtc usuario
public class Wtc_usuario {
    private Integer id_wtc_usuario; //id de la tabla wtc usuario
    private String ci_wtc_usuario; //ci de la tabla wtc usuario
    private String nombre_wtc_usuario; //nombre del cliente de la tabla wtc usuario
    private String apellido_wtc_usuario; //apellido del cliente de la tabla wtc usuario
    private String correo_wtc_usuario; //correo del cliente de la tabla wtc usuario
    private String fono_wtc_usuario; //telefono del cliente de la tabla wtc usuario
    private int id_ubicación; //id de la ubicacion del cliente de la tabla wtc usuario
    private Boolean estado_wtc_usuario; //estado del cliente de la tabla wtc usuario
    private String nombreusuario_wtc_usuario; //nombre de usuario del cliente de la tabla wtc usuario
    private String contrasena_wtc_usuario; //contraseña del cliente de la tabla wtc usuario
    private String txUsername;
    private String txHost;
    private Date txDate;

    public Wtc_usuario() {
    }

    //constructor de la clase
    public Wtc_usuario(Integer id_wtc_usuario, String ci_wtc_usuario, String nombre_wtc_usuario, String apellido_wtc_usuario, String correo_wtc_usuario, String fono_wtc_usuario, int id_ubicación, Boolean estado_wtc_usuario, String nombreusuario_wtc_usuario, String contrasena_wtc_usuario, String txUsername, String txHost, Date txDate) {
        this.id_wtc_usuario = id_wtc_usuario;
        this.ci_wtc_usuario = ci_wtc_usuario;
        this.nombre_wtc_usuario = nombre_wtc_usuario;
        this.apellido_wtc_usuario = apellido_wtc_usuario;
        this.correo_wtc_usuario = correo_wtc_usuario;
        this.fono_wtc_usuario = fono_wtc_usuario;
        this.id_ubicación = id_ubicación;
        this.estado_wtc_usuario = estado_wtc_usuario;
        this.nombreusuario_wtc_usuario = nombreusuario_wtc_usuario;
        this.contrasena_wtc_usuario = contrasena_wtc_usuario;
        this.txUsername = txUsername;
        this.txHost = txHost;
        this.txDate = txDate;
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

    public int getId_ubicación() {
        return id_ubicación;
    }

    public void setId_ubicación(int id_ubicación) {
        this.id_ubicación = id_ubicación;
    }

    public Boolean getEstado_wtc_usuario() {
        return estado_wtc_usuario;
    }

    public void setEstado_wtc_usuario(Boolean estado_wtc_usuario) {
        this.estado_wtc_usuario = estado_wtc_usuario;
    }

    public String getNombreusuario_wtc_usuario() {
        return nombreusuario_wtc_usuario;
    }

    public void setNombreusuario_wtc_usuario(String nombreusuario_wtc_usuario) {
        this.nombreusuario_wtc_usuario = nombreusuario_wtc_usuario;
    }

    public String getContrasena_wtc_usuario() {
        return contrasena_wtc_usuario;
    }

    public void setContrasena_wtc_usuario(String contrasena_wtc_usuario) {
        this.contrasena_wtc_usuario = contrasena_wtc_usuario;
    }

    public String getTxUsername() {
        return txUsername;
    }

    public void setTxUsername(String txUsername) {
        this.txUsername = txUsername;
    }

    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    public Date getTxDate() {
        return txDate;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }

    
    @Override
    //metodo toString de la clase
    public String toString() {
        return "MrUser{" +
                "userId=" + id_wtc_usuario +
                ", username='" + ci_wtc_usuario + '\'' +
                ", secret='" + nombre_wtc_usuario + '\'' +
                ", status=" + estado_wtc_usuario +
                ", txUsername='" + txUsername + '\'' +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                '}';
    }

    @Override
    //metodo equals de la clase
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wtc_usuario mrUser = (Wtc_usuario) o;
        return id_wtc_usuario.equals(mrUser.id_wtc_usuario);
    }

    @Override
    //metodo hashCode de la clase
    public int hashCode() {
        return Objects.hash(id_wtc_usuario); 
    }
}