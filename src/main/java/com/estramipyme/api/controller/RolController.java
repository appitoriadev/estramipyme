package com.estramipyme.api.controller;

import java.util.ArrayList;
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


@RestController
@RequestMapping("/api/rol")
public class RolController {

    private final RolService _rolService;

	//Constructor de nuestro controlador
    public RolController(RolService rolService) {
        this._rolService = rolService;
    }

    @GetMapping("/")
	@Operation(summary="Obtener Rol", description="Usado para obtener Rol")
	public List<RolDto> getAllRoll() {

		List<RolDto> roles = new ArrayList();
		roles = _rolService.findAll();
		return roles;
	}

	@GetMapping("/{id}")
	@Operation(summary="Obtener Rol por ID", description="Usado para obtener Rol por ID")
	public RolDto getRol(@Parameter(description = "Id del usuario", required = true)@PathVariable Integer id) {
		var rol = _rolService.findById(id);
		return rol;
	}
	
	
	@PostMapping()
	@Operation(summary="Crea rol", description="Usado para crear un rol")
	public void createUser(@RequestBody RolDto rolDto)
	////(@RequestBody(description="Crear Usuario", required=true))
	{
		//// llamr servicio para crear su rol a través de los DTO
		_rolService.save(rolDto);
		// return rolDto;
	}
}
