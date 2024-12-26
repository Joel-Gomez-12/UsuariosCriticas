package es.uah.usuarioscriticas.model;


import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Users", schema = "usuariospelidb")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario", nullable = false)
    private Integer idUsuario;

    @Column(name = "username", nullable = false, length = 45)
    private String nombre;

    @Column(name = "password", nullable = false, length = 60)
    private String clave;

    @Column(name = "correo", nullable = false, length = 45, unique = true)
    private String correo;

    @Column(name = "enable", nullable = false)
    private Boolean enable = false;


    @OneToMany(mappedBy = "usuario", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<Critica> criticas;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Users_has_Authorities", joinColumns = {
            @JoinColumn(name = "Users_idUsuario", referencedColumnName = "idUsuario")}, inverseJoinColumns = {
            @JoinColumn(name = "Authorities_idRol", referencedColumnName = "idRol")})
    private List<Rol> roles;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String username) {
        this.nombre = username;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String password) {
        this.clave = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public List<Critica> getCriticas() {
        return criticas;
    }

    public void setCriticas(List<Critica> criticas) {
        this.criticas = criticas;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return idUsuario != null && Objects.equals(idUsuario, usuario.idUsuario);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public void addCritica(Critica critica) {
        getCriticas().add(critica);
        critica.setUsuario(this);
    }

    public void removeCritica(Critica critica) {
        if (critica != null) {
            getCriticas().remove(critica);
        }
    }
}
