package es.uah.usuarioscriticas.dao;

import es.uah.usuarioscriticas.model.Usuario;

import java.util.List;

public interface IUsuariosDAO {
    List<Usuario> buscarTodos();
    Usuario buscarUsuarioPorId(Integer idUsuario);
    Usuario buscarUsuarioPorNombre(String nombre);
    Usuario buscarUsuarioPorCorreo(String correo);

    void guardarUsuario(Usuario usuario);
    void eliminarUsuario(Integer idUsuario);
    void actualizarUsuario(Usuario usuario);
    void eliminarCritica(Integer idUsuario, Integer idCritica);
}
