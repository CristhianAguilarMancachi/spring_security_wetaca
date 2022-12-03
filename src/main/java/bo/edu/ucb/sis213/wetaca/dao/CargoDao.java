package bo.edu.ucb.sis213.wetaca.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import bo.edu.ucb.sis213.wetaca.entity.Cargo;

@Component
public interface CargoDao {
    
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
