package com.estramipyme.data.repositories;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.estramipyme.data.interfaces.IRepository;
import com.estramipyme.data.models.Rol;

@Repository
public class RolRepository implements IRepository<Rol,Integer> {

    private final JdbcTemplate jdbcTemplate;
    
    public RolRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;   
    }
    
    public Rol findById(Integer id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM \"Rol\" WHERE id = ?", (rs,rowNum)->{
                Rol Rol = new Rol();
                Rol.setId(rs.getInt("id"));
                Rol.setNombreRol(rs.getString("nombreRol"));
                Rol.setFechaCreacionRol(rs.getDate("fechaCreacionRol"));
                Rol.setActiveRol(rs.getBoolean("isActiveRol"));
                return Rol;
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    
    public List<Rol> findAll() {
        try {
            return jdbcTemplate.query("SELECT * FROM \"Rol\"", (rs,rowNum)->{
               Rol rol = new Rol();
               rol.setId(rs.getInt("id"));
               rol.setNombreRol(rs.getString("nombreRol"));
               rol.setFechaCreacionRol(rs.getDate("fechaCreacionRol"));
               rol.setActiveRol(rs.getBoolean("isActiveRol"));
                return rol;
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    
    public void save(Rol entity) {
        try {
            jdbcTemplate.update("INSERT INTO \"Rol\" (\"nombreRol\", \"fechaCreacionRol\", \"isActiveRol\") VALUES (?, CURRENT_TIMESTAMP, '1')", entity.getNombreRol());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    
    public void update(Rol entity) {

        var isActiveRol = entity.isActiveRol() ? "1" : "0";
        var sql = "UPDATE \"Rol\" SET \"nombreRol\" = '" + entity.getNombreRol() + "', \"isActiveRol\" = '" + isActiveRol + "' WHERE \"id\" = " + entity.getId();
        System.out.println("SQL: " + sql);
        try {
            jdbcTemplate.update(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    
    public void delete(Integer id) {
        try {
            jdbcTemplate.update("DELETE FROM \"Rol\" WHERE id = ?", id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
    
}
