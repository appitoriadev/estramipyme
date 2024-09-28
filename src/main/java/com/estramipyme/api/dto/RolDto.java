package com.estramipyme.api.dto;

import java.util.Date;

public class RolDto {
    
    private int id;
    private String nombreRol;
    private Date fechaCreacionRol;
    private Boolean isActiveRol;

    public RolDto() {
    }

    public RolDto(int id, String nombreRol, Date fechaCreacionRol, Boolean isActiveRol) {
        this.id = id;
        this.nombreRol = nombreRol;
        this.fechaCreacionRol = fechaCreacionRol;
        this.isActiveRol = isActiveRol;
    }

    public int getId() {
        return id;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public Date getFechaCreacionRol() {
        return fechaCreacionRol;
    }

    public Boolean getIsActiveRol() {
        return isActiveRol;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public void setFechaCreacionRol(Date fechaCreacionRol) {
        this.fechaCreacionRol = fechaCreacionRol;
    }

    public void setIsActiveRol(Boolean isActiveRol) {
        this.isActiveRol = isActiveRol;
    }

}
