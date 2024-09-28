package com.estramipyme.data.repositories;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.estramipyme.data.interfaces.IRepository;
import com.estramipyme.data.models.Rol;

@Repository
public class RolRepository implements IRepository<Rol,Integer> {

    private final JdbcTemplate _jdbcTemplate;
    
    public RolRepository(JdbcTemplate jdbcTemplate) {
        this._jdbcTemplate = jdbcTemplate;   
    }
    
    public Rol findById(Integer id) {
        try {
            return _jdbcTemplate.queryForObject("SELECT * FROM Rol WHERE id = ?", (rs,rowNum)->{
                Rol rol = new Rol();
                rol.setId(rs.getInt("id"));
                rol.setNombreRol(rs.getString("nombreRol"));
                rol.setFechaCreacionRol(rs.getDate("fechaCreacionRol"));
                rol.setActiveRol(rs.getBoolean("isActiveRol"));
                return rol;
            });
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    
    public List<Rol> findAll() {
        try {
            return _jdbcTemplate.query("SELECT * FROM Rol", (rs,rowNum)->{
                Rol rol = new Rol();
                rol.setId(rs.getInt("id"));
                rol.setNombreRol(rs.getString("nombreRol"));
                rol.setFechaCreacionRol(rs.getDate("fechaCreacionRol"));
                rol.setActiveRol(rs.getBoolean("isActiveRol"));
                return rol;
            });
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    
    public void save(Rol entity) {
        try {
            _jdbcTemplate.update("INSERT INTO \"Rol\" (\"nombreRol\", \"fechaCreacionRol\", \"isActiveRol\") VALUES (?, CURRENT_TIMESTAMP, '1')", entity.getNombreRol());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    
    public void update(Rol entity) {

        try {
            _jdbcTemplate.update("UPDATE Rol SET \"nombreRol\" = ?, \"isActiveRol\" = ? WHERE \"id\" = ? ", entity.getNombreRol(), entity.isActiveRol(), entity.getId());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    
    public void delete(Integer id) {
        try {
            _jdbcTemplate.update("DELETE FROM Rol WHERE id = ?", id);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
}
