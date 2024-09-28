package com.estramipyme.api.dto;

public class UserDto {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String rol;
    private Boolean isActive;

    public UserDto() {
    }

    public UserDto(Integer id, String name, String email, String password, String rol, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.rol = rol;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
