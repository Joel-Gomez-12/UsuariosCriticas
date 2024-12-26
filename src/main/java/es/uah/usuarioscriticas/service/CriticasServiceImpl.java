package es.uah.usuarioscriticas.service;


import es.uah.usuarioscriticas.dao.ICriticasDAO;
import es.uah.usuarioscriticas.model.Critica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriticasServiceImpl implements ICriticasService{

    @Autowired
    ICriticasDAO criticasDAO;

    @Override
    public List<Critica> buscarTodas() {
        return criticasDAO.buscarTodas();
    }

    @Override
    public List<Critica> buscarCriticasPorIdPelicula(Integer idPelicula) {
        return criticasDAO.buscarCriticasPorIdPelicula(idPelicula);
    }

    @Override
    public Critica buscarCriticaPorId(Integer idCritica) {
        return criticasDAO.buscarCriticaPorId(idCritica);
    }

    @Override
    public List<Critica> buscarCriticasPorUsuario(Integer idUsuario) {
        return criticasDAO.buscarCriticasPorUsuario(idUsuario);
    }



    @Override
    public void guardarCritica(Critica critica) {
        criticasDAO.guardarCritica(critica);
    }

    @Override
    public void eliminarCritica(Integer idCritica) {
        criticasDAO.eliminarCritica(idCritica);
    }

}
