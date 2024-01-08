package micro.app.usuario.convert;

import micro.app.usuario.dto.UsuarioDto;
import micro.app.usuario.entity.UsuarioEntity;

public interface IUsuarioConvert {

    /**
     * Devuelve un objeto UsuarioEntity a partir de un UsuarioDto
     * @param source UsuarioDto
     * @return UsuarioEntity
     */
    public UsuarioEntity convertToEntity (final UsuarioDto source);

    /**
     * Devuelve un objeto UsuarioDto a partir de un UsuarioEntity
     * @param source UsuarioEntity
     * @return UsuarioDto
     */
    public UsuarioDto convertToDto (final UsuarioEntity source);
}
