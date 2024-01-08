package micro.app.usuario.service;

import micro.app.usuario.dto.UsuarioDto;

public interface IUsuarioService {

    /**
     * Guardar en base de datos un usuario o lo actualiza
     *
     * @param usuario usuarioDTO
     * @return usuarioDTO
     */
    public UsuarioDto saveUsuario(final UsuarioDto usuarioDto);

    // FIXME HACER: Listar, Eliminar, actualizar
}
