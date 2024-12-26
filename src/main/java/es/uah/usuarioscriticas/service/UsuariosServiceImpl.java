package es.uah.usuarioscriticas.service;


import es.uah.usuarioscriticas.dao.IUsuariosDAO;
import es.uah.usuarioscriticas.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosServiceImpl implements IUsuariosService {

    @Autowired
    IUsuariosDAO usuariosDAO;

    @Override
    public List<Usuario> buscarTodos() {
        return usuariosDAO.buscarTodos();
    }

    @Override
    public Usuario buscarUsuarioPorId(Integer idUsuario) {
        return usuariosDAO.buscarUsuarioPorId(idUsuario);
    }

    @Override
    public Usuario buscarUsuarioPorNombre(String nombre) {
        return usuariosDAO.buscarUsuarioPorNombre(nombre);
    }

    @Override
    public Usuario buscarUsuarioPorCorreo(String correo) {
        return usuariosDAO.buscarUsuarioPorCorreo(correo);
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuariosDAO.guardarUsuario(usuario);
    }

    @Override
    public void eliminarUsuario(Integer idUsuario) {
        usuariosDAO.eliminarUsuario(idUsuario);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        if (usuariosDAO.buscarUsuarioPorId(usuario.getIdUsuario()) != null){
            usuariosDAO.actualizarUsuario(usuario);
        }

    }

    @Override
    public void eliminarCritica(Integer idUsuario, Integer idCritica) {
        usuariosDAO.eliminarCritica(idUsuario, idCritica);
    }

}
