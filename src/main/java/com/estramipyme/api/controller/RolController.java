package com.estramipyme.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.estramipyme.api.service.RolService;
import com.estramipyme.api.dto.RolDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/rol")
public class RolController {
	
    private final RolService rolService;

	//Constructor de nuestro controlador
    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping("/")
	@Operation(summary="Obtener Rol", description="Usado para obtener Rol")
	public List<RolDto> getAllRoll() {

		return rolService.findAll();
	}

	@GetMapping("/{id}")
	@Operation(summary="Obtener Rol por ID", description="Usado para obtener Rol por ID")
	public RolDto getRol(@Parameter(description = "Id del usuario", required = true)@PathVariable Integer id) {

		return rolService.findById(id);
	}
	
	@PutMapping("/{id}")
	public RolDto updateRol(@PathVariable Integer id, @RequestBody RolDto entity) {
		entity.setId(id);
		rolService.update(entity);
		return entity;
	}
	
	@PostMapping("/")
	@Operation(summary="Crea rol", description="Usado para crear un rol")
	public void createRol(@RequestBody RolDto rolDto)
	{
		rolService.save(rolDto);
	}
}
