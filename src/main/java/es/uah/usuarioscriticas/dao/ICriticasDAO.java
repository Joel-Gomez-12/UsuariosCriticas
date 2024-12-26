package es.uah.usuarioscriticas.dao;

import es.uah.usuarioscriticas.model.Critica;

import java.util.List;

public interface ICriticasDAO {
    List<Critica> buscarTodas();

    List<Critica> buscarCriticasPorIdPelicula(Integer idPelicula);

    Critica buscarCriticaPorId(Integer idCritica);

    List<Critica> buscarCriticasPorUsuario(Integer idUsuario);

    void guardarCritica(Critica critica);

    void eliminarCritica(Integer idCritica);

}
