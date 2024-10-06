package com.estramipyme.api.service;

import org.springframework.stereotype.Service;

import com.estramipyme.api.dto.RolDto;
import com.estramipyme.data.models.Rol;
import com.estramipyme.data.repositories.RolRepository;
import java.util.ArrayList;
import java.util.List;

@Service
public class RolService {

    private final RolRepository rolRepository;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public RolDto findById(Integer id) {
        var rol = rolRepository.findById(id);
        return new RolDto(
            rol.getId(),
            rol.getNombreRol(),
            rol.getFechaCreacionRol(),
            rol.isActiveRol()
        );
    }

    public List<RolDto> findAll() {
        List<RolDto> roles = new ArrayList<>();
        List<Rol> rols = rolRepository.findAll();
        for (Rol rol : rols) {
            roles.add(
                new RolDto(
                    rol.getId(),
                    rol.getNombreRol(),
                    rol.getFechaCreacionRol(),
                    rol.isActiveRol()
                )
            );
        }

        return roles;
    }

    public void save(RolDto rolDto) {
        var rol = new Rol();
        rol.setNombreRol(rolDto.getNombreRol());
        rol.setActiveRol(true);
        rol.setFechaCreacionRol(rolDto.getFechaCreacionRol());
        rolRepository.save(rol);
    }

    public void update(RolDto rolDto) {
        var rol = new Rol();
        rol.setId(rolDto.getId());
        rol.setNombreRol(rolDto.getNombreRol());
        rol.setActiveRol(rolDto.getIsActiveRol());
        rol.setFechaCreacionRol(rolDto.getFechaCreacionRol());
        rolRepository.update(rol);
    }

    public void delete(Integer id) {
        rolRepository.delete(id);
    }
}
