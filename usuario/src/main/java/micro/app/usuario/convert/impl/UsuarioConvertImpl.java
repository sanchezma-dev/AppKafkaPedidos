package micro.app.usuario.convert.impl;

import micro.app.usuario.convert.UsuarioConvert;
import micro.app.usuario.dto.UsuarioDto;
import micro.app.usuario.entity.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConvertImpl implements UsuarioConvert {

    @Override
    public UsuarioEntity convertToEntity(UsuarioDto source) {
        return null;
    }

    @Override
    public UsuarioDto convertToDto(UsuarioEntity source) {
        return null;
    }
}
