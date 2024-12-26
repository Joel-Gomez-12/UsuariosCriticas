package es.uah.usuarioscriticas.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "Criticas", schema = "usuariospelidb")
public class Critica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCritica;

    @Column(name = "idPelicula", nullable = false)
    private Integer idPelicula;

    @Column(name = "valoracion", nullable = false)
    private String valoracion;

    @Column(name = "nota" , nullable = false)
    @Min(1)
    @Max(10)
    private Integer nota;

    @Column(name = "fecha", nullable = false, updatable = false)
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "Users_idUsuario", referencedColumnName = "idUsuario", nullable = false)
    @JsonIgnoreProperties("criticas")
    private Usuario usuario;

    @PrePersist
    protected void onCreate() {
        this.fecha = LocalDateTime.now();
    }

    public Integer getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        if (nota < 1 || nota > 10) {
            throw new IllegalArgumentException("La nota debe estar entre 1 y 10.");
        }
        this.nota = nota;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Critica critica = (Critica) o;
        return idCritica != null && Objects.equals(idCritica, critica.idCritica);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
