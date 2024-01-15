package micro.app.usuario.service;

import micro.app.usuario.dto.UsuarioDto;

public interface IUsuarioService {

    /**
     * Guardar en base de datos un usuario o lo actualiza
     *
     * @param usuarioDto usuarioDTO
     * @return usuarioDTO
     */
    public UsuarioDto saveUsuario(final UsuarioDto usuarioDto);

    /**
     * Elimina al usuario que coincida con el email proporcionado
     * @param email
     */
    public void borradoUsuario(final String email);

}
