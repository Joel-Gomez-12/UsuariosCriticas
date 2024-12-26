package es.uah.usuarioscriticas.dao;

import es.uah.usuarioscriticas.model.Critica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICriticasJPA extends JpaRepository<Critica, Integer> {
    List<Critica> findByUsuarioIdUsuario(Integer idUsuario);
    List<Critica> findByIdPelicula(int idPelicula);
}
