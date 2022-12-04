package bo.edu.ucb.sis213.wetaca.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import bo.edu.ucb.sis213.wetaca.entity.Cargo;

@Component
public interface CargoDao {
    //Selecciona cargo por nombre de usuario
    @Select("""
            SELECT cargo.cargo_id, cargo.descripcion_cargo, usr.id_wtc_usuario, cargo.tx_usuario, cargo.tx_host, cargo.tx_fecha
            FROM cargo cargo
                     JOIN wtc_usuario_cargo usuario_cargo ON usuario_cargo.cargo_id = cargo.cargo_id
                     JOIN wtc_usuario usr ON usr.id_wtc_usuario = usuario_cargo.id_wtc_usuario
            WHERE usr.nombreusuario_wtc_usuario = #{nombreusuario_wtc_usuario}
             
            """)
    public List<Cargo> buscarCargoByUsername(String nombreusuario_wtc_usuario);

   //selecciona un cargo por su id_wtc_usuario
    @Select("""
              Select id_cargo, descripcion_cargo, id_wtc_usuario
              From 
                cargo
              Where
                id_cargo = #{id_wtc_cargo}
                AND status_wtc_cargo = true
              """)
    public Integer buscarCargoPorId(Integer id_wtc_cargo);

    //inserta un cargo nuevo
    @Select("""
              Insert Into cargo (id_cargo, descripcion_cargo, id_wtc_usuario)
              Values (#{id_cargo}, #{descripcion_cargo}, #{id_wtc_usuario})
              """)
    public void agregarNuevoCargo(Cargo cargo);
}
